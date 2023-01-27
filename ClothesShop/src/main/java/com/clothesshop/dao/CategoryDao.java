package com.clothesshop.dao;

import java.util.List;

import com.clothesshop.entities.Category;

public interface CategoryDao {
	
	List<Category> getAllCategory();
	Category getById(Long id);
}
