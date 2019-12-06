package com.example.turkcell.data.sourceProduct.local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "LocalProductDB")
class LocalProduct(
    val image: String,
    val name: String,
    val price: Int,
    @PrimaryKey
    val productId: String,
    val description: String
) : Parcelable
