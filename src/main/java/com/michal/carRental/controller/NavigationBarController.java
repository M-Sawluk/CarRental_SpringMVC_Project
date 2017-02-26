package com.michal.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michal.carRental.service.ProductService;
  
@Controller
public class NavigationBarController 
{
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/contacts")
	public String contacts(Model model) {
		
		return "contacts";
	}
	
	
	@RequestMapping("/carrent")
	public String carRent(Model model) {
		
		try
		{
		model.addAttribute("cars" , productService.getAllCars());
		}
		catch(Exception e)
		{
			return "rent";
		}
		
		
		return "rent";
	}
	
	
}
