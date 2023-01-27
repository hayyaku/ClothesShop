package com.clothesshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomeController {


	@GetMapping(value = {"home","home/thoat"})
	public String home(Model model) {

		return "/home/home";
	}
	
	@GetMapping("products")
	public String products(Model model) {
		
		return "/home/product-list";
	}
}
