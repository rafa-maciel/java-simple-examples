package com.rmaciel.hibernateconfigexample;

import java.util.List;

import com.rmaciel.hibernateconfigexample.dao.UserDao;
import com.rmaciel.hibernateconfigexample.entity.User;


/*
 * This is a Java 9 project so, the run action should add the module java.xml.bind
 * You should go to "Run Configuration", then click on tab "Arguments" and add the code "--add-modules java.xml.bind" to the "VM arguments" field
 */
public class App {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		
		User peter = new User("Peter", "Parker", "iamnot@spider.com");
		User tony = new User("Tony", "Stark", "iron.man@me.com");
		User doctor = new User("Doctor", "Strange", "doctor.strange@wizard.com");
		
		dao.save(peter);
		dao.save(tony);
		dao.save(doctor);
		
		List<User> users = dao.listAll();
		users.forEach(user -> System.out.println(user));
		
	}
}
