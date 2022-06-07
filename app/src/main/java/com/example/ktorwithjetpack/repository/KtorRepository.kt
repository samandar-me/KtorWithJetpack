package com.example.ktorwithjetpack.repository

import com.example.ktorwithjetpack.model.Product
import com.example.ktorwithjetpack.network.KtorClient
import io.ktor.client.request.*

object KtorRepository {
    suspend fun getProductDetails(): Product {
        return KtorClient.httpClient.use {
            it.get("https://reqres.in/api/products/")
        }
    }
}