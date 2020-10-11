package com.cnsz.bootstrapping.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cnsz.bootstrapping.model.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Book getBook(Long id) {
		Book b = em.find(Book.class, id);
		return b;
	}

}
