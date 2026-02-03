package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dto.BookDto;
import com.app.entity.Book;
import com.app.repo.BookRepo;
@Service
public class BookService implements BookServiceInterface {
    private final BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }

	@Override
	public Book addBook(BookDto dto) {
		Book book = new Book();
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setPrice(dto.getPrice());
		
		return repo.save(book);
	}

	@Override
	public Book updateBook(Integer id, BookDto dto) {
		Book book= repo.findById(id);
		if(book == null) {
			throw new RuntimeException("Book not found witht the given id");
		}
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setPrice(dto.getPrice());
		return repo.save(book);
	}

	@Override
	public Book getBook(Integer id) {
        Book book = repo.findById(id);
        if (book == null) {
            throw new RuntimeException("Book not found with id " + id);
        }
        return book;
	}

	@Override
	public List<Book> getAllBooks() {
		return repo.findAll();
	}

	@Override
	public void deleteBook(Integer id) {
		repo.deleteById(id);
	}
}
