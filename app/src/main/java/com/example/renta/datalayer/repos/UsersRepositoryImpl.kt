package com.example.renta.datalayer.repos

import com.example.renta.datalayer.local.CachingDao
import com.example.renta.datalayer.remote.RemoteDataSource
import com.example.renta.domain.UsersRepository
import com.example.renta.domain.entites.User
import io.reactivex.rxjava3.core.Single

class UsersRepositoryImpl(
    private val dataSource: RemoteDataSource,
    private val dao: CachingDao,
) : UsersRepository {

    override fun getListUsers(): Single<List<User>> {
        TODO("Not yet implemented")
    }

}