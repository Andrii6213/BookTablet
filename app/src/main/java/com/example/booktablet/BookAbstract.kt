package com.example.booktablet

import android.content.Context
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase



abstract class BookAbstract: RoomDatabase()  {
    abstract fun bookAbstract(): BookInterface

    companion object {
        @Volatile
        private var INSTANCE: BookAbstract? = null

        fun getDatabase(context: Context): BookAbstract {
            return INSTANCE ?: synchronized(this) {
                val instance = databaseBuilder(context.applicationContext, BookAbstract::class.java,
                    "book_database").build()
                INSTANCE = instance
                instance
            }
        }
    }
}
