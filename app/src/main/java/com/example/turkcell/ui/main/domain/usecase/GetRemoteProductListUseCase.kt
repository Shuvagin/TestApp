package com.example.turkcell.ui.main.domain.usecase

import com.example.turkcell.base.BaseUseCase
import com.example.turkcell.data.sourceProduct.ProductRepository
import com.example.turkcell.data.sourceProduct.remote.model.ProductDetail
import com.example.turkcell.data.sourceProduct.remote.model.Products
import com.example.turkcell.di.ProductRepositoryModule.RemoteProductRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetRemoteProductListUseCase @Inject constructor(
    @RemoteProductRepo private val remoteProductRepository: ProductRepository<Products, ProductDetail>
) : BaseUseCase() {

    suspend fun execute(
        coroutineScope: CoroutineScope,
        listener: (Result<List<Products.RemoteProduct>>) -> Unit
    ) {
        try {
            coroutineScope.launch(Dispatchers.IO) {
                val list = remoteProductRepository.getProducts()
                listener.invoke(Result.success(list.products))
            }
        } catch (e: Exception) {
            listener.invoke(Result.failure(e))
        }
    }
}