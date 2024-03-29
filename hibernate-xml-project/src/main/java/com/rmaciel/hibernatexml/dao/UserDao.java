package com.rmaciel.hibernatexml.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rmaciel.hibernatexml.entity.User;
import com.rmaciel.hibernatexml.util.HibernateUtil;

public class UserDao {
	
	public void save(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// Start a transaction
			transaction = session.beginTransaction();
			//save the user
			session.save(user);
			// commit transaction
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public List<User> listAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from User", User.class).list();
		}
	}

}
