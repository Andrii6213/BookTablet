package com.example.booktablet

import android.app.Application

class BookApp: Application() {
    lateinit var database: BookDatabase

    override fun onCreate() {
        super.onCreate()
        database = BookDatabase.getDatabase(this)
    }
}