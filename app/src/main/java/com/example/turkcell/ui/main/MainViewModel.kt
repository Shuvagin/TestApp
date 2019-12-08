package com.example.turkcell.ui.main

import android.app.Application
import androidx.lifecycle.*
import com.example.turkcell.ui.detail.domain.usecase.GetLocalProductDetailUseCase
import com.example.turkcell.ui.detail.domain.usecase.GetRemoteProductDetailUseCase
import com.example.turkcell.ui.main.domain.usecase.GetLocalProductListUseCase
import com.example.turkcell.ui.main.domain.usecase.GetRemoteProductListUseCase
import com.example.turkcell.ui.main.domain.usecase.SaveRemoteProductToLocalProductUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    application: Application,
    private val getRemoteProductsUseCase: GetRemoteProductListUseCase,
    private val getLocalProductListUseCase: GetLocalProductListUseCase,
    private val saveRemoteToLocalUseCase: SaveRemoteProductToLocalProductUseCase,
    private val getRemoteProductDetailUseCase: GetRemoteProductDetailUseCase,
    private val getLocalProductDetailUseCase: GetLocalProductDetailUseCase
) : AndroidViewModel(application) {

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading
    private val _errorMessage = MutableLiveData<String?>(null)
    val errorMessage: LiveData<String?> = _errorMessage
    val productItemId = MutableLiveData<String>()
    val selectedProduct = productItemId.switchMap {
        liveData {
            emitSource(getLocalProductDetailUseCase.execute(it))
            loadRemoteProductDetails(it)
        }
    }
    val listProducts = liveData {
        emitSource(getLocalProductListUseCase.execute())
        loadAndSaveRemoteProducts()
    }

    private suspend fun loadRemoteProductDetails(productId: String) {
        try {
            _isLoading.value = true
            getRemoteProductDetailUseCase.execute(productId)
        } catch (e: Exception) {
            _errorMessage.value = e.message
            _errorMessage.value = null
        } finally {
            _isLoading.value = false
        }
    }

    private suspend fun loadAndSaveRemoteProducts() {
            try {
                _isLoading.value = true
                val products = getRemoteProductsUseCase.execute()
                saveRemoteToLocalUseCase.execute(products)
            } catch (e: Exception) {
                _errorMessage.value = e.message
                _errorMessage.value = null
            } finally {
                _isLoading.value = false
            }
    }
}
