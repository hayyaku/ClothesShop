package com.clothesshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothesshop.dao.SizeDao;
import com.clothesshop.dto.SizeDto;
import com.clothesshop.entities.Size;

@Service
public class SizeServiceImp implements SizeService {

	@Autowired
	private SizeDao sizeDao;

	@Override
	public List<SizeDto> getAllSizes() {
		List<Size> sizes = sizeDao.getAllSize();
		List<SizeDto> sizeDtos = new ArrayList<SizeDto>();
		for (Size size : sizes) {
			SizeDto sizeDto = new SizeDto();
			sizeDto.setId(size.getId());
			sizeDto.setName(size.getName());
			sizeDtos.add(sizeDto);
		}
		return sizeDtos;
	}

}
