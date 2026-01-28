package com.bookstore.service;

import java.util.List;

import com.bookstore.dao.BookJpaImpl;
import com.bookstore.dao.BookDao;
import com.bookstore.dao.DaoException;
import com.bookstore.dto.Book;

public class BookServiceImpl implements BookService {
	
	private BookDao bookDao;

	    public BookServiceImpl(BookDao bookDao) {
	        this.bookDao = bookDao;
	    }


	public BookServiceImpl() {
		bookDao = new BookJpaImpl();
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
		bookValidation(book);
		try {
			return bookDao.addBook(book);
		}catch(DaoException e){
			throw new RuntimeException("Unable to add the requested book",e);
		}
	}

	@Override
	public void deleteBook(int id) {
		idValidation(id);
		try {
			bookDao.deleteBook(id);
		}catch(DaoException e) {
			throw new RuntimeException("Unable to delete the requested book, book with the given id doen't exist.",e);
		}
		
	}

	@Override
	public void updateBook(int id, Book book) {
		idValidation(id);
		bookValidation(book);
		try {
			bookDao.updateBook(id, book);
		}catch(DaoException e) {
			throw new RuntimeException("Book with the given ID doesn't exist",e);
		}
	}

	@Override
	public Book getBookById(int id) {
		idValidation(id);
		try {
			return bookDao.getBookById(id);
		}catch(DaoException e) {
			throw new RuntimeException("Unable to get the requested book",e);
		}
			
		}
	
	public void bookValidation(Book book) {
		if(book == null) {
			throw new IllegalArgumentException("Book can't be null");
		}
		if(book.getPrice()<=0) {
			throw new IllegalArgumentException("Price must be positive");
		}
		if(book.getBookTitle() == null || book.getBookTitle().trim().isEmpty()) {
			throw new IllegalArgumentException("Book title must be entered");
		}
		if(book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
			throw new IllegalArgumentException("Author's name must be entered ");
		}
		
	}
	public void idValidation(int id) {
		if(id <=0 ) {
			throw new IllegalArgumentException("Id entered is invaid");
		}
	}
	
}
