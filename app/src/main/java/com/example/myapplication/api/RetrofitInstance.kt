package com.example.myapplication.api

import com.example.myapplication.utils.Constats.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitInstance {
    companion object{
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val newsApi: NewsApi by lazy {
            retrofit.create(NewsApi::class.java)
        }
    }
}