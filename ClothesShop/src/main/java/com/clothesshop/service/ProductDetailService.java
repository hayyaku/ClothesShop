package com.clothesshop.service;

import com.clothesshop.dto.ProductDetailDto;

public interface ProductDetailService {
	ProductDetailDto save (ProductDetailDto productDetailDto);
	boolean updateProductDetail(ProductDetailDto productDetailDto);
	boolean deleteProductDetailById(Long id);
}
