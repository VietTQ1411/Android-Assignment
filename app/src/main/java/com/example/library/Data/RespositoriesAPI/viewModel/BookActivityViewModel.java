package com.example.library.Data.RespositoriesAPI.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.library.Data.Entity.BookModel;
import com.example.library.Data.RespositoriesAPI.BookRepository;
import com.example.library.Data.RespositoriesAPI.IRespository.IBookRespository;

import java.util.List;

public class BookActivityViewModel extends ViewModel implements IBookRespository {
    private BookRepository bookRepository;
    private MutableLiveData<List<BookModel>> liveData;

    public LiveData<List<BookModel>> getBooks(){return liveData;}

    public void init(){
        bookRepository = BookRepository.getInstance();
        bookRepository.getBooksFromServer();
        liveData = bookRepository.getBooks();
    }

    @Override
    public void getBooks(List<BookModel> books, int pageNumber, Exception error) {

    }
}
