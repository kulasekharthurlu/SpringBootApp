package com.app.iservice;

import java.util.List;

import com.app.model.Books;

public interface IBooks {
    public String saveBook(Books book);

    public Books updateBook(Books book);

    public String deleteBook(int bookId);

    public Books getBookById(int bookId);

    public List<Books> getAllBooks();

}
