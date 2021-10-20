package com.example.renta.di

import android.content.Context
import androidx.room.Room
import com.example.renta.datalayer.local.CachingDB
import com.example.renta.datalayer.local.CachingDao
import com.example.renta.datalayer.repos.CachingRepositoryImpl
import com.example.renta.domain.CachingRepository
import dagger.Provides

class CachingModule {

    @Provides
    fun provideCachingRepository(cachingDao: CachingDao): CachingRepository {
        return CachingRepositoryImpl(cachingDao)
    }


    @Provides
    fun provideFavoriteDao(context: Context): CachingDao {
        val db = Room.databaseBuilder(
            context,
            CachingDB::class.java,
            Companion.DB_NAME
        )
            .build()
        return db.cachingDao()
    }

    companion object {
        private const val DB_NAME = "Caching.db"
    }


}