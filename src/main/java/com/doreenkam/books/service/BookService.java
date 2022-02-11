package com.doreenkam.books.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.doreenkam.books.domain.Book;
import com.doreenkam.books.repo.BookRepo;

@Service
public class BookService implements CRUDService<Book> {
	
	private BookRepo bookRepo;

	public BookService(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Override
	public Book create(Book book) {
		return this.bookRepo.save(book);
	}

	@Override
	public List<Book> getAll() {
		return this.bookRepo.findAll();
	}

	@Override
	public Book getByID(long bookID) {
		Optional<Book> optionalBook = this.bookRepo.findById(bookID);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		}
		return null;
	}

	@Override
	public Book update(long bookID, Book updatedBook) {
		Optional<Book> optionalBook = this.bookRepo.findById(bookID);
		if (optionalBook.isPresent()) {
			Book existingBook = optionalBook.get();
			existingBook.setTitle(updatedBook.getTitle());
			existingBook.setAuthor(updatedBook.getAuthor());
			existingBook.setGenre(updatedBook.getGenre());
			existingBook.setPrice(updatedBook.getPrice());
			existingBook.setStock(updatedBook.getStock());
			
			return this.bookRepo.save(existingBook);
		}
		
		return null;

	}

	@Override
	public boolean delete(long bookID) {
		this.bookRepo.deleteById(bookID);
		boolean exists = this.bookRepo.existsById(bookID);
		return !exists;
	}

	
}
