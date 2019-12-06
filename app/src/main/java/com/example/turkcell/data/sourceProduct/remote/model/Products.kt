package com.example.turkcell.data.sourceProduct.remote.model
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class Products(
    @Json(name = "products")
    val products: List<Product> = listOf()
) {
    @JsonClass(generateAdapter = true)
    data class Product(
        @Json(name = "image")
        val image: String = "",
        @Json(name = "name")
        val name: String = "",
        @Json(name = "price")
        val price: Int = 0,
        @Json(name = "product_id")
        val productId: String = ""
    )
}