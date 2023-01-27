package com.clothesshop.dao;

import java.util.List;

import com.clothesshop.entities.Size;

public interface SizeDao {
	List<Size> getAllSize();
	Size getById(Long id);
}
