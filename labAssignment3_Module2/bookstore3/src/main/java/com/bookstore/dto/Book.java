package com.bookstore.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "isbn")
	private String ISBN;
	@Column(name = "title")
	private String BookTitle;
	@Column(name = "author")
	private String Author;
	@Column(name = "price")
	private double price;

	public Book(int id , String ISBN, String BookTitle, String author, double price) {
		this.BookTitle = BookTitle;
		this.id = id;
		this.ISBN = ISBN;
		this.Author=author;
		this. price= price;
	}
	public Book() {}
	
	
	
	public Book(String ISBN, String BookTitle, String author, double price) {
		this.BookTitle = BookTitle;
		this.ISBN = ISBN;
		this.Author=author;
		this. price= price;
	}
	public String getBookTitle() {
		return BookTitle;
	}

	public void setBookTitle(String bookTitle) {
		BookTitle = bookTitle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public double  getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this. price = price;
	}
	
	@Override
	public String toString() {
		return "Book [id: " + id + ", isbn: " + ISBN + ", title: " + BookTitle + 
				", author : " + Author + ", price : " + price +" ]";
	}
	
	
}
