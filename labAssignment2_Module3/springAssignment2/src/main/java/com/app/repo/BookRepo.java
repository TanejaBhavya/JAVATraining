package com.app.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.app.entity.Book;

@Repository
public class BookRepo {
	
    private final Map<Integer, Book> store = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger(1);
    
    
    public Book save(Book book) { 
    	if(book.getId()==null) {
    		book.setId(counter.getAndIncrement());
    	}
    	store.put(book.getId(), book);
    	return book;
    }
    public Book findById(Integer id) {
    	return store.get(id);
    }
    public List<Book> findAll() { 
    	return new ArrayList<>(store.values());
    }
    public void deleteById(Integer id) { 
    	store.remove(id);
    }
    
}
