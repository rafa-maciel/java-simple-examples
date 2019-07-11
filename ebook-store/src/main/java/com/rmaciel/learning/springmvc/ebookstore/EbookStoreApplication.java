package com.rmaciel.learning.springmvc.ebookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.rmaciel.learning.springmvc.ebookstore.controllers.HomeController;
import com.rmaciel.learning.springmvc.ebookstore.daos.EbookDAO;
import com.rmaciel.learning.springmvc.ebookstore.models.Ebook;

@SpringBootApplication
@ComponentScan(basePackageClasses= {HomeController.class, EbookDAO.class, Ebook.class})
public class EbookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbookStoreApplication.class, args);
	}
	
	@Bean
	public MessageSource messageSource( ) {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		
		return messageSource;
	}
	
}
