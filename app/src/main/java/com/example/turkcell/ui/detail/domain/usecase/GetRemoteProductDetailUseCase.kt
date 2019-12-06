package com.example.turkcell.ui.detail.domain.usecase

import com.example.turkcell.base.BaseUseCase
import com.example.turkcell.data.sourceProduct.remote.RemoteProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetRemoteProductDetailUseCase @Inject constructor(
    private val remoteProductRepository: RemoteProductRepository
) : BaseUseCase() {

    suspend fun execute(productId: String) = withContext(Dispatchers.IO) {
        remoteProductRepository.getProduct(productId)
    }

}