package com.rmaciel.learning.springmvc.ebookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.rmaciel.learning.springmvc.ebookstore.daos.EbookDAO;
import com.rmaciel.learning.springmvc.ebookstore.models.Cart;
import com.rmaciel.learning.springmvc.ebookstore.models.CartItem;
import com.rmaciel.learning.springmvc.ebookstore.models.Ebook;
import com.rmaciel.learning.springmvc.ebookstore.models.TypePrice;

@Controller
@RequestMapping("/cart")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CartController {
	@Autowired
	private EbookDAO dao;
	
	@Autowired
	private Cart cart;
	
	@RequestMapping(method=RequestMethod.POST, path="add")
	public ModelAndView add(Integer ebookId, TypePrice typePrice) {
		ModelAndView view = new ModelAndView("redirect:/cart");
		Ebook ebook = dao.find(ebookId);
		CartItem cartItem = new CartItem(ebook, typePrice);
		cart.add(cartItem);
		
		return view;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView items() {
		return new ModelAndView("cart/items");
	}
	
	@RequestMapping(method=RequestMethod.POST, path="remove")
	public ModelAndView remove(Integer ebookId, TypePrice typePrice) {
		Ebook ebook = new Ebook();
		ebook.setId(ebookId);
		
		cart.remove(ebook, typePrice);
		return new ModelAndView("redirect:/cart");
		
	}
}
