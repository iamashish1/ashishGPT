package com.example.ashishgpt.database

import com.example.ashishgpt.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ChatDatabase {
    fun getChatAPI(): ApiService {

        val actualclass = Retrofit.Builder().baseUrl("https://api-inference.huggingface.co").addConverterFactory(
            GsonConverterFactory.create()).build().create(ApiService::class.java)

        return actualclass

    }

}

