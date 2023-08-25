package com.example.myapplication.db

import android.content.Context
import android.icu.text.StringSearch
import androidx.lifecycle.ViewModel
import com.example.myapplication.api.RetrofitInstance
import com.example.myapplication.model.News

class NewsRepository(val context: Context): ViewModel() {

       val dataBase = DataBase.createDatabase(context)
       val dao = dataBase.getDao()

       suspend fun getNews(country: String, page:Int) = RetrofitInstance.newsApi.getNews(country, page)
       suspend fun search(search: String, page:Int) = RetrofitInstance.newsApi.searchNews(search, page)
       fun getSaveNews() = dao.getAllNews()
       suspend fun insertNews(news: News)= dao.insert(news)
       fun deleteNews(news: News)= dao.deleteNews(news)
}