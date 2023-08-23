package com.example.myapplication.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.model.News

@Dao
interface Dao {
    @Insert
    suspend fun insert(news: News)

    @Query("SELECT*FROM news")
    fun getAllNews(): LiveData<List<News>>

}