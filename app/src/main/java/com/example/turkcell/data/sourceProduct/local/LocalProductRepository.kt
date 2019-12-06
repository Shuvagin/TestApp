package com.example.turkcell.data.sourceProduct.local

import androidx.lifecycle.LiveData
import com.example.turkcell.data.sourceProduct.ProductRepository
import com.example.turkcell.data.sourceProduct.local.db.ProductDatabase
import com.example.turkcell.data.sourceProduct.local.model.LocalProduct
import javax.inject.Inject

class LocalProductRepository @Inject constructor(private val productDatabase: ProductDatabase) :
    ProductRepository<LiveData<List<LocalProduct>>, LocalProduct> {

    override suspend fun saveProducts(list: LiveData<List<LocalProduct>>) {
        list.value?.let {
            productDatabase.productDao().insert(it)
        }
    }

    override suspend fun getProducts(): LiveData<List<LocalProduct>> {
        return productDatabase.productDao().getLocalProducts()
    }

    override suspend fun getProduct(productId: Int): LocalProduct {
        return productDatabase.productDao().getLocalProduct(productId)
    }
}