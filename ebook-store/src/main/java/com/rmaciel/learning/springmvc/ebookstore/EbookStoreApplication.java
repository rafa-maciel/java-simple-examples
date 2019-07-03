package com.rmaciel.learning.springmvc.ebookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.rmaciel.learning.springmvc.ebookstore.controllers.HomeController;
import com.rmaciel.learning.springmvc.ebookstore.daos.EbookDAO;
import com.rmaciel.learning.springmvc.ebookstore.models.Ebook;

@SpringBootApplication
@ComponentScan(basePackageClasses= {HomeController.class, EbookDAO.class, Ebook.class})
public class EbookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbookStoreApplication.class, args);
	}

}
