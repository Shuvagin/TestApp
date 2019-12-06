package com.example.turkcell.ui.main.domain.usecase

import androidx.lifecycle.LiveData
import com.example.turkcell.base.BaseUseCase
import com.example.turkcell.data.sourceProduct.ProductRepository
import com.example.turkcell.data.sourceProduct.local.model.LocalProduct
import com.example.turkcell.di.ProductRepositoryModule.LocalProductRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetLocalProductListUseCase @Inject constructor(
    @LocalProductRepo private val localProductRepository: ProductRepository<LiveData<List<LocalProduct>>, LocalProduct>
) : BaseUseCase() {

    suspend fun execute(): LiveData<List<LocalProduct>> {
       return localProductRepository.getProducts()
    }

}