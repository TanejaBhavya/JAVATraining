
package com.bookstore.util;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmFactory {

	private static EntityManagerFactory entityManagerFactory;

	public static EntityManagerFactory getEntityManagerFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("bookstore3_pu");
		return entityManagerFactory;
	}
}
