package com.example.turkcell.ui.main.domain.adapter

import com.example.turkcell.data.sourceProduct.local.model.LocalProduct
import com.example.turkcell.data.sourceProduct.remote.model.Products

object ProductAdapter {

    fun toLocal(remoteProduct: Products.Product): LocalProduct {
        return LocalProduct(
            remoteProduct.image,
            remoteProduct.name,
            remoteProduct.price,
            remoteProduct.productId,
            ""
        )
    }

    fun toRemote(localProduct: LocalProduct): Products.Product {
        return Products.Product(
            localProduct.image,
            localProduct.name,
            localProduct.price,
            localProduct.productId
        )
    }
}
