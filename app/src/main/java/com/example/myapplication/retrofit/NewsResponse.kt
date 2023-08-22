package com.example.myapplication.retrofit

import com.example.myapplication.retrofit.News

data class NewsResponse(
    val articles: List<News>,
    val status: String,
    val totalResults: Int
)