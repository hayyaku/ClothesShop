package com.clothesshop.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clothesshop.service.CategoryService;
import com.google.gson.Gson;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
@CrossOrigin
public class CategoryAPI {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/nav/api")
	public String showMenu() {
		Gson gson = new Gson();
		return gson.toJson(categoryService.getAllCategory());
	}
}
