package com.rmaciel.hibernatexml;

import java.util.List;

import com.rmaciel.hibernatexml.dao.UserDao;
import com.rmaciel.hibernatexml.entity.User;


/*
 * This is a Java 9 project so, the run action should add the module java.xml.bind
 * You should go to "Run Configuration", then click on tab "Arguments" and add the code "--add-modules java.xml.bind" to the "VM arguments" field
 */
public class App {
	public static void main(String[] args) {
		UserDao dao = new UserDao();

		User mario = new User("Super", "Mario", "super.mario@nitendo.com");
		User sonic = new User("Sonic", "Blue", "sonic.blue@mega.com");
		User dk = new User("Donkey", "Kong", "donkey.kong@nitendinho.com");

		dao.save(mario);
		dao.save(sonic);
		dao.save(dk);

		List<User> users = dao.listAll();
		users.forEach(user -> System.out.println(user));

	}
}
