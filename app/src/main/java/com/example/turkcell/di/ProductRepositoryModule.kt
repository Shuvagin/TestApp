package com.example.turkcell.di

import androidx.lifecycle.LiveData
import com.example.turkcell.data.sourceProduct.remote.retrofit.ProductApi
import com.example.turkcell.data.sourceProduct.ProductRepository
import com.example.turkcell.data.sourceProduct.local.LocalProductRepository
import com.example.turkcell.data.sourceProduct.local.db.ProductDatabase
import com.example.turkcell.data.sourceProduct.local.model.LocalProduct
import com.example.turkcell.data.sourceProduct.remote.RemoteProductRepository
import com.example.turkcell.data.sourceProduct.remote.model.ProductDetail
import com.example.turkcell.data.sourceProduct.remote.model.Products
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
    fun getLocalProductRepository(productDatabase: ProductDatabase): ProductRepository<LiveData<List<LocalProduct>>,LocalProduct> {
        return LocalProductRepository(productDatabase)
    }

    @RemoteProductRepo
    @Provides
    @Reusable
    fun getRemoteProductRepository(api: ProductApi): ProductRepository<Products, ProductDetail> {
        return RemoteProductRepository(api)
    }
}
