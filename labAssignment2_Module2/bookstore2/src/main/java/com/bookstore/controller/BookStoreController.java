package com.bookstore.controller;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookJdbcImpl;
import com.bookstore.dao.DaoException;
import com.bookstore.dto.Book;
import com.bookstore.service.BookService;
import com.bookstore.service.BookServiceImpl;
import com.bookstore.util.ConnectionFactory;


public class BookStoreController {
	private static BookService bookService = new BookServiceImpl();
	private static Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
			while(true) {
				printMenu();
				int choice = scan.nextInt();
				
				try {
					switch(choice) {
					case 1: addBook();
					break;
					
					case 2: updateBook();
					break;
					
					case 3:deleteBook();
					break;
					
					case 4: findBook();
					break;
					
					case 5: listBooks();
					break;
					
					case 6: 
						System.out.println("......... closing the application .....");
						return;
					default :
						System.out.println("Invalid choice");
					}
					
				}catch(Exception e) {
					System.out.println("Error occured "+ e.getMessage());
				}
			}
	
			
	}
	
	private static void printMenu() {
		System.out.println("............Book Store Menu...............");
		System.out.println("1. Add a book");
		System.out.println("2. Update a book");
		System.out.println("3. Delete a book");
		System.out.println("4. Find a book by ID");
		System.out.println("5. List all books in store");
		System.out.println("6. Exit menu");
		System.out.println("Enter your choice : ");
	}
	
	private static void addBook() {
		System.out.println("ISBN: ");
		String isbn = scan.nextLine();
		scan.nextLine();
		System.out.println("Title: ");
		String title = scan.nextLine();
		System.out.println("Author: ");
		String author = scan.nextLine();
		System.out.println("Price: ");
		double price = scan.nextDouble();
		
		Book b = new Book(isbn,title,author,price);
		Book added = bookService.addBook(b);
		
		System.out.println("The book " + added + " is successfully added !");
		
	}
	
	private static void updateBook() {
		System.out.println("Book id : ");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.println("New ISBN: ");
		String isbn = scan.nextLine();
		System.out.println("New title: ");
		String title = scan.nextLine();
		System.out.println("New Author: ");
		String author = scan.nextLine();
		System.out.println("New Price: ");
		double price = scan.nextDouble();
		
		Book b = new Book(isbn, title, author, price);
		bookService.updateBook(id, b);
		System.out.println("Book updated succesfully");
	}
	
	private static void deleteBook() {
		System.out.println("Enter ID: ");
		int id = scan.nextInt();
		bookService.deleteBook(id);
		
		System.out.println("Book deleted Successfully");
	}
	
	private static void findBook() {
		System.out.println("Enter ID: ");
		int id = scan.nextInt();
		Book b = bookService.getBookById(id);
		System.out.println(b !=null? b : "Book not found");
	}
	private static void listBooks() {
		List<Book> books = bookService.getAllBooks();
		books.forEach(	System.out::println);
	}

}
