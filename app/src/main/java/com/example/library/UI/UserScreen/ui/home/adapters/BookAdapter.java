package com.example.library.UI.UserScreen.ui.home.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.library.Data.Entity.BookModel;
import com.example.library.R;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookItemView> {
    private ArrayList<BookModel> books;
    private Context context;
    public BookAdapter(Context context, ArrayList<BookModel> books) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public BookItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.book_item_view, viewGroup, false);
        return new BookItemView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookItemView bookItemView, int position) {
        bookItemView.setBook(this.books.get(position), position);
    }

    @Override
    public int getItemCount() {
        return this.books.size();
    }
}
