package com.example.library.UserScreen.ui.home.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.library.Entity.BookModel;
import com.example.library.R;
import com.squareup.picasso.Picasso;

public class BookItemView extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView textviewName;
    private TextView textviewAuthor;
    private RatingBar ratingBar;
    private TextView textviewDescription;
    private View bottomView;

    private BookModel book;

    public BookItemView(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        textviewName = itemView.findViewById(R.id.textViewName);
        textviewAuthor = itemView.findViewById(R.id.textViewAuthor);
        ratingBar = itemView.findViewById(R.id.ratingBar);
        textviewDescription = itemView.findViewById(R.id.textViewDescription);
        bottomView = itemView.findViewById(R.id.bottomView);
    }

    public void setBook(BookModel book, int position) {
        this.book = book;
        Picasso.get().load(book.getImageUrl())
                .placeholder(R.drawable.ic_launcher_foreground)
                .resize(100, 100)
                .centerCrop()
                .into(imageView);
        textviewName.setText(book.getName());
        textviewAuthor.setText(book.getAuthor());
        ratingBar.setNumStars(book.getRate());
        textviewDescription.setText(book.getDescription());

        bottomView.setBackgroundColor(position % 2 == 0 ?
                itemView.getResources().getColor(R.color.colorRed, null):
                itemView.getResources().getColor(R.color.colorBlack, null));
    }
}
