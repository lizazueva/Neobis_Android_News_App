package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.db.DataBase
import com.example.myapplication.db.NewsRepository
import com.example.myapplication.viewModel.MyViewModel
import com.example.myapplication.viewModel.ViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        myViewModel = ViewModelProvider(this, ViewModelProviderFactory(NewsRepository(DataBase.getInstance(this))))
//            .get(MyViewModel::class.java)
        val newsRepository = NewsRepository(DataBase(this))
        val viewModelFactory = ViewModelProviderFactory(newsRepository)
        myViewModel = ViewModelProvider(this, viewModelFactory)[(MyViewModel::class.java)]

        setContentView(binding.root)
    }
}