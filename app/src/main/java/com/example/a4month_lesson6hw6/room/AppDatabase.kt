package com.example.a4month_lesson6hw6.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.a4month_lesson6hw6.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun loveDao(): LoveDao
}