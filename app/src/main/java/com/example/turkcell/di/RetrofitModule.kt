package com.example.turkcell.di

import com.example.turkcell.data.sourceProduct.remote.retrofit.ProductApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object RetrofitModule {

    private const val AMAZON_URL =
        "https://s3-eu-west-1.amazonaws.com/developer-application-test/cart/"

    @Provides
    @Reusable
    fun provideRandomUser(): ProductApi =
        Retrofit.Builder()
            .baseUrl(AMAZON_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ProductApi::class.java)
}
