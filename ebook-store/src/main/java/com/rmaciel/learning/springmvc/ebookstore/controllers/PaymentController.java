package com.rmaciel.learning.springmvc.ebookstore.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rmaciel.learning.springmvc.ebookstore.models.Cart;
import com.rmaciel.learning.springmvc.ebookstore.models.PaymentData;

@Controller
@RequestMapping("/payment")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class PaymentController {
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method=RequestMethod.POST)
	public Callable<ModelAndView> finish(RedirectAttributes model) {
		return () -> {
			String uri = "http://book-payment.herokuapp.com/payment";
			
			try {
				PaymentData data = new PaymentData(cart.getTotal());
				String response = restTemplate.postForObject(uri, data, String.class);
				model.addFlashAttribute("message", response);
			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				model.addFlashAttribute("message", "Your bought has been cancelled, your bill exceed the limit of capitalism");
			}
			
			return new ModelAndView("redirect:/ebooks");
		};
	}

}
