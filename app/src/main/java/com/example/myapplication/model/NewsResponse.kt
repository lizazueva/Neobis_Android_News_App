package com.example.myapplication.model

data class NewsResponse(
    val articles: List<News>,
    val status: String,
    val totalResults: Int
)