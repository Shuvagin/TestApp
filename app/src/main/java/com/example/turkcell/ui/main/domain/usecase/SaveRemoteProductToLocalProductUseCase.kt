package com.example.turkcell.ui.main.domain.usecase

import com.example.turkcell.data.sourceProduct.local.LocalProductRepository
import com.example.turkcell.data.sourceProduct.local.model.LocalProduct
import com.example.turkcell.data.sourceProduct.remote.model.RemoteProducts
import com.example.turkcell.ui.main.domain.adapter.ProductAdapter
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SaveRemoteProductToLocalProductUseCase @Inject constructor(
    private val localProductRepository: LocalProductRepository
) {

    suspend fun execute(remoteList: List<RemoteProducts.RemoteProduct>) = withContext(Dispatchers.IO) {
        val localList = mutableListOf<LocalProduct>()
        remoteList.forEach {
            val item = ProductAdapter.toLocal(it)
            localList.add(item)
        }
        localProductRepository.saveProducts(localList)
    }
}
