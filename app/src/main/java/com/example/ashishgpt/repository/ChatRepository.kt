package com.example.ashishgpt.repository

import com.example.ashishgpt.apiservice.ApiService
import com.example.ashishgpt.model.GptRequest
import com.example.ashishgpt.model.GptResponse
import javax.inject.Inject

class ChatRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getGptResponse(authorization:String, body: GptRequest) : GptResponse?{
        println(body.inputs)
        println(authorization)
        val res= apiService.getGptResponse(authorization = authorization, body= body).body()
        println(res?.get(0)?.generated_text)
    return res;
    }

}

