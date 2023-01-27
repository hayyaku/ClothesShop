package com.clothesshop.dao;

import com.clothesshop.entities.ProductDetail;

public interface ProductDetailDao {
	boolean save (ProductDetail productDetail);
	ProductDetail findProductDetailById(Long id);
	boolean updateProductDetail(ProductDetail productDetail);
	boolean deleteProductDetailById(Long id);
}
