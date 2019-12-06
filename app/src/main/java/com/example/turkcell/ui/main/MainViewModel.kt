package com.example.turkcell.ui.main

import android.app.Application
import androidx.lifecycle.*
import com.example.turkcell.data.sourceProduct.local.model.LocalProduct
import com.example.turkcell.data.sourceProduct.remote.model.Products
import com.example.turkcell.ui.main.domain.usecase.GetLocalProductListUseCase
import com.example.turkcell.ui.main.domain.usecase.GetRemoteProductListUseCase
import com.example.turkcell.ui.main.domain.usecase.SaveRemoteToLocalUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    application: Application,
    private val getRemoteProductsUseCase: GetRemoteProductListUseCase,
    private val getLocalProductListUseCase: GetLocalProductListUseCase,
    private val saveRemoteToLocalUseCase: SaveRemoteToLocalUseCase
) : AndroidViewModel(application) {


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

    private fun loadRemoteProducts() {
        viewModelScope.launch {
            _isLoading.value = true
            getRemoteProductsUseCase.execute(this) { result: Result<List<Products.RemoteProduct>> ->
                result.onSuccess {
                    launch {
                        saveRemoteToLocalUseCase.execute(this, it)
                    }
                }
                result.onFailure {
                    _errorMessage.value = it.message
                }
            }
            _isLoading.value = false
        }

    }

}
