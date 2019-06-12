package com.rmaciel.codestore.store.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rmaciel.codestore.store.models.Book;

@Repository
@Transactional
public class BookDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Book book) {
		manager.persist(book);
	}
	

}
