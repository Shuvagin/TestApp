package com.example.turkcell.data.source

import com.example.turkcell.data.model.ProductDetail
import com.example.turkcell.data.model.Products

interface ProductRepository {

    suspend fun getProducts() : Products

    suspend fun getProduct(productId : Int) : ProductDetail

}