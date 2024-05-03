package com.example.ashishgpt

class ChatRepository(private val apiService:ApiService) {

    suspend fun getGptResponse(authorization:String, body:GptRequest) : GptResponse?{

        return apiService.getGptResponse(authorization = authorization, body= body).body()

    }

}

