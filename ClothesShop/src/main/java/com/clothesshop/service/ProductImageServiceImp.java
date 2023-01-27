package com.clothesshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothesshop.dao.ProductDAO;
import com.clothesshop.dao.ProductImageDao;
import com.clothesshop.dto.ProductImageDto;
import com.clothesshop.entities.Product;
import com.clothesshop.entities.ProductImage;

@Service
public class ProductImageServiceImp implements ProductImageService{

	@Autowired
	private ProductImageDao productImageDao;
	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<ProductImageDto> save(ProductImageDto[] pid) {
		//save image name to DB
		Product product = productDAO.getById(pid[0].getProductId());
		for (ProductImageDto element : pid) {
			ProductImage productImage = new ProductImage();
			productImage.setPath(element.getPath());
			productImage.setProductId(product);
			productImageDao.save(productImage);
		}
		//get all Image of product return to client
		List<ProductImage> productImages = productImageDao.findProductImageByProductId(product.getId());
		List<ProductImageDto> productImageDtos =new ArrayList<ProductImageDto>();
		for (ProductImage productImage : productImages) {
			ProductImageDto productImageDto = new ProductImageDto();
			productImageDto.setId(productImage.getId());
			productImageDto.setPath(productImage.getPath());
			productImageDto.setProductId(productImage.getProductId().getId());
			productImageDtos.add(productImageDto);
		}
		return productImageDtos;
	}

	@Override
	public boolean deleteImageById(Long id) {
		return productImageDao.deleteImageById(id);
	}
	
	@Override
	public boolean update(ProductImageDto productImageDto) {
		//save image name to DB
			ProductImage productImage = productImageDao.findProductImageById(productImageDto.getId());
			productImage.setPath(productImageDto.getPath());
		return productImageDao.update(productImage);
	}

	@Override
	public ProductImage findProductImageById(Long id) {
		return productImageDao.findProductImageById(id);
	}



}
