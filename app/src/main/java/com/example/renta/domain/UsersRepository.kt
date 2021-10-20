package com.example.renta.domain

import com.example.renta.LoadingResult
import com.example.renta.domain.entites.User
import io.reactivex.rxjava3.core.Observable

interface UsersRepository {

    fun getListUsers(): Observable<LoadingResult<List<User>>>

}