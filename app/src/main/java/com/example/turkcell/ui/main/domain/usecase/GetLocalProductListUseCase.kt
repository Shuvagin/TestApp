package com.example.turkcell.ui.main.domain.usecase

import androidx.lifecycle.LiveData
import com.example.turkcell.base.BaseUseCase
import com.example.turkcell.data.sourceProduct.local.LocalProductRepository
import com.example.turkcell.data.sourceProduct.local.model.LocalProduct
import javax.inject.Inject

class GetLocalProductListUseCase @Inject constructor(
    private val localProductRepository: LocalProductRepository
) : BaseUseCase() {

    suspend fun execute(): LiveData<List<LocalProduct>> {
        return localProductRepository.getProducts()
    }
}
