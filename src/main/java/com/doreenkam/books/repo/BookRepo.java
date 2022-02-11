package com.doreenkam.books.repo;

import com.doreenkam.books.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
	
	Book findBookByTitle(String title);

}
