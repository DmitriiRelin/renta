package com.example.renta.datalayer.local

import androidx.room.*
import com.example.renta.datalayer.local.dto.CachingUser

@Dao
interface CachingDao {
    @Query("SELECT * FROM CachingUsers")
    suspend fun allPictures(): List<CachingUser>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cachingUser: CachingUser)

    @Delete
    suspend fun delete(cachingUser: CachingUser)
}