package com.example.renta.datalayer.remote

import com.example.renta.datalayer.remote.dto.ResponseData
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET


interface ApiService {

    @GET("api/users")
    fun getUsersList(): Observable<ResponseData>

}