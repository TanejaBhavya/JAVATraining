package com.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookDto;
import com.app.entity.Book;
import com.app.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController implements BookControllerInterface{
	private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }
    


    @PostMapping
	@Override
	public Book addBook(@RequestBody BookDto dto) {
		return service.addBook(dto);
	}
	
	@PutMapping("/{id}")
	@Override
	public Book updateBook(@PathVariable Integer id, @RequestBody BookDto dto) {
		return service.updateBook(id, dto);
	}
	
	@GetMapping("/{id}")
	@Override
	public Book getBook(@PathVariable Integer id) {
		return service.getBook(id);
	}
	
    @GetMapping
	@Override
	public List<Book> getAllBooks() {
		return service.getAllBooks();
	}
    
    @DeleteMapping("/{id}")
    @Override 
	public void deleteBook(@PathVariable Integer id) {
		service.deleteBook(id);
	}

}
