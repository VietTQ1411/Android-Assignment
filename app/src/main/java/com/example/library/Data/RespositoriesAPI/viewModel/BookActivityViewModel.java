package com.example.library.Data.RespositoriesAPI.viewModel;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.library.Data.Entity.BookModel;
import com.example.library.Data.RespositoriesAPI.Repositories.BookRepository;
import com.example.library.Data.RespositoriesAPI.IRespository.IBookRespository;

import java.util.ArrayList;
import java.util.List;


public class BookActivityViewModel extends ViewModel implements IBookRespository {
    private MutableLiveData<List<BookModel>> liveData = new MutableLiveData<>();

    public LiveData<List<BookModel>> getBooks() {
        return liveData;
    }

    public void init() {
        BookRepository.getInstance(this).getBooksFromServer();
    }

    @Override
    public void getBooks(final List<BookModel> books, int pageNumber, final Exception error) {
        final BookActivityViewModel that = this;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            //run on UI Thread
            @Override
            public void run() {
                that.liveData.setValue((error == null) ? books : new ArrayList<BookModel>());
            }}
        );
    }
}
