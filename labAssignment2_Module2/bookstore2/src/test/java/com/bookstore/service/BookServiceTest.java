package com.bookstore.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.DaoException;
import com.bookstore.dto.Book;


@ExtendWith(MockitoExtension.class)
class BookServiceTest {
	
	private static Logger logger = LogManager.getLogger(BookServiceTest.class);
	
	@Mock
	private BookDao mockDao;
	
	@InjectMocks
	private BookServiceImpl bookService;
	
    private Book book;

	
	@BeforeAll
	static void beforeAll() {
		logger.info("STARTING BOOKSERVICE TESTS");
	}
	
	@AfterAll
	 static void afterAll() {
		logger.info("ALL TESTS ARE FINISHED");
	}
	
	@BeforeEach
	void beforeEach() {
	    logger.info("Test started");
	    book = new Book(1, "ISBN1234","JAVA", "Robert Martin", 500);
	}

	@AfterEach
	 void afterEach() {
		logger.info("Test ended");
	}
	// positive test for book addition
	@Test
	void shouldAddBookSuccessfully() throws DaoException {
		logger.info("Test Starting -> positive addBook");
		
//		Book book = new Book("ISBN332","JAVA", "Author", 500);
		
		when(mockDao.addBook(book)).thenReturn(book);
		Book result = bookService.addBook(book);
		assertNotNull(result);
		assertEquals("JAVA",result.getBookTitle());
		verify(mockDao,times(1)).addBook(book);
		
		
	
	}
	
	// negative test
	@Test
	void shouldThrowExceptionWhenBookAddedWithInvalidPrice() {
		logger.info("Test Starting -> negative addBook");
//		Book book = new Book("ISBN332", "JAVA", "Author", -500);
		book.setPrice(-500);
		
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()->{bookService.addBook(book);});
		assertEquals("Price must be positive",thrown.getMessage());
		
	}
	@Test
	void shouldThrowExceptionWhenBookAddedWithEmptyTitle() {
		logger.info("Test Starting -> negative addBook");
//		Book book = new Book("ISBN332", " ", "Author", 500);
		book.setBookTitle(" ");
		
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()->bookService.addBook(book));
		assertEquals("Book title must be entered",thrown.getMessage());
		
	}
	
	// positive test of bookUpdation
	@Test
	void shouldUpdateBookSuccessfully() throws DaoException{
		logger.info("Test Starting -> positive updateBook");
//		Book updatedBook = new Book("ISBN332", "CPP", "Author", 500);
		
		doNothing().when(mockDao).updateBook(1,book);
		assertDoesNotThrow(()->bookService.updateBook(1, book));
		verify(mockDao,times(1)).updateBook(1, book);
		
//		Book originalBook = new Book("ISBN332", "JAVA", "Author", 500);
//		when(mockDao.addBook(originalBook)).thenReturn(originalBook);
//		when(mockDao.getBookById(1)).thenReturn(updatedBook);

	}
	// negative test
	@Test
	void shouldThrowExceptionWhenBookUpdatedWithEmptyAuthor() {
		logger.info("Test Starting -> negative updateBook");
	    book.setAuthor(" ");  
	    IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> bookService.updateBook(1, book)
	    );

	    assertEquals("Author's name must be entered ", thrown.getMessage());

//	    // DAO should NEVER be called
//	    verify(mockDao, never()).updateBook(anyInt(), any(Book.class));
	}

	
	// positive test of deleteBook
	@Test
	void shouldDeleteBookSuccessfully() throws DaoException{
		logger.info("Test Starting -> positive deleteBook");
		doNothing().when(mockDao).deleteBook(1);
		assertDoesNotThrow(()->bookService.deleteBook(1));
		verify(mockDao,times(1)).deleteBook(1);
		
	}
	
	// negative
	@Test 
	void shouldThrowExceptionWhenIdIsInvalidForDelete()  {
		logger.info("Test Starting -> negative zdeleteBook");
	    assertThrows(
	        IllegalArgumentException.class,
	        () -> bookService.deleteBook(0)
	    );
	    verifyNoInteractions(mockDao);
//	    verify(mockDao, never()).deleteBook(anyInt());
	}

	
	
	@Test
	void shouldReturnBookById() throws DaoException {
		logger.info("Test Starting -> positive findBookWithId");
		when(mockDao.getBookById(1)).thenReturn(book);
		
		Book result = bookService.getBookById(1);
		assertEquals(book, result);
	}
	@Test
	void shouldThrowExceptionWhenGetBookByInvalidId() {
		logger.info("Test Starting -> negative findBookWithId");
	    assertThrows(IllegalArgumentException.class,() -> bookService.getBookById(-1));
	}

	

}
