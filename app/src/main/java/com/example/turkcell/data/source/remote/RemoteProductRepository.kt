package com.example.turkcell.data.source.remote

import com.example.turkcell.data.model.ProductDetail
import com.example.turkcell.data.model.Products
import com.example.turkcell.data.retrofit.ProductApi
import com.example.turkcell.data.source.ProductRepository
import javax.inject.Inject

class RemoteProductRepository @Inject constructor(
    private val productApi: ProductApi
) : ProductRepository {

    override suspend fun getProducts(): Products {
       return productApi.getProducts()
    }

    override suspend fun getProduct(productId : Int): ProductDetail {
        return productApi.getProduct(productId)
    }

}