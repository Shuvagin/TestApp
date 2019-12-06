package com.example.turkcell.data.sourceProduct.remote.model
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json


@JsonClass(generateAdapter = true)
data class ProductDetail(
    @Json(name = "description")
    val description: String = "",
    @Json(name = "image")
    val image: String = "",
    @Json(name = "name")
    val name: String = "",
    @Json(name = "price")
    val price: Int = 0,
    @Json(name = "product_id")
    val productId: String = ""
)