package com.clothesshop.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clothesshop.service.SizeService;
import com.google.gson.Gson;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
@CrossOrigin
public class SizeAPI {
	@Autowired
	private SizeService sizeService;

	@GetMapping(value = "/size/api")
	public String showAllColor() {
		Gson gson = new Gson();
		return gson.toJson(sizeService.getAllSizes());
	}
}
