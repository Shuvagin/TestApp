package com.example.turkcell.ui.main.domain.adapter

import com.example.turkcell.data.sourceProduct.local.model.LocalProduct
import com.example.turkcell.data.sourceProduct.remote.model.RemoteProducts

object ProductAdapter {

    fun toLocal(remoteRemoteProduct: RemoteProducts.RemoteProduct): LocalProduct {
        return LocalProduct(
            remoteRemoteProduct.image,
            remoteRemoteProduct.name,
            remoteRemoteProduct.price,
            remoteRemoteProduct.productId,
            ""
        )
    }

    fun toRemote(localProduct: LocalProduct): RemoteProducts.RemoteProduct {
        return RemoteProducts.RemoteProduct(
            localProduct.image,
            localProduct.name,
            localProduct.price,
            localProduct.productId
        )
    }
}
