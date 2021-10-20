package com.example.renta.datalayer.repos

import com.example.renta.datalayer.local.CachingDao
import com.example.renta.datalayer.remote.RemoteDataSource
import com.example.renta.domain.CachingRepository
import com.example.renta.domain.UsersRepository
import com.example.renta.domain.entites.User
import io.reactivex.rxjava3.core.Single

class CachingRepositoryImpl(
    cachingDao: CachingDao
) : CachingRepository {

    override fun addToCache(user: User) {
        TODO("Not yet implemented")
    }

    override fun removeFromCache(user: User) {
        TODO("Not yet implemented")
    }

    override fun getCacheList(): List<User> {
        TODO("Not yet implemented")
    }


}