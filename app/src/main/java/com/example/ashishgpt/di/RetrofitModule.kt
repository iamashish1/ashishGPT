package com.example.ashishgpt.di

import com.example.ashishgpt.apiservice.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            // Configure Retrofit instance
            .baseUrl("https://api-inference.huggingface.co")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

}