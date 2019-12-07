package com.example.turkcell.di

import android.app.Application
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
}
