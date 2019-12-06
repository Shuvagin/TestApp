package com.example.turkcell.ui.main.domain.usecase

import androidx.lifecycle.LiveData
import com.example.turkcell.data.sourceProduct.ProductRepository
import com.example.turkcell.data.sourceProduct.local.model.LocalProduct
import com.example.turkcell.data.sourceProduct.remote.model.Products
import com.example.turkcell.di.ProductRepositoryModule.LocalProductRepo
import com.example.turkcell.ui.main.domain.adapter.ProductAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveRemoteToLocalUseCase @Inject constructor(
    @LocalProductRepo private val localProductRepository: ProductRepository<LiveData<List<LocalProduct>>, LocalProduct>
) {

    suspend fun execute(coroutineScope: CoroutineScope, remoteList: List<Products.RemoteProduct>) {
        coroutineScope.launch(Dispatchers.Default) {
            val localList = mutableListOf<LocalProduct>()
            remoteList.forEach {
                val item = ProductAdapter.toLocal(it)
                localList.add(item)
            }
            withContext(Dispatchers.IO) {
                localProductRepository.saveProducts(localList)
            }
        }
    }

}