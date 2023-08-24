package com.example.myapplication.db

import androidx.lifecycle.ViewModel
import com.example.myapplication.api.RetrofitInstance
import com.example.myapplication.model.News

class NewsRepository(val dataBase: DataBase?): ViewModel() {

       suspend fun getNews(country: String, page:Int) = RetrofitInstance.newsApi.getNews(country, page)

       fun getSaveNews() = dataBase?.getDao()?.getAllNews()
       fun insertNews(news: News)= dataBase?.getDao()?.insert(news)
       fun deleteNews(news: News)= dataBase?.getDao()?.deleteNews(news)
}