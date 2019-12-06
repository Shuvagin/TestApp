package com.example.turkcell.ui.detail.domain.usecase

import com.example.turkcell.base.BaseUseCase
import com.example.turkcell.data.sourceProduct.local.LocalProductRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetLocalProductDetailUseCase @Inject constructor(
    private val localProductRepository: LocalProductRepository
) : BaseUseCase() {

    suspend fun execute(productId: String) = withContext(Dispatchers.IO) {
        localProductRepository.getProduct(productId)
    }
}
