package com.doreenkam.books.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doreenkam.books.domain.Book;
import com.doreenkam.books.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	
	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	// CREATE (POST Request)
	@PostMapping("/create")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(this.bookService.create(book), HttpStatus.CREATED);
		
	}
	
	// READ ALL (GET Request)
	@GetMapping("/getAll")
	public ResponseEntity<List<Book>> getAllBooks() {
		return new ResponseEntity<List<Book>>(this.bookService.getAll(), HttpStatus.OK);
	}
	
	// READ BY ID (GET Request)
	@GetMapping("/getById/{bookID}")
	public ResponseEntity<Book> readByIdBook(@PathVariable long bookID) {
		return new ResponseEntity<Book>(this.bookService.getByID(bookID), HttpStatus.OK);
		
	}
	
	
	// UPDATE BY ID (PUT Request)
	@PutMapping("/update/{bookID}")
	public ResponseEntity<Book> updateBook(@PathVariable long bookID, @RequestBody Book book) {
		return new ResponseEntity<Book>(this.bookService.update(bookID, book), HttpStatus.ACCEPTED);
	}
	
	// DELETE BY ID (DELETE Request)
	@DeleteMapping("/delete/{bookID}")
	public ResponseEntity<Boolean> deleteBook(@PathVariable long bookID) {
		return (this.bookService.delete(bookID))
				? new ResponseEntity<Boolean>(HttpStatus.OK)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		
		
	}
	
	

}
