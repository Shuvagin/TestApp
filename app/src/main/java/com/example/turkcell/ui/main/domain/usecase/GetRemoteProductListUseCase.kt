package com.example.turkcell.ui.main.domain.usecase

import com.example.turkcell.base.BaseUseCase
import com.example.turkcell.data.sourceProduct.remote.RemoteProductRepository
import com.example.turkcell.data.sourceProduct.remote.model.Products
import javax.inject.Inject

class GetRemoteProductListUseCase @Inject constructor(
    private val remoteProductRepository: RemoteProductRepository
) : BaseUseCase() {

    suspend fun execute(): List<Products.Product> {
        return remoteProductRepository.getProducts().products
    }
}
