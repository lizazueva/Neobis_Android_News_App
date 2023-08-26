package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity("news")
data class News(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val author: String,
    val content: String? = null,
    val description: String,
    val publishedAt: String,
    val source: Source? = null,
    val title: String,
    val url: String,
    val urlToImage: String,
    var isSaved: Boolean = false) : java.io.Serializable {
}