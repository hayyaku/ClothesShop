package com.clothesshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product-detail")
public class ProductDetailController {

	
	@GetMapping("/{id}")
	public String home(@PathVariable("id") Long id) {

		return "/home/product-detail";
	}
}
