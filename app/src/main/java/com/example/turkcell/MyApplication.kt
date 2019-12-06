package com.example.turkcell

import android.app.Application
import android.os.Handler
import android.os.StrictMode
import androidx.databinding.library.BuildConfig
import com.example.turkcell.di.ApplicationComponent
import com.example.turkcell.di.DaggerApplicationComponent
import com.example.turkcell.di.DaggerComponentProvider

class MyApplication : Application(), DaggerComponentProvider {

    override val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        enableStrictMode()
        super.onCreate()
    }

    private fun enableStrictMode() {
        if (BuildConfig.DEBUG) {
            Handler().postAtFrontOfQueue {
                StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().detectDiskWrites().detectNetwork().detectCustomSlowCalls().penaltyLog().build())
                StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build())
            }
        }
    }
}
