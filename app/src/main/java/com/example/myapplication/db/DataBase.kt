package com.example.myapplication.db

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.MainActivity
import com.example.myapplication.model.News


@Database(entities = [News::class], version = 1)
@TypeConverters(Converters::class)
abstract class DataBase: RoomDatabase() {
    abstract fun getDao(): Dao
    companion object{

        @Volatile
        private var instance: DataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: MainActivity) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it}
        }
        private fun createDatabase(context: Context): DataBase{
            return Room.databaseBuilder(
                context.applicationContext,
                DataBase::class.java,
                "item_database"
            ).build()
        }
    }
}