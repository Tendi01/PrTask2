package com.mirea.kt.android2023.library;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private List<Book> books;
    private OnBookClickListener onBookClickListener;

    public BookAdapter(List<Book> books, OnBookClickListener onBookClickListener) {
        this.books = books;
        this.onBookClickListener = onBookClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = books.get(position);

        holder.bookTitle.setText(book.getTitle());
        holder.bookAuthor.setText(book.getAuthor());

        holder.itemView.setOnClickListener(x -> {
            onBookClickListener.onBookClick(book, holder.getAdapterPosition());
        });

        holder.imageViewDelete.setOnClickListener(x -> {
            onBookClickListener.onDeleteClick(book, holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public interface OnBookClickListener {
        void onBookClick(Book book, int position);

        void onDeleteClick(Book book, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView bookTitle;
        private final TextView bookAuthor;
        private final ImageView imageViewDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookTitle = itemView.findViewById(R.id.textViewBookTitleItem);
            bookAuthor = itemView.findViewById(R.id.textViewBookAuthorItem);
            imageViewDelete = itemView.findViewById(R.id.imageViewBookItemDelete);
        }
    }
}
