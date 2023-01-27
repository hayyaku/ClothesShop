package com.clothesshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@GetMapping("home")
	public String home(Model model) {
			return "/admin/home";
	}

	@GetMapping("create-product")
	public String createProduct(Model model) {
		
		return "/admin/create-product";
	}
	@GetMapping("update-product/{id}")
	public String updateProduct(@PathVariable("id") Long id) {
		
		return "/admin/update-product";
	}
}
