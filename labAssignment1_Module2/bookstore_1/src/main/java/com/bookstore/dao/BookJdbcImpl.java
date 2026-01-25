package com.bookstore.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dto.Book;
import com.bookstore.util.ConnectionFactory;

public class BookJdbcImpl implements BookDao {

	private Connection connection;

	public BookJdbcImpl() throws DaoException  {
		try {
			connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			throw new DaoException("connection can't be established",e);
		}
	}

	@Override
	public List<Book> getAllBooks() throws DaoException {
		List<Book> books = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from books");
			while (rs.next()) {
				books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));

			}
		} catch (SQLException e) {
			throw new DaoException("Failed to get books",e);
		}
		return books;
	}
	

	
	
	@Override
	public Book addBook(Book book) throws DaoException{
		try {
			PreparedStatement psmt = connection.prepareStatement(
					"insert into books(isbn,title,author,price) values(?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, book.getISBN());
			psmt.setString(2, book.getBookTitle());
			psmt.setString(3, book.getAuthor());
			psmt.setDouble(4, book.getPrice());

			psmt.executeUpdate();
			ResultSet rs = psmt.getGeneratedKeys();
			if (rs.next()) {
				book.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new DaoException("Failed to add books",e);
		}
		return book;
	}
	
	
	
	
	
	
	

	@Override
	public void deleteBook(int id) throws DaoException {
		try(PreparedStatement psmt = connection.prepareStatement("delete FROM books WHERE id = ? ");){
			
			psmt.setInt(1, id);
			int rows = psmt.executeUpdate();
			
			if(rows == 0) {
				throw new DaoException("Book with id : "+ id + " not found.",null);
			}
			
		} catch (SQLException e) {
			throw new DaoException("Failed to delete the book with id: " + id,e);
		}
		
	}

	
	
	@Override
	public void updateBook(int id, Book book) throws DaoException {
		try(PreparedStatement psmt = connection.prepareStatement("Update books set isbn = ?, title = ? , author = ?, price = ?  WHERE id = ? ");){
			
			psmt.setString(1,book.getISBN());
			psmt.setString(2, book.getBookTitle());
			psmt.setString(3, book.getAuthor());
			psmt.setDouble(4, book.getPrice());
			psmt.setInt(5, id);
			
			int rows = psmt.executeUpdate();
			if(rows==0) {
				throw new DaoException("No book with id : " + id + " found",null);
			}
			
		} catch (SQLException e) {
			throw new DaoException("Failed to update book with id : "+id, e);
		}
		
	}

	
	
	
	
	
	@Override
	public Book getBookById(int id) throws DaoException {
		Book book = null;
		
		try(PreparedStatement psmt = connection.prepareStatement("SELECT * FROM books WHERE id = ? ");){
			
			psmt.setInt(1, id);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
			}
			
			
		}catch(SQLException e) {
			throw new DaoException("Failed to find book with id : " + id,e);
		}
		
		return book;
	}
	
	
	

}
