package com.rmaciel.learning.springmvc.ebookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(Model model) {
		System.out.println("All right! we started our web application");
		model.addAttribute("message", "Congratulations! little bug.");
		return "home";
	}

}
