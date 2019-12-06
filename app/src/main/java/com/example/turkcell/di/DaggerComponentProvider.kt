package com.example.turkcell.di

import android.app.Activity
import androidx.fragment.app.Fragment
import com.example.turkcell.MyApplication

interface DaggerComponentProvider {

    val component: ApplicationComponent
}

val Activity.injector get() = (application as MyApplication).component
val Fragment.injector get() = (requireActivity().application as MyApplication).component
