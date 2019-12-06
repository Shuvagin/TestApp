package com.example.turkcell.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.request.CachePolicy
import com.example.turkcell.R

@BindingAdapter("loadImageUrl")
fun ImageView.loadImageUrl(url: String?) {
    this.load(url) {
        placeholder(R.drawable.logo)
        memoryCachePolicy(CachePolicy.ENABLED)
    }
}
