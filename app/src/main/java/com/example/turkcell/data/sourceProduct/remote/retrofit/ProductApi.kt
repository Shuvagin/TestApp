package com.example.turkcell.data.sourceProduct.remote.retrofit

import com.example.turkcell.data.sourceProduct.remote.model.RemoteProductDetail
import com.example.turkcell.data.sourceProduct.remote.model.RemoteProducts
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {

    @GET("list")
    suspend fun getProducts(): RemoteProducts

    @GET("{product_id}/detail")
    suspend fun getProduct(@Path("product_id") productId: String): RemoteProductDetail
}
