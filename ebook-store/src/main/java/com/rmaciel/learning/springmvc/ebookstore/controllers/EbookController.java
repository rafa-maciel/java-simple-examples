package com.rmaciel.learning.springmvc.ebookstore.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rmaciel.learning.springmvc.ebookstore.daos.EbookDAO;
import com.rmaciel.learning.springmvc.ebookstore.models.Ebook;
import com.rmaciel.learning.springmvc.ebookstore.models.TypePrice;
import com.rmaciel.learning.springmvc.ebookstore.validators.EbookValidator;

@Controller
@RequestMapping("/ebooks")
public class EbookController {
	
	@Autowired
	private EbookDAO dao;
	
	@InitBinder
	private void initBind(WebDataBinder binder) {
		binder.addValidators(new EbookValidator());
	}
	
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView("ebooks/form");
		mav.addObject("types", TypePrice.values());
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView save(@Valid Ebook ebook, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors())
			return form();
		
		dao.save(ebook);
		attributes.addFlashAttribute("message", "Your book has been saved with success!");
		return new ModelAndView("redirect:/ebooks");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list() {
		List<Ebook> ebooks = dao.listAll();
		System.out.println(ebooks);
		ModelAndView view = new ModelAndView("ebooks/list");
		view.addObject("ebooks", ebooks);
		return view;
	}

}
