package com.example.renta.domain

import com.example.renta.domain.entites.User

interface CachingRepository {

    fun addToCache(user: User)

    fun removeFromCache(user: User)

    fun getCacheList(): List<User>

}