package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entity.Book;
import com.app.exception.ResourceNotFoundException;
import com.app.repo.BookRepo;
@Service
public class BookServiceImpl implements BookService{
	
	private final BookRepo repo;
	
	  public BookServiceImpl(BookRepo repo) {
	        this.repo = repo;
	    }
	
	@Override
	public Book saveBook(Book book) {
		return repo.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Book getBookById(Integer id) {
		return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book with id " + id + " not found"));
	}

	@Override
	public void deleteBook(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public List<Book> getByAuthor(String author) {
		return repo.findByAuthor(author);
	}

	@Override
	public List<Book> getByPriceLessThan(Double price) {
		return repo.findByPriceLessThan(price);
	}

	@Override
	public List<Book> searchByTitle(String keyword) {

		return repo.searchByTitle(keyword);
	}

	@Override
	public List<Book> getByPriceRange(double min, double max) {

		return repo.findByPriceRange(min,max);
	}

}
