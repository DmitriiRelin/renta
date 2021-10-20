package com.example.renta.datalayer.remote

import com.example.renta.datalayer.remote.dto.Users
import io.reactivex.rxjava3.core.Single

class RemoteDataSource (private val usersApi: ApiService) {

    fun getListCinema(): Single<Users> {
        return usersApi.getUsersList()
    }

}