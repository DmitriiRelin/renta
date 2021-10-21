package com.example.renta.datalayer.remote

import com.example.renta.datalayer.remote.dto.ResponseData
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET


interface ApiService {

    @GET(GET_VALUE)
    fun getUsersList(): Observable<ResponseData>

    companion object {
        private const val GET_VALUE = "api/users"
    }
}