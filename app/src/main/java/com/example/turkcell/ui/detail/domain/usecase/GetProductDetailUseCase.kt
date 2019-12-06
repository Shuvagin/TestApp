package com.example.turkcell.ui.detail.domain.usecase

import com.example.turkcell.data.sourceProduct.remote.model.ProductDetail
import com.example.turkcell.data.sourceProduct.ProductRepository
import com.example.turkcell.di.ProductRepositoryModule.RemoteProductRepo
import com.example.turkcell.base.BaseUseCase
import com.example.turkcell.data.sourceProduct.remote.model.Products
import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(
    @RemoteProductRepo private val remoteProductRepository: ProductRepository<Products, ProductDetail>
) : BaseUseCase() {

   suspend fun execute(productId: Int, listener: (Result<ProductDetail>) -> Unit) {
       try {
           val product = remoteProductRepository.getProduct(productId)
           listener.invoke(Result.success(product))
       } catch (e: Exception) {
           listener.invoke(Result.failure(e))
       }
   }

}