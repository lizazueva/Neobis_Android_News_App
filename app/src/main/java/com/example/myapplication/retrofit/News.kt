package com.example.myapplication.retrofit

import android.os.Parcelable


data class News(
    val id: Int,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String

) {

}