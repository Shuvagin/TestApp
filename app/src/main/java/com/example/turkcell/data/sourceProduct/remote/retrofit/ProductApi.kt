package com.example.turkcell.data.sourceProduct.remote.retrofit

import com.example.turkcell.data.sourceProduct.remote.model.ProductDetail
import com.example.turkcell.data.sourceProduct.remote.model.Products
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {

    @GET("list")
    suspend fun getProducts(): Products

    @GET("{product_id}/detail")
    suspend fun getProduct(@Path("product_id") productId: String): ProductDetail
}
