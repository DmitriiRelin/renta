package com.example.renta.datalayer.remote

import com.example.renta.datalayer.remote.dto.Users
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET


interface ApiService {

    @GET("api/users")
    fun getUsersList(): Single<Users>


}