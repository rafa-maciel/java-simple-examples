package com.rmaciel.learning.springmvc.ebookstore.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rmaciel.learning.springmvc.ebookstore.models.Ebook;

@Repository
@Transactional
public class EbookDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Ebook ebook) {
		manager.persist(ebook);
	}

}
