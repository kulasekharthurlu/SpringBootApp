package com.app.serviceimpl;

import java.util.List;

import com.app.iservice.IBooks;
import com.app.model.Books;
import com.app.repo.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBooks {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public String saveBook(Books book) {
        bookRepository.save(book);
        return "save book";
    }

    @Override
    public String updateBook(Books book) {
        bookRepository.save(book);
        return "update success";
    }

    @Override
    public String deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
        return "deleted Successfully";
    }

    @Override
    public Books getBookById(int bookId) {
        return bookRepository.findById(bookId).get();
    }

    @Override
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

}
