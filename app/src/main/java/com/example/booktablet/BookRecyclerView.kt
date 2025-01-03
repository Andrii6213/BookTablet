package com.example.booktablet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(private val onDeleteClick: (Book) -> Unit) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var books = emptyList<Book>()

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.bookTitle)
        val author: TextView = itemView.findViewById(R.id.bookAuthor)
        val deleteButton: TextView = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.title.text = book.title
        holder.author.text = book.author
        holder.deleteButton.setOnClickListener { onDeleteClick(book) }
    }

    override fun getItemCount() = books.size

    fun setBooks(newBooks: List<Book>) {
        books = newBooks
        notifyDataSetChanged()
    }
}