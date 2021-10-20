package com.example.renta

import android.app.Application
import com.example.renta.di.AppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

//    override fun onCreate() {
//        super.onCreate()
//        appComponent = DaggerAppComponent.builder().applicationContext(this).build()
//    }

}