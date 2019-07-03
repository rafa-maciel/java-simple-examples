package com.rmaciel.learning.springmvc.ebookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rmaciel.learning.springmvc.ebookstore.daos.EbookDAO;
import com.rmaciel.learning.springmvc.ebookstore.models.Ebook;
import com.rmaciel.learning.springmvc.ebookstore.models.TypePrice;

@Controller
public class EbookController {
	
	@Autowired
	private EbookDAO dao;
	
	@RequestMapping("/ebooks/form")
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView("ebooks/form");
		mav.addObject("types", TypePrice.values());
		return mav;
	}
	
	@RequestMapping("/ebooks")
	public String save(Ebook ebook) {
		dao.save(ebook);
		return "/ebooks/ok";
	}

}
