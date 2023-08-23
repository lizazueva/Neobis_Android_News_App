package com.example.myapplication.db

import com.example.myapplication.api.RetrofitInstance

class NewsRepository(val dataBase: DataBase) {

       suspend fun getNews(country: String, page:Int) = RetrofitInstance.newsApi.getNews(country, page)
}