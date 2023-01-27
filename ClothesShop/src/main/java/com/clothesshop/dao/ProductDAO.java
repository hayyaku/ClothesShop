package com.clothesshop.dao;

import java.util.List;

import com.clothesshop.entities.Product;

public interface ProductDAO {
	Product getById (Long id);
	List<Product> getRandom12Item();
	List<Product> getProductByCategoryId(List<Long> ids, Integer beginProduct);
	int countProductByCategoryId(List<Long> ids);
	void save(Product product);
	boolean update(Product product);
	boolean deleteById(Long id);
}
