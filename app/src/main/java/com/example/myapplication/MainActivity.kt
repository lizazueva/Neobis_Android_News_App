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
        setContentView(binding.root)
        val newsRepository = NewsRepository(this)
        val viewModelFactory = ViewModelProviderFactory(newsRepository)
        myViewModel = ViewModelProvider(this, viewModelFactory).get(MyViewModel::class.java)

    }
}