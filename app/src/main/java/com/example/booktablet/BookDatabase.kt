package com.example.booktablet

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.booktablet.BookDatabase.Companion.DB_VERSION


@Database(
    entities = [Book::class],
    version = DB_VERSION,
    exportSchema = false,
)
abstract class BookDatabase: RoomDatabase()  {

    abstract fun bookDao(): BookDao

    companion object {
        const val DB_VERSION = 1

        @Volatile
        private var INSTANCE: BookDatabase? = null

        fun getDatabase(context: Context): BookDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = databaseBuilder(
                    context.applicationContext,
                    BookDatabase::class.java,
                    "book_database"
                )
                    .fallbackToDestructiveMigration(true)
                    .allowMainThreadQueries()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}
