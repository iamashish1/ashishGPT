package com.example.ashishgpt.di

import com.example.ashishgpt.apiservice.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//It installs the module in the generated ApplicationComponent

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

//ActivityComponent::class = Dependencies will be created and destroyed when Activity is created and destroyed
//FramentComponent::class= Same

//@Module
//@InstallIn(ActivityComponent::class)
//object DataRepositoryModule {
//
//    @Binds
//    fun bindDataRepository(repository: LocalDataRepository): DataRepository {
//        return repository
//    }
//}

//DOCUMENTATION EXAMPLE
// If AnalyticsService is an interface.
//@Module
//@InstallIn(SingletonComponent::class)
//abstract class AnalyticsModule {
//
//    @Singleton
//    @Binds
//    abstract fun bindAnalyticsService(
//        analyticsServiceImpl: AnalyticsServiceImpl
//    ): AnalyticsService
//}
