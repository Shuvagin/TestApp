package com.example.turkcell.ui.detail.domain.usecase

import com.example.turkcell.base.BaseUseCase
import com.example.turkcell.data.sourceProduct.local.LocalProductRepository
import com.example.turkcell.data.sourceProduct.remote.RemoteProductRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoadRemoteProductDetailUseCase @Inject constructor(
    private val remoteProductRepository: RemoteProductRepository,
    private val localProductRepository: LocalProductRepository
) : BaseUseCase() {

    suspend fun execute(productId: String) = withContext(Dispatchers.IO) {
        val product = remoteProductRepository.getProduct(productId)
        localProductRepository.updateProductDescription(product.productId, product.description)
    }
}
