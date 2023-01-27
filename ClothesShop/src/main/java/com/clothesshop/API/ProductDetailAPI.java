package com.clothesshop.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clothesshop.dto.ProductDetailDto;
import com.clothesshop.service.ProductDetailService;
import com.google.gson.Gson;
@RestController
@RequestMapping(value = "/admin/product-detail",produces = "application/json;charset=UTF-8")
public class ProductDetailAPI {
	
	@Autowired
	private ProductDetailService productDetailService;
	
	@PostMapping(value = "/api")
	@CrossOrigin(origins = "*",allowedHeaders = "*",methods = RequestMethod.POST)
	public String insertProductDetail(@RequestBody String data) {
		Gson gson = new Gson();
		ProductDetailDto productDetailDto = gson.fromJson(data, ProductDetailDto.class);
		return gson.toJson(productDetailService.save(productDetailDto));
	}
	
	@PutMapping(value = "/api")
	@CrossOrigin(origins = "*",allowedHeaders = "*",methods = RequestMethod.PUT)
	public String updateProductDetail(@RequestBody String data) {
		Gson gson = new Gson();
		ProductDetailDto productDetailDto = gson.fromJson(data, ProductDetailDto.class);
		if(productDetailService.updateProductDetail(productDetailDto)) {
			return "ok";
		}
		return null;
	}
	
	@DeleteMapping(value = "/api")
	@CrossOrigin(origins = "*",allowedHeaders = "*",methods = RequestMethod.DELETE)
	public String daleteProductDetail(@RequestBody String data) {
		Long id = Long.parseLong(data);
		if(productDetailService.deleteProductDetailById(id)) {
			return "ok";
		}
		return null;
	}
	
}
