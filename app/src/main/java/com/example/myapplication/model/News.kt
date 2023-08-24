package com.example.myapplication.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.myapplication.db.Converters
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import java.io.Serializable
import java.lang.reflect.Type


@Entity("news")
data class News(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String) : java.io.Serializable {
}