package com.example.turkcell.data.sourceProduct.remote

import com.example.turkcell.data.sourceProduct.remote.model.ProductDetail
import com.example.turkcell.data.sourceProduct.remote.model.Products
import com.example.turkcell.data.sourceProduct.remote.retrofit.ProductApi
import com.example.turkcell.data.sourceProduct.ProductRepository
import javax.inject.Inject

class RemoteProductRepository @Inject constructor(
    private val productApi: ProductApi
) : ProductRepository<Products, ProductDetail> {

    override suspend fun saveProducts(list: Products) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getProducts(): Products {
        return productApi.getProducts()
    }

    override suspend fun getProduct(productId: Int): ProductDetail {
        return productApi.getProduct(productId)
    }

}