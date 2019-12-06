package com.example.turkcell.data.sourceProduct.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LocalProductDB")
class LocalProduct(
    val image: String,
    val name: String,
    val price: Int,
    @PrimaryKey
    val productId: String,
    val description: String
)