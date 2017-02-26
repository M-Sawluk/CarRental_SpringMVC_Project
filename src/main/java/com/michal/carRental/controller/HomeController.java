package com.michal.carRental.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michal.carRental.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productSerivce;

	@RequestMapping("/")
	public String welcome(Model model){
		
		
		try
			{	
				model.addAttribute("list",productSerivce.getCarForCarousel());
				
				
			}
		catch(Exception e)
			{
				return "welcome";
			}
		
		return "welcome";
	}
	

}