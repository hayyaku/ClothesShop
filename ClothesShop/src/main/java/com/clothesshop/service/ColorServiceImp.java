package com.clothesshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothesshop.dao.ColorDao;
import com.clothesshop.dto.ColorDto;
import com.clothesshop.entities.Color;

@Service
public class ColorServiceImp implements ColorService {

	@Autowired
	private ColorDao colorDao;
	
	@Override
	public List<ColorDto> getAllColor() {
		List<Color> colors = colorDao.getAllColor();
		List<ColorDto> colorDtos = new ArrayList<ColorDto>();
		for (Color color : colors) {
			ColorDto colorDto = new ColorDto();
			colorDto.setId(color.getId());
			colorDto.setName(color.getName());
			colorDtos.add(colorDto);
		}
		return colorDtos;
	}


}
