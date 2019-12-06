package com.example.turkcell.data.sourceProduct

interface ProductRepository<T, F> {

    suspend fun getProducts(): T

    suspend fun getProduct(productId: Int): F

    suspend fun saveProducts(list:T)

}