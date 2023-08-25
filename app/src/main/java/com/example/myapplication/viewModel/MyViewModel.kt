package com.example.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.db.NewsRepository
import com.example.myapplication.model.News
import com.example.myapplication.model.NewsResponse
import com.example.myapplication.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MyViewModel(private var newsRepository: NewsRepository): ViewModel() {
    val news: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val page:Int = 1

    val searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val searchPage:Int = 1


    init {
        getNews("us")
    }


    fun getNews(country: String)=
        viewModelScope.launch {
            news.postValue(Resource.Loading())
            val response = newsRepository.getNews(country, page)
            news.postValue(newsResponse(response))
        }

    fun searchNews(search: String) =
        viewModelScope.launch {
            searchNews.postValue(Resource.Loading())
            val response = newsRepository.search(search, searchPage)
            searchNews.postValue(searchNewsResponse(response))
        }

    private fun newsResponse(response: Response<NewsResponse>): Resource<NewsResponse>{
        if (response.isSuccessful){
            response.body()?.let {resultResponse ->
                return Resource.Success(resultResponse)

            }
        }
        return Resource.Error(response.message())
    }

    private fun searchNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse>{
        if (response.isSuccessful){
            response.body()?.let {resultResponse ->
                return Resource.Success(resultResponse)

            }
        }
        return Resource.Error(response.message())
    }

    fun save(news: News) = viewModelScope.launch (Dispatchers.IO) {
        newsRepository.insertNews(news)
    }

    fun getSaveNews() =
        newsRepository.getSaveNews()
}