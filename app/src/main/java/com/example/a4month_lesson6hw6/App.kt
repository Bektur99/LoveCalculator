package com.example.a4month_lesson6hw6

import android.app.Application
import androidx.room.Room
import com.example.a4month_lesson6hw6.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "love_table")
                .allowMainThreadQueries().build()
    }
}