package com.example.turkcell.ui.main.domain.usecase

import com.example.turkcell.data.model.Products
import com.example.turkcell.data.source.ProductRepository
import com.example.turkcell.di.ProductRepositoryModule.RemoteProductRepo
import com.example.turkcell.ui.base.BaseUseCase
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    @RemoteProductRepo private val localProductRepository: ProductRepository
) : BaseUseCase() {

    suspend fun execute(coroutineScope: CoroutineScope, listener: (Result<Products>) -> Unit) {
        try {
            val products = localProductRepository.getProducts()
            listener.invoke(Result.success(products))
        } catch (e: Exception) {
            listener.invoke(Result.failure(e))
        }
    }
}