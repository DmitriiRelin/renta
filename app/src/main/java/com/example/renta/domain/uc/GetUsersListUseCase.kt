package com.example.renta.domain.uc

import com.example.renta.LoadingResult
import com.example.renta.domain.UsersRepository
import com.example.renta.domain.entites.User
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetUsersListUseCase @Inject constructor(private val repository: UsersRepository) {

    fun getUserList(): Observable<LoadingResult<List<User>>> {
        return repository.getListUsers()
    }

}