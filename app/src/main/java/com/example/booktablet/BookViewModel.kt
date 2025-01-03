package com.example.booktablet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {
    private var bookDao: BookDao = (application as BookApp).database.bookDao()

    val allBooks: LiveData<List<Book>> = bookDao.getAllBooks()

    fun addBook(books: Book) = viewModelScope.launch {
        bookDao.addBook(books)
    }

    fun deleteBook(books: Book) = viewModelScope.launch {
        bookDao.deleteBook(books)
    }
}