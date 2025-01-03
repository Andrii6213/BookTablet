package com.example.booktablet

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {

    @Insert
    suspend fun addBook(books: Book)

    @Query("SELECT * FROM books ORDER BY title ASC")
    fun getAllBooks(): LiveData<List<Book>>

    @Delete
    suspend fun deleteBook(books: Book)
}