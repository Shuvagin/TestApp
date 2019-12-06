package com.example.turkcell.data.sourceProduct.local.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.turkcell.base.BaseDao
import com.example.turkcell.data.sourceProduct.local.model.LocalProduct

@Dao
interface ProductDao : BaseDao<LocalProduct> {

    @Query("SELECT * FROM LocalProductDB")
    fun getLocalProducts(): LiveData<List<LocalProduct>>

    @Query("SELECT * FROM LocalProductDB WHERE productId =:id")
    suspend fun getLocalProduct(id: Int): LocalProduct

    @Query("UPDATE LocalProductDB SET description=:description WHERE productId=:productId")
    suspend fun updateProductDescription(productId: Int, description: String)
}