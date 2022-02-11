package com.doreenkam.books.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.doreenkam.books.domain.Book;
import com.doreenkam.books.repo.BookRepo;

@SpringBootTest
@ActiveProfiles("test")
public class BookServiceUnitTests {
	
	@Autowired
	private BookService service;
	
	@MockBean
	private BookRepo bookRepo;
	
	@Test
	public void createTest() {
		Book testInput = new Book("Animal Farm", "George Orwell", "Satirical Allegory", 8.99F, 20);
		Book mockOutput = new Book(1L, "Animal Farm", "George Orwell", "Satirical Allegory", 8.99F, 20);
		Mockito.when(this.bookRepo.save(testInput)).thenReturn(mockOutput);
	
		assertEquals(mockOutput, this.service.create(testInput));
		
		Mockito.verify(this.bookRepo, Mockito.times(1)).save(testInput);
	}
	
	@Test
	public void getAllTest() {
		List<Book> mockOutput = new ArrayList<Book>();
		mockOutput.add(new Book (1L, "Catch 22", "Joseph Heller", "Satire", 5.99F, 30));
		mockOutput.add(new Book (2L, "Tess of the d'Urbervilles", "Thomas Hardy", "Social Novel", 4.99F, 20));
		Mockito.when(this.bookRepo.findAll()).thenReturn(mockOutput);
		
		assertEquals(mockOutput, this.service.getAll());
		
		Mockito.verify(this.bookRepo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void getByIdTest() {
		long validID = 3L;
		long invalidID = 4L;
		Optional<Book> validBook = 
				Optional.ofNullable(new Book(3L, "Tess of the d'Urbervilles", "Thomas Hardy", "Social Novel", 4.99F, 20));
		Optional<Book> invalidBook =
				Optional.ofNullable(null);
		
		Mockito.when(this.bookRepo.findById(validID)).thenReturn(validBook);
		Mockito.when(this.bookRepo.findById(invalidID)).thenReturn(invalidBook);
		
		assertEquals(validBook.get(), this.service.getByID(validID));
		assertEquals(null, this.service.getByID(invalidID));
		
		Mockito.verify(this.bookRepo, Mockito.times(1)).findById(validID);
		Mockito.verify(this.bookRepo, Mockito.times(1)).findById(invalidID);
	}
	
	
	@Test
	public void updateTest() {
		Long bookID = 1L;
		Book toUpdate = new Book("Tess of the d'Urbervilles", "Thomas Hardy", "Social Novel", 4.99F, 20);
		Optional<Book> optBook = Optional.of(new Book(bookID, null, null, null, 0, 0));
		Book updated = new Book(bookID, toUpdate.getTitle(), toUpdate.getAuthor(), toUpdate.getGenre(), toUpdate.getPrice(), toUpdate.getStock());
		
		Mockito.when(this.bookRepo.findById(bookID)).thenReturn(optBook);
		Mockito.when(this.bookRepo.save(updated)).thenReturn(updated);
		
		assertThat(this.service.update(bookID, toUpdate)).isEqualTo(updated);
		
		Mockito.verify(this.bookRepo, Mockito.times(1)).save(updated);
		Mockito.verify(this.bookRepo, Mockito.times(1)).findById(bookID);
		
	}
	
	@Test
	public void deleteTest() {
		Long invalidID = 5L;
		Mockito.when(this.bookRepo.existsById(invalidID)).thenReturn(false);
		assertEquals(true, this.service.delete(invalidID));
		
		Mockito.verify(this.bookRepo, Mockito.times(1)).deleteById(invalidID);
	}

}
