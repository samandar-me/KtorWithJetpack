package com.example.ktorwithjetpack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorwithjetpack.model.Product
import com.example.ktorwithjetpack.repository.KtorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class KtorViewModel : ViewModel() {
    val productFlow = MutableStateFlow<Product?>(null)

    init {
        getProductFromApi()
    }

    private fun getProductFromApi() {
        viewModelScope.launch {
            runCatching {
                KtorRepository.getProductDetails()
            }.onSuccess {
                productFlow.value = it
            }.onFailure {
                productFlow.value = null
            }
        }
    }
}