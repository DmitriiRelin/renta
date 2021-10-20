package com.example.renta.domain.uc

import com.example.renta.datalayer.remote.dto.Users
import com.example.renta.domain.UsersRepository
import com.example.renta.domain.entites.User
import io.reactivex.rxjava3.core.Single

class GetUsersListUseCase(private val repository: UsersRepository) {

    fun getUserList(): Single<List<User>> {
        return repository.getListUsers()
    }

}