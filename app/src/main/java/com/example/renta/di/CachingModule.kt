package com.example.renta.di

import android.content.Context
import androidx.room.Room
import com.example.renta.datalayer.local.CachingDB
import com.example.renta.datalayer.local.CachingDao
import dagger.Module
import dagger.Provides

@Module
class CachingModule {


    @Provides
    fun provideFavoriteDao(context: Context): CachingDao {
        val db = Room.databaseBuilder(
            context,
            CachingDB::class.java,
            DB_NAME
        )
            .build()
        return db.cachingDao()
    }

    companion object {
        private const val DB_NAME = "Caching.db"
    }


}