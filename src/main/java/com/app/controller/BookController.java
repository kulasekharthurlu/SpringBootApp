package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Books;
import com.app.responce.Responce;
import com.app.serviceimpl.BookServiceImpl;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {

	@Autowired
	private BookServiceImpl bookServiceImpl;

	@PostMapping("/add")
	public Responce<Books> addBook(@RequestBody Books book) {
		LocalDate b=LocalDate.parse(book.getReleasedate().toString());
		book.setReleasedate(b);
		return new Responce<>(HttpStatus.OK, book, bookServiceImpl.saveBook(book));
	}

	@PutMapping("/update")
	public Responce<Books> updateBook(@RequestBody Books book) {
		Books resultFromDB=	bookServiceImpl.getBookById(book.getId());
		if(resultFromDB!=null) {
			resultFromDB.setName(book.getName()==null?resultFromDB.getName():book.getName());
			resultFromDB.setAuthor(book.getAuthor()==null?resultFromDB.getAuthor():book.getAuthor());
			resultFromDB.setNumberofpages(book.getNumberofpages()==0?resultFromDB.getNumberofpages():book.getNumberofpages());
			resultFromDB.setPrice(book.getPrice()==0.0?resultFromDB.getPrice():book.getPrice());
			resultFromDB.setPublisher(book.getPublisher()==null?resultFromDB.getPublisher():book.getPublisher());
			resultFromDB.setReleasedate(book.getReleasedate()==null?resultFromDB.getReleasedate():book.getReleasedate());
			Books updatedData=	bookServiceImpl.updateBook(resultFromDB);
			return new Responce<>(HttpStatus.OK, updatedData, resultFromDB.getName()+ "updated sucessfully");
		}
			else
				return new Responce<>(HttpStatus.BAD_REQUEST, null,"bookid not found");
		

	}

	@DeleteMapping("/delete")
	public Responce<Books> deleteBook(@RequestParam int id) {
		Books resultFromDB=bookServiceImpl.getBookById(id);
		if(resultFromDB!=null) {
			String result=bookServiceImpl.deleteBook(id);
			return new Responce<>(HttpStatus.OK, null, result);
		}
		else
			return new Responce<>(HttpStatus.BAD_REQUEST, null, "id not found");
	}

	@GetMapping("/get")
	public Responce<Books> getBook(@RequestParam int id) {
		Books resultFromDB=	bookServiceImpl.getBookById(id);
		if(resultFromDB!=null)
			return new Responce<>(HttpStatus.OK,  resultFromDB, "Success");
		else
			return new Responce<>(HttpStatus.BAD_REQUEST,  null, "bookId not found");
	}

	@GetMapping("/getall")
	public Responce<List<Books>> getAllBooks() {
		List<Books> resultFromDB=bookServiceImpl.getAllBooks();
		if(resultFromDB==null)
			return new Responce<>(HttpStatus.BAD_REQUEST, null, "there is no books data"); 
		else
			return new Responce<>(HttpStatus.OK, resultFromDB, "OK"); 


	}

} 
