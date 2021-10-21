package com.example.renta.datalayer.local

import androidx.room.*
import com.example.renta.datalayer.local.dto.CachingUser

@Dao
interface CachingDao {

    @Query("SELECT * FROM CachingUsers")
    fun allCachingUsers(): List<CachingUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cachingListUsers: List<CachingUser>)

    @Delete
    fun delete(cachingListUsers: List<CachingUser>)

}