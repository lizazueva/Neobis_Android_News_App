package com.example.myapplication.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.retrofit.News

@Dao
interface Dao {
    @Insert
    suspend fun insert(news: News)

    @Query("SELECT*FROM news")
    suspend fun getAllNews(): LiveData<List<News>>

}