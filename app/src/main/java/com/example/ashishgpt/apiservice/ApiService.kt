package com.example.ashishgpt.apiservice

import com.example.ashishgpt.model.GptRequest
import com.example.ashishgpt.model.GptResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("models/google/gemma-1.1-7b-it")
    suspend fun getGptResponse(
        @Header("Authorization")authorization:String,
        @Body body: GptRequest
    ): Response<GptResponse>
}
