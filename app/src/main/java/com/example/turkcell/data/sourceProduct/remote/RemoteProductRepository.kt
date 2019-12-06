package com.example.turkcell.data.sourceProduct.remote

import com.example.turkcell.data.sourceProduct.remote.retrofit.ProductApi
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteProductRepository @Inject constructor(
    private val productApi: ProductApi
) {

    suspend fun getProducts() = withContext(Dispatchers.IO) {
        productApi.getProducts()
    }

    suspend fun getProduct(productId: String) = withContext(Dispatchers.IO) {
        productApi.getProduct(productId)
    }
}
