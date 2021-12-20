package com.app.serviceimpl;

import java.util.Collections;
import java.util.List;

import com.app.iservice.IBooks;
import com.app.model.Books;
import com.app.repo.BookRepository;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBooks {
    

    private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(BookServiceImpl.class);
    
    @Autowired
    private BookRepository bookRepository;

    @Override
    public String saveBook(Books book) {
        log.info("Enter into save book");
        bookRepository.save(book);
        return "save book";
    }

    @Override
    public Books updateBook(Books book) {
        return bookRepository.save(book);
    }

    @Override
    public String deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
        return "deleted Successfully";
    }

    @Override
    public Books getBookById(int bookId) {
        return bookRepository.findById(bookId).isPresent()?
        		bookRepository.findById(bookId).get():null;
    }

    @Override
    public List<Books> getAllBooks() {
    List<Books> list=	bookRepository.findAll();
            //Collections.sort(list,(e1,e2)->e1.getId()-e2.getId());
            Collections.sort(list,(e1,e2)->e1.getName().compareTo(e2.getName()));
        return list;
    }

}
