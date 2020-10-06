package com.example.library.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.library.Entity.BookModel;
import com.example.library.RespositoriesAPI.BookRepository;

import java.util.List;

public class BookActivityViewModel extends ViewModel {
    private BookRepository bookRepository;
    private MutableLiveData<List<BookModel>> liveData;

    public LiveData<List<BookModel>> getBooks(){return liveData;}

    public void init(){
        if(liveData!=null){
            return;
        }
        this.liveData = BookRepository.getInstance().getBooks();
    }
}
