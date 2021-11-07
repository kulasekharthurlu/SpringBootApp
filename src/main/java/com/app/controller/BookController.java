package com.app.controller;

import java.util.List;

import com.app.model.Books;
import com.app.serviceimpl.BookServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @PostMapping("/add")
    public String addBook(@RequestBody Books book) {
        return bookServiceImpl.saveBook(book);
    }

    @PutMapping("/update")
    public String updateBook(@RequestBody Books book) {
        return bookServiceImpl.updateBook(book);
    }

    @DeleteMapping("/delete")
    public String deleteBook(@RequestParam int id) {
        return bookServiceImpl.deleteBook(id);
    }

    @GetMapping("/get")
    public Books getBook(@RequestParam int id) {
        return bookServiceImpl.getBookById(id);
    }

    @GetMapping("/getall")
    public List<Books> getAllBooks() {
        return bookServiceImpl.getAllBooks();
    }

}
