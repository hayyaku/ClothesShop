package com.clothesshop.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clothesshop.dto.ProductDto;
import com.clothesshop.filter.ProductFilter;
import com.clothesshop.service.ProductService;
import com.google.gson.Gson;
@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class ProductAPI {

	@Autowired
	private ProductService productService;

	
	@GetMapping(path = "/home-item/api")
	@CrossOrigin(origins = "*",allowedHeaders = "*",methods = RequestMethod.GET)
	public String getRandomProduct() {
		Gson gson = new Gson();
		String jsonData = gson.toJson(productService.getRandom12Item());
		return jsonData;
	}
	
	@GetMapping(path = {"/product-detail/{id}/api","/admin/update-product/{id}/api"})
	@CrossOrigin(origins = "*",allowedHeaders = "*",methods = RequestMethod.GET)
	public String getProductById(@PathVariable("id") Long id) {
		Gson gson = new Gson();
		String jsonData = gson.toJson(productService.getProductById(id));
		return jsonData;
	}
	
	@PostMapping(path = "/filter-product/api")
	@CrossOrigin(origins = "*",allowedHeaders = "*",methods = RequestMethod.POST)
	public String filterProduct(@RequestBody String data) {
		Gson gson = new Gson();
		ProductFilter filter = gson.fromJson(data, ProductFilter.class);
		return gson.toJson(productService.filterProductByCategory(filter));
	}
	
	@PostMapping(path = "/admin/upload-product/api")
	@CrossOrigin(origins = "*",allowedHeaders = "*",methods = RequestMethod.POST)
	public String insertProduct(@RequestBody String data) {
		Gson gson = new Gson();
		ProductDto productDto = gson.fromJson(data, ProductDto.class);
		return gson.toJson(productService.save(productDto));
	}

	@PutMapping(path = "/admin/upload-product/api")
	@CrossOrigin(origins = "*",allowedHeaders = "*",methods = RequestMethod.PUT)
	public String updateProduct(@RequestBody String data) {
		Gson gson = new Gson();
		ProductDto productDto = gson.fromJson(data, ProductDto.class);
		if(productService.update(productDto)) {			
			return "ok";
		}
		return null;
	}
	
	@DeleteMapping(value = "/admin/upload-product/api")
	@CrossOrigin(origins = "*",allowedHeaders = "*",methods = RequestMethod.DELETE)
	public String daleteProductDetail(@RequestBody String data) {
		Long id = Long.parseLong(data);
		if(productService.deleteById(id)) {
			return "ok";
		}
		return null;
	}
}	

