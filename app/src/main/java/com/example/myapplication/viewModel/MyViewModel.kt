package com.example.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.db.NewsRepository
import com.example.myapplication.model.NewsResponse
import com.example.myapplication.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MyViewModel(var newsRepository: NewsRepository): ViewModel() {
    val news: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    val page:Int = 1

    init {
        getNews("us")
    }


    private fun getNews(country: String){
        viewModelScope.launch {
            news.postValue(Resource.Loading())
            val response = newsRepository.getNews(country, page)
            news.postValue(newsResponse(response))
        }
    }

    private fun newsResponse(response: Response<NewsResponse>): Resource<NewsResponse>{
        if (response.isSuccessful){
            response.body()?.let {resultResponse ->
                return Resource.Success(resultResponse)

            }
        }
        return Resource.Error(response.message())
    }
}