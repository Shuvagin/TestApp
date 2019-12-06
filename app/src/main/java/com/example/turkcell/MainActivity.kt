package com.example.turkcell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.example.turkcell.databinding.MainActivityBinding
import com.example.turkcell.di.injector
import com.example.turkcell.di.util.viewModel
import com.example.turkcell.ui.main.MainFragment
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding : MainActivityBinding
    private val mainViewModel by viewModel {
        injector.mainViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.main_activity)
        setupSnackBarError()
    }

    private fun setupSnackBarError() {
        mainViewModel.errorMessage.observe(this) {
            it?.let {
                Snackbar.make(binding.root, getString(R.string.all_connection_failed), Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}
