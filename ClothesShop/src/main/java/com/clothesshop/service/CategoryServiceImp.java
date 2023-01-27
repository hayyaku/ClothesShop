package com.clothesshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothesshop.dao.CategoryDao;
import com.clothesshop.dto.CategoryDto;
import com.clothesshop.entities.Category;

@Service
public class CategoryServiceImp implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = categoryDao.getAllCategory();
		List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();
		for (Category category : categories) {
			CategoryDto categoryDto = new CategoryDto();
			categoryDto.setId(category.getId());
			categoryDto.setName(category.getName());
			categoryDto.setParentId(category.getParentId());
			categoryDtos.add(categoryDto);
		}
		return categoryDtos;
	}
	
}
