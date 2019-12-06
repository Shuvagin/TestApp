package com.example.turkcell.di

import android.app.Application
import com.example.turkcell.ui.main.MainViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, RetrofitModule::class,ProductRepositoryModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance applicationContext: Application): ApplicationComponent
    }

    val mainViewModel: MainViewModel
}
