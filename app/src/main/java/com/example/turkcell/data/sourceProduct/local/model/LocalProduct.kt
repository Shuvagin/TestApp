package com.example.turkcell.data.sourceProduct.local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "LocalProductDB")
class LocalProduct(
    @PrimaryKey
    val productId: String,
    val image: String,
    val name: String,
    val price: Int,
    val description: String
) : Parcelable
