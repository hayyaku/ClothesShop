package com.clothesshop.dao;

import java.util.List;

import com.clothesshop.entities.ProductImage;

public interface ProductImageDao {
	ProductImage findProductImageById (Long id);
	void save(ProductImage productImage);
	boolean update(ProductImage productImage);
	List<ProductImage> findProductImageByProductId(Long id);
	boolean deleteImageById(Long id);
	
}
