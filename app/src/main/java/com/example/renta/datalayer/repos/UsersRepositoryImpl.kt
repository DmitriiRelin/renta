package com.example.renta.datalayer.repos

import com.example.renta.LoadingResult
import com.example.renta.datalayer.local.CachingDao
import com.example.renta.datalayer.local.dto.CachingUser
import com.example.renta.datalayer.remote.RemoteDataSource
import com.example.renta.datalayer.remote.dto.UserData
import com.example.renta.domain.UsersRepository
import com.example.renta.domain.entites.User
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val dao: CachingDao,
) : UsersRepository {

    override fun getListUsers(): Observable<LoadingResult<List<User>>> {
        return Observable.create { emiter ->
            emiter.onNext(
                LoadingResult.Success(
                    data = dao.allCachingUsers().map { cachingUserToUser(it) },
                    isFromCache = true
                )
            )
            emiter.onNext(LoadingResult.Loading())
            dataSource.getListUsers()
                .delay(5, TimeUnit.SECONDS)
                .subscribe ({ response ->
                    dao.insert(response.data.map { userDataToCachingUser(it) })
                    emiter.onNext(
                        LoadingResult.Success(
                            data = response.data.map { userDataToUser(it) },
                            isFromCache = false
                        )
                    )
                }, {
                    emiter.onNext(LoadingResult.Error(it))
                })

        }
    }

    fun cachingUserToUser(cachingUser: CachingUser): User {
        return User(
            cachingUser.id,
            cachingUser.email,
            cachingUser.first_name,
            cachingUser.last_name,
            cachingUser.avatar
        )
    }

    fun userDataToUser(userData: UserData): User {
        return User(
            userData.id,
            userData.email,
            userData.first_name,
            userData.last_name,
            userData.avatar
        )
    }

    fun userDataToCachingUser(userData: UserData): CachingUser {
        return CachingUser(
            userData.id,
            userData.email,
            userData.first_name,
            userData.last_name,
            userData.avatar
        )
    }

}