package com.michal.carRental.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.michal.carRental.service.ProductService;




@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
		
	@RequestMapping("/carrent/search")
	public String searchCarName(@RequestParam("name") String carName ,Model model)
	{
	
		model.addAttribute("cars", productService.findCarByName(carName));

		return "rent";
		
	}
	

	@RequestMapping("/carrent/{ByCriteria}")
	public String searchCar(Model model,@MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterParams ,@RequestParam("name") String name)
	{
		
		model.addAttribute("cars", productService.getProductsByFilter(filterParams, name));
		

		return "rent";
		
	}
	
	
	
	
}

