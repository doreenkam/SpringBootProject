package com.doreenkam.books.service;

import java.util.List;

public interface CRUDService<T> {
	
	// Create Method
	T create (T t);
		
	// Read All
	List<T> getAll();
		
	// Read By
	T getByID(long bookid);
		
	// Update (Take in an Id and Object)
	T update(long bookid, T t);
		
	// DELETE -- It is either present or not
	boolean delete(long bookid);

}
