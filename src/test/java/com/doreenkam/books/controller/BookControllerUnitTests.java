package com.doreenkam.books.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.doreenkam.books.domain.Book;
import com.doreenkam.books.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BookControllerUnitTests {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper map;
	
	@MockBean 
	BookService bookService;
	
	
	@Test
	public void createTest() throws Exception {
		Book newBook = new Book("Nineteen Eighty-Four", "George Orwell", "Dystopian Sci-Fi", 8.99F, 25);
		String newBookJSON = this.map.writeValueAsString(newBook);
		
		Mockito.when(this.bookService.create(newBook)).thenReturn(newBook);
		
		mock.perform(post("/book/create")
				.content(newBookJSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
		
	}
	
	
	@Test
	public void getAllTest() throws Exception {
		List<Book> mockOutput = new ArrayList<Book>();
		mockOutput.add(new Book (1L, "Catch 22", "Joseph Heller", "Satire", 5.99F, 30));
		mockOutput.add(new Book (2L, "Tess of the d'Urbervilles", "Thomas Hardy", "Social Novel", 4.99F, 20));
		
		String mockOutputJSON = this.map.writeValueAsString(mockOutput);
		
		Mockito.when(this.bookService.getAll()).thenReturn(mockOutput);
		
		mock.perform(get("/book/getAll"))
				.andExpect(status().isOk())
				.andExpect(content().json(mockOutputJSON));
	}
	
	
	@Test
	public void getByIdTest() throws Exception {
		long bookID = 3L;
		Book mockBook = new Book(3L, "Catch 22", "Joseph Heller", "Satire", 5.99F, 30);
		String mockBookJSON = this.map.writeValueAsString(mockBook);
		
		Mockito.when(this.bookService.getByID(bookID)).thenReturn(mockBook);
		
		mock.perform(get("/book/getById/3"))
				.andExpect(status().isOk())
				.andExpect(content().json(mockBookJSON));
	}
	
	
	@Test
	public void updateTest() throws Exception {
		long bookID = 4L;
		Book newBook = new Book("Little Women", "Louisa May Alcott ", "Coming of Age", 8.99F, 20);
		Book mockBook = new Book(4L, "Little Women", "Louisa May Alcott ", "Coming of Age", 8.99F, 20);
		String newBookJSON = this.map.writeValueAsString(newBook);
		String mockBookJSON = this.map.writeValueAsString(mockBook);
		
		Mockito.when(this.bookService.update(bookID, newBook)).thenReturn(mockBook);
		
		mock.perform(put("/book/update/4")
				.content(newBookJSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted())
				.andExpect(content().json(mockBookJSON));
	}
	
	
	@Test
	public void deleteTest() throws Exception {
		long invalidID = 6L;
		Mockito.when(this.bookService.delete(invalidID)).thenReturn(false);
		
		
		mock.perform(delete("/book/delete/6"))
		.andExpect(status().isNotFound());
		
		
		}
		
		
}
	
	
