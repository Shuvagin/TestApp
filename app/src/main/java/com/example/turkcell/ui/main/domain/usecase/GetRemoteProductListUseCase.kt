package com.example.turkcell.ui.main.domain.usecase

import com.example.turkcell.base.BaseUseCase
import com.example.turkcell.data.sourceProduct.remote.RemoteProductRepository
import com.example.turkcell.data.sourceProduct.remote.model.RemoteProducts
import javax.inject.Inject

class GetRemoteProductListUseCase @Inject constructor(
    private val remoteProductRepository: RemoteProductRepository
) : BaseUseCase() {

    suspend fun execute(): List<RemoteProducts.RemoteProduct> {
        return remoteProductRepository.getProducts().remoteProducts
    }
}
