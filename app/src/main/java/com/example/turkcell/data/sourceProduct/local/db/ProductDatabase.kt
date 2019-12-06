package com.example.turkcell.data.sourceProduct.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.turkcell.data.sourceProduct.local.model.LocalProduct

@Database(entities = [LocalProduct::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
}
