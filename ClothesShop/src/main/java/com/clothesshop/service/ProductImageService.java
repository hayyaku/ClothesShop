package com.clothesshop.service;

import java.util.List;

import com.clothesshop.dto.ProductImageDto;
import com.clothesshop.entities.ProductImage;

public interface ProductImageService {
	ProductImage findProductImageById (Long id);
	List<ProductImageDto> save(ProductImageDto[] productImageDto);
	boolean deleteImageById(Long id);
	boolean update(ProductImageDto productImageDto);
}
