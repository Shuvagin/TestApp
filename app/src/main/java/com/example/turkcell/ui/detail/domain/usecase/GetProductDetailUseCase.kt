package com.example.turkcell.ui.detail.domain.usecase

import com.example.turkcell.data.model.ProductDetail
import com.example.turkcell.data.source.ProductRepository
import com.example.turkcell.di.ProductRepositoryModule.RemoteProductRepo
import com.example.turkcell.ui.base.BaseUseCase
import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(
    @RemoteProductRepo private val localProductRepository: ProductRepository
) : BaseUseCase() {

   suspend fun execute(productId: Int, listener: (Result<ProductDetail>) -> Unit) {
       try {
           val product = localProductRepository.getProduct(productId)
           listener.invoke(Result.success(product))
       } catch (e: Exception) {
           listener.invoke(Result.failure(e))
       }
   }

}