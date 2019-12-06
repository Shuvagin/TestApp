package com.example.turkcell.data.source.local

import com.example.turkcell.data.model.ProductDetail
import com.example.turkcell.data.model.Products
import com.example.turkcell.data.source.ProductRepository
import javax.inject.Inject

class LocalProductRepository @Inject constructor() : ProductRepository {
    override suspend fun getProducts(): Products {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getProduct(productId: Int): ProductDetail {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}