package com.app.service;

import com.app.entity.Book;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Integer id);
    void deleteBook(Integer id);

    List<Book> getByAuthor(String author);
//    List<Book> getByCategory(Category category);
    List<Book> getByPriceLessThan(Double price);
    List<Book> searchByTitle(String keyword);
    List<Book> getByPriceRange(double min, double max);
}

