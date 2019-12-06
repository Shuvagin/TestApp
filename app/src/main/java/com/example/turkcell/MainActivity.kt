package com.example.turkcell

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import com.example.turkcell.databinding.MainActivityBinding
import com.example.turkcell.di.injector
import com.example.turkcell.di.util.viewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var finishActivity = false
    private lateinit var binding: MainActivityBinding
    private val mainViewModel by viewModel {
        injector.mainViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        setupSnackBarError()
    }

    override fun onBackPressed() {
        if (finishActivity) {
            finish()
        } else {
            finishActivity = true
            Snackbar.make(binding.root, getString(R.string.all_press_again_for_exit), Snackbar.LENGTH_SHORT).show()
            lifecycleScope.launch {
                delay(2000)
                finishActivity = false
            }
        }
    }

    private fun setupSnackBarError() {
        mainViewModel.errorMessage.observe(this) {
            it?.let {
                Snackbar.make(binding.root, getString(R.string.all_connection_failed), Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}
