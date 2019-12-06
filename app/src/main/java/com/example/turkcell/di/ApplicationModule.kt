package com.example.turkcell.di

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.room.Room
import com.example.turkcell.data.sourceProduct.local.db.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
object ApplicationModule {

    @Reusable
    @Provides
    fun provideDatabase(application: Application): ProductDatabase {
        return Room.databaseBuilder(
            application, ProductDatabase::class.java, "product1.db"
        ).build()
    }

    @Reusable
    @Provides
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }
}
