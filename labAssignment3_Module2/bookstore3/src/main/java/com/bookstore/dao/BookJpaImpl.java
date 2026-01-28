package com.bookstore.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dto.Book;
import com.bookstore.util.EmFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;


public class BookJpaImpl implements BookDao {

	private EntityManagerFactory entityManagerFactory;
	
	public BookJpaImpl() {
		entityManagerFactory=EmFactory.getEntityManagerFactory();
	}
	

	@Override
	public List<Book> getAllBooks() throws DaoException {
		
		List<Book> books = null;
		try(EntityManager em=entityManagerFactory.createEntityManager();) {
		    return em.createQuery("select b from Book b", Book.class)
		             .getResultList();
		} catch (PersistenceException e) {
		    throw new DaoException("Failed to get books", e);
		}
	}
	
	
	@Override
	public Book addBook(Book book) throws DaoException{
		try(EntityManager em=entityManagerFactory.createEntityManager();){
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(book);
			tx.commit();
		}catch(PersistenceException e){
			throw new DaoException("Failed to add the book",e);
		}
		
		return book;
	}
	
	


	@Override
	public void deleteBook(int id) throws DaoException {
		
	    EntityTransaction tx = null;
	    try(EntityManager em = entityManagerFactory.createEntityManager();) {
	        tx = em.getTransaction();
	        tx.begin();

	        Book book = em.find(Book.class, id);

	        if (book == null) {
	            throw new DaoException("Book with id : " + id + " not found.", null);
	        }

	        em.remove(book);
	        tx.commit();

	    } catch (PersistenceException e) {

	        if (tx != null && tx.isActive()) {
	            tx.rollback();
	        }

	        throw new DaoException(
	            "Failed to delete the book with id: " + id, e);

	    }
	  }
	
	
		
	

	
	
	@Override
	public void updateBook(int id, Book book) throws DaoException {
		
	    EntityTransaction tx = null;
	    try(EntityManager em = entityManagerFactory.createEntityManager();) {
	       tx.begin();
	       
	       Book present = em.find(Book.class, id);
	       if(present == null) {
	    	    throw new DaoException("No book with id : " + id + " found ", null );
	       }
	       em.merge(book);
	       tx.commit();
	       	
	    } catch (PersistenceException e) {

	        if (tx.isActive()) {
	            tx.rollback();
	        }

	        throw new DaoException("Failed to update the book with id: " + id, e);

	    }
		
	}

	
	
	
	
	
	@Override
	public Book getBookById(int id) throws DaoException {

	    try(EntityManager em = entityManagerFactory.createEntityManager();) {
	    	return em.find(Book.class, id);
	      
	    } catch (PersistenceException e) {

	        throw new DaoException("Failed to find the book with id: " + id, e);

	    }
	}
	
	
	
	
	

}
