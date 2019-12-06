package com.example.turkcell.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.turkcell.di.ProductRepositoryModule
import com.example.turkcell.ui.main.domain.usecase.GetProductsUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    application: Application,
    private val getProductsUseCase: GetProductsUseCase
) : AndroidViewModel(application) {



}
