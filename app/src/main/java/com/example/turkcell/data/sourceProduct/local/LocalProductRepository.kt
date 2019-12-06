package com.example.turkcell.data.sourceProduct.local

import androidx.lifecycle.LiveData
import com.example.turkcell.data.sourceProduct.local.db.ProductDatabase
import com.example.turkcell.data.sourceProduct.local.model.LocalProduct
import javax.inject.Inject

class LocalProductRepository @Inject constructor(private val productDatabase: ProductDatabase) {

    suspend fun saveProducts(list: List<LocalProduct>) {
        productDatabase.productDao().insert(list)
    }

    suspend fun getProducts(): LiveData<List<LocalProduct>> {
        return productDatabase.productDao().getLocalProducts()
    }

    suspend fun getProduct(productId: String): LiveData<LocalProduct> {
        return productDatabase.productDao().getLocalProduct(productId)
    }

    suspend fun updateProductDescription(productId: String, description: String) {
        return productDatabase.productDao().updateProductDescription(productId, description)
    }
}