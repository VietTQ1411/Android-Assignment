package com.example.library.RespositoriesAPI.IRespository;

import com.example.library.Entity.BookModel;

import java.util.List;

public interface IBookRespository {

    /**
     * Get books from API
     * @param books
     * @param pageNumber
     * @param error
     */
     void getBooks(List<BookModel> books, int pageNumber, Exception error);
}
