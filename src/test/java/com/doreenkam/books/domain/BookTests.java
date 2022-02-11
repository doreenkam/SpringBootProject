package com.doreenkam.books.domain;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
@ActiveProfiles("test")
public class BookTests {
	
	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Book.class).usingGetClass().verify();
	}
	
	@Test
	public void constructorWithIdTest() {
		Book book = new Book(1L, "Title", "Author", "Genre", 5.99F, 10);
		assertNotNull(book.getBookID());
		assertNotNull(book.getTitle());
		assertNotNull(book.getAuthor());
		assertNotNull(book.getGenre());
		assertNotNull(book.getPrice());
		assertNotNull(book.getStock());
		
		assertEquals(1L, book.getBookID());
		assertEquals("Title", book.getTitle());
		assertEquals("Author", book.getAuthor());
		assertEquals("Genre", book.getGenre());
		assertEquals(5.99F, book.getPrice());
		assertEquals(10, book.getStock());
	}
	
	@Test
	public void constructorWithoutIdTest() {
		Book book = new Book(1L, "Title", "Author", "Genre", 5.99F, 10);
		assertNotNull(book.getBookID());
		assertNotNull(book.getTitle());
		assertNotNull(book.getAuthor());
		assertNotNull(book.getGenre());
		assertNotNull(book.getPrice());
		assertNotNull(book.getStock());
		
		assertEquals(1L, book.getBookID());
		assertEquals("Title", book.getTitle());
		assertEquals("Author", book.getAuthor());
		assertEquals("Genre", book.getGenre());
		assertEquals(5.99F, book.getPrice());
		assertEquals(10, book.getStock());
	}
	
	@Test
	public void toStringTest() {
		Book book = new Book("Title", "Author", "Genre", 5.99F, 10);
		assertEquals("Book [bookID=0, title=Title, author=Author, genre=Genre, price=5.99, stock=10]", book.toString()); 
	}
	
	
	@Test
	public void settersTest() {
		Book book = new Book();
		
		book.setBookID(1);
		book.setTitle("Animal Farm");
		book.setAuthor("George Orwell");
		book.setGenre("Satirical Allegory");
		book.setPrice(8.99F);
		book.setStock(20);
		
		assertNotNull(book.getBookID());
		assertNotNull(book.getTitle());
		assertNotNull(book.getAuthor());
		assertNotNull(book.getGenre());
		assertNotNull(book.getPrice());
		assertNotNull(book.getStock());
		;
		assertEquals(1L, book.getBookID());
		assertEquals("Animal Farm", book.getTitle());
		assertEquals("George Orwell", book.getAuthor());
		assertEquals("Satirical Allegory", book.getGenre());
		assertEquals(8.99F, book.getPrice());
		assertEquals(20, book.getStock());
		
	}

}
