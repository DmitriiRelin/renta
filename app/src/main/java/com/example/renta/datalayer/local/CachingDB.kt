package com.example.renta.datalayer.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.renta.datalayer.local.dto.CachingUser

@Database(entities = [CachingUser::class], version = 1, exportSchema = false)
abstract class CachingDB : RoomDatabase() {
    abstract fun cachingDao(): CachingDao
}