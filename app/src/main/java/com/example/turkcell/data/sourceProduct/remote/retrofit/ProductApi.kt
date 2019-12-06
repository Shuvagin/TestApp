package com.example.turkcell.data.sourceProduct.remote.retrofit

import com.example.turkcell.data.sourceProduct.remote.model.ProductDetail
import com.example.turkcell.data.sourceProduct.remote.model.Products
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {

    @GET("cart/list")
    suspend fun getProducts(): Products

    @GET("cart/{product_id}/detail ")
    suspend fun getProduct(@Query("product_id") productId: Int): ProductDetail
}
