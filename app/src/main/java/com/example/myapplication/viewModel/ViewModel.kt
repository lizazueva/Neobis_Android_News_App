package com.example.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.retrofit.News

class ViewModel: ViewModel() {
    val news: MutableLiveData<News> = MutableLiveData()
}