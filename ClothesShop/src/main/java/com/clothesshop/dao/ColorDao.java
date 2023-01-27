package com.clothesshop.dao;

import java.util.List;

import com.clothesshop.entities.Color;

public interface ColorDao {
	List<Color> getAllColor();
	Color getById(Long id);
	void save(Color color);
}
