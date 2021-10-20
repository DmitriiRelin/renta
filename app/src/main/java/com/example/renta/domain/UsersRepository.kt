package com.example.renta.domain

import com.example.renta.domain.entites.User
import io.reactivex.rxjava3.core.Single

interface UsersRepository {

    fun getListUsers(): Single<List<User>>

}