package com.example.ashishgpt.repository

import com.example.ashishgpt.apiservice.ApiService
import com.example.ashishgpt.model.GptRequest
import com.example.ashishgpt.model.GptResponse

class ChatRepository(private val apiService: ApiService) {

    suspend fun getGptResponse(authorization:String, body: GptRequest) : GptResponse?{

        return apiService.getGptResponse(authorization = authorization, body= body).body()

    }

}



