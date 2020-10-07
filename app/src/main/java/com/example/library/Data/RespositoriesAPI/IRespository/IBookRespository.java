package com.example.library.Data.RespositoriesAPI.IRespository;

import com.example.library.Data.Entity.BookModel;

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
