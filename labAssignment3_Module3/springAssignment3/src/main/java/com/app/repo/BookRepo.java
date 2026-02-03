package com.app.repo;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.Book;

public interface BookRepo extends JpaRepository<Book,Integer> {
	List<Book> findByAuthor(String author);

    List<Book> findByPriceLessThan(Double price);

    List<Book> findByCategory(Category category);

    boolean existsByIsbn(String isbn);

    void deleteByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword%")
    List<Book> searchByTitle(@Param("keyword") String keyword);

    @Query("SELECT b FROM Book b ORDER BY b.price DESC")
    List<Book> sortByPriceDesc();

    @Query(
        value = "SELECT * FROM books WHERE price BETWEEN ?1 AND ?2",
        nativeQuery = true
    )
    List<Book> findByPriceRange(double min, double max);
}
