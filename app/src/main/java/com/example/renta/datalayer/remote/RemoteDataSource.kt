package com.example.renta.datalayer.remote

import com.example.renta.datalayer.remote.dto.ResponseData
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val usersApi: ApiService) {

    fun getListUsers(): Observable<ResponseData> {
        return usersApi.getUsersList()
    }

}