package com.project.data.repository.hilt

import com.project.data.repository.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private const val BASE_URL = "https://reqres.in/"

    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

}