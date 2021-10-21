package com.example.renta.di

import com.example.renta.datalayer.local.CachingDao
import com.example.renta.datalayer.remote.ApiService
import com.example.renta.datalayer.remote.RemoteDataSource
import com.example.renta.datalayer.repos.UsersRepositoryImpl
import com.example.renta.domain.UsersRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class UsersModule {


    @Provides
    fun providesUsersApi(): ApiService {
        val apiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(GsonBuilder().setLenient().create())
            )
            .build()
            .create(ApiService::class.java)
        return apiService
    }


    @Provides
    fun provideUsersRepository(
        dataSource: RemoteDataSource,
        cachingDao: CachingDao,
    ): UsersRepository {
        return UsersRepositoryImpl(dataSource, cachingDao)
    }

    companion object {
        private const val BASE_URL = "https://reqres.in/"
    }

}