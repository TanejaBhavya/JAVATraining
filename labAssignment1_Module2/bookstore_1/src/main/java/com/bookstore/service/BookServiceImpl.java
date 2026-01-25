package com.bookstore.service;

import java.sql.SQLException;
import java.util.List;

import com.bookstore.dao.BookJdbcImpl;
import com.bookstore.dao.BookDao;
import com.bookstore.dao.DaoException;
import com.bookstore.dto.Book;

public class BookServiceImpl implements BookService {
//		BookJdbcImpl bookDao;
//		try {
//			bookDao = new BookJdbcImpl();
//	
//		List<Book> books = bookDao.getAllBooks();
//		books.forEach(b-> System.out.println(b));
//		Book book=bookDao.addBook(new Book("978-9351340201", "effective java", "abc", 340.00));
//		System.out.println(book);
//		} catch (DaoException | SQLException e) {
//			
//		}
//	}
	
	
	
	
	private BookDao bookDao;
	public BookServiceImpl() {
		try {
			bookDao = new BookJdbcImpl();
		} catch (DaoException e) {
			
			e.printStackTrace();
		}
	}
	

	
	
	
	
	@Override
	public List<Book> getAllBooks() {
		try {
			return bookDao.getAllBooks();
		}catch(DaoException e) {
			throw new RuntimeException("Unable to display books",e);
		}
	}

	@Override
	public Book addBook(Book book) {
		if(book.getPrice()<=0) {
			throw new IllegalArgumentException("Price must be positive");
		}
		try {
			return bookDao.addBook(book);
		}catch(DaoException e){
			throw new RuntimeException("Unable to add the requested book",e);
		}
	}

	@Override
	public void deleteBook(int id) {
		try {
			bookDao.deleteBook(id);
		}catch(DaoException e) {
			throw new RuntimeException("Unable to delete the requested book, book with the given id doen't exist.",e);
		}
		
	}

	@Override
	public void updateBook(int id, Book book) {
		
		if(book.getPrice()<=0) {
			throw new IllegalArgumentException("Price must be positive");
		}
	
		try {
			bookDao.updateBook(id, book);
		}catch(DaoException e) {
			throw new RuntimeException("Book with the given ID doesn't exist",e);
		}
	}

	@Override
	public Book getBookById(int id) {
		try {
			return bookDao.getBookById(id);
		}catch(DaoException e) {
			throw new RuntimeException("Unable to get the requested book",e);
		}
			
		}
}
