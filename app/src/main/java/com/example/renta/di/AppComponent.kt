package com.example.renta.di

import android.content.Context
import com.example.renta.ui.home.HomeFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [UsersModule::class, CachingModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(applicationContext: Context): Builder
        fun build(): AppComponent
    }

    fun inject(homeFragment: HomeFragment)
}