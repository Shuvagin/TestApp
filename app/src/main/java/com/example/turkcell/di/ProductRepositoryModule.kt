package com.example.turkcell.di

import com.example.turkcell.data.retrofit.ProductApi
import com.example.turkcell.data.source.ProductRepository
import com.example.turkcell.data.source.local.LocalProductRepository
import com.example.turkcell.data.source.remote.RemoteProductRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Qualifier

@Module
object ProductRepositoryModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalProductRepo

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RemoteProductRepo

    @LocalProductRepo
    @Provides
    @Reusable
    fun getLocalProductRepository(api: ProductApi): ProductRepository {
        return LocalProductRepository()
    }

    @RemoteProductRepo
    @Provides
    @Reusable
    fun getRemoteProductRepository(api: ProductApi): ProductRepository {
        return RemoteProductRepository(api)
    }
}
