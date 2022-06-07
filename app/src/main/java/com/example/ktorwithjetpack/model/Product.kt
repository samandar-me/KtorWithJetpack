package com.example.ktorwithjetpack.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val per_page: Int,
    val data: List<Data>
)

@Serializable
data class Data(
    val id: Int,
    val name: String,
    val year: Int,
    val color: String,
    val pantone_value: String
)