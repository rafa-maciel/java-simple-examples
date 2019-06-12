package com.rmaciel.codestore.store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rmaciel.codestore.store.daos.BookDAO;
import com.rmaciel.codestore.store.models.Book;

@Controller
public class BookController {
	
	@Autowired
	private BookDAO bookDAO;
	
	@RequestMapping("/books/form")
	public String form() {
		return "books/form";
	}
	
	@RequestMapping("/books")
	public String save(Book book) {
		bookDAO.save(book);
		System.out.println(book);

		return "books/ok";
	}

}
