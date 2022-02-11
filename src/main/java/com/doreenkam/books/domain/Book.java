package com.doreenkam.books.domain;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookID;
	
	@Column
	private String title;
	
	@Column
	private String author;
	
	@Column
	private String genre;
	
	@Column
	private float price;
	
	@Column
	private int stock;
	
	// default constructor 
	
	public Book() {
		
	}
	
	
	// test constructor

	public Book(long bookID, String title, String author, String genre, float price, int stock) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.stock = stock;
	}
	
	
	// third constructor

	public Book(String title, String author, String genre, float price, int stock) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.stock = stock;
	}
	
	
	// getters and setters

	public long getBookID() {
		return bookID;
	}


	public void setBookID(long bookID) {
		this.bookID = bookID;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", title=" + title + ", author=" + author +
				", genre=" + genre + ", price=" + price + ", stock=" + stock + "]"; }

	@Override
	public int hashCode() {
		return Objects.hash(author, genre, price, stock, title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(genre, other.genre)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price) && stock == other.stock
				&& Objects.equals(title, other.title);
	}
	
	

}
