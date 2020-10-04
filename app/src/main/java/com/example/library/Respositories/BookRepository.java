package com.example.library.Respositories;

import androidx.lifecycle.MutableLiveData;

import com.example.library.Entity.BookModel;

import java.util.List;

public class BookRepository {
    private static BookRepository instance = null;
    private List<BookModel> listUser;
    private BookRepository(){}

    public static BookRepository getInstance(){
        if(instance==null){
            instance = new BookRepository();
        }
        return instance;
    }
    public MutableLiveData<List<BookModel>> getBooks(){
        MutableLiveData<List<BookModel>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(null);
        return mutableLiveData;
    }
}
