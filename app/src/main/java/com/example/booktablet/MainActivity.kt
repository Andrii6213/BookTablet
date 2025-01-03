package com.example.booktablet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity() : AppCompatActivity() {

    private lateinit var bookViewModel: BookViewModel
    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bookViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(BookViewModel::class.java)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = BookAdapter { book -> bookViewModel.deleteBook(book) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        bookViewModel.allBooks.observe(this) { books ->
            adapter.setBooks(books)
        }

        val addButton = this.findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            val books = Book(title = "New books", author = "Writer", description = "Discription")
            bookViewModel.addBook(books)
        }
    }
}