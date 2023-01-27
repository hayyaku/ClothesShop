package com.clothesshop.service;

import java.util.List;

import com.clothesshop.dto.ProductDto;
import com.clothesshop.filter.ProductFilter;

public interface ProductService {
	List<ProductDto> getRandom12Item();
	ProductDto getProductById(Long id);
	ProductDto save(ProductDto productDto);
	ProductFilter filterProductByCategory (ProductFilter pr);
	boolean update(ProductDto productDto);
	boolean deleteById(Long id);
}


