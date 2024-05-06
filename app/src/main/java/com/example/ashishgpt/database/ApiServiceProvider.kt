package com.example.ashishgpt.database

import com.example.ashishgpt.apiservice.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiServiceFactory {
    // Provides an instance of ApiService using Retrofit
    fun createApiService(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api-inference.huggingface.co")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }
}

