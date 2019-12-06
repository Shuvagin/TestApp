package com.example.turkcell.ui.main

import android.app.Application
import androidx.lifecycle.*
import com.example.turkcell.data.sourceProduct.local.model.LocalProduct
import com.example.turkcell.ui.detail.domain.usecase.GetLocalProductDetailUseCase
import com.example.turkcell.ui.detail.domain.usecase.GetRemoteProductDetailUseCase
import com.example.turkcell.ui.main.domain.usecase.GetLocalProductListUseCase
import com.example.turkcell.ui.main.domain.usecase.GetRemoteProductListUseCase
import com.example.turkcell.ui.main.domain.usecase.SaveRemoteToLocalUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    application: Application,
    private val getRemoteProductsUseCase: GetRemoteProductListUseCase,
    private val getLocalProductListUseCase: GetLocalProductListUseCase,
    private val saveRemoteToLocalUseCase: SaveRemoteToLocalUseCase,
    private val getRemoteProductDetailUseCase: GetRemoteProductDetailUseCase,
    private val getLocalProductDetailUseCase: GetLocalProductDetailUseCase
) : AndroidViewModel(application) {

    val itemId = MutableLiveData<String>()
    val selectedProductItem = itemId.switchMap {
        liveData {
            emitSource(getLocalProductDetailUseCase.execute(it))
            getRemoteProductDetailUseCase.execute(it)
        }
    }
    val listProducts: LiveData<List<LocalProduct>> = liveData {
        emitSource(getLocalProductListUseCase.execute())
    }
    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading
    private val _errorMessage = MutableLiveData<String>("")
    val errorMessage: LiveData<String> = _errorMessage

    init {
        loadRemoteProducts()
    }

    fun loadRemoteProducts() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val products = getRemoteProductsUseCase.execute()
                saveRemoteToLocalUseCase.execute(products)
            } catch (e: Exception) {
                _errorMessage.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

}
