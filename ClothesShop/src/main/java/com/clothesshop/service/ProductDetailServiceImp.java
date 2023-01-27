package com.clothesshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothesshop.dao.ColorDao;
import com.clothesshop.dao.ProductDAO;
import com.clothesshop.dao.ProductDetailDao;
import com.clothesshop.dao.SizeDao;
import com.clothesshop.dto.ProductDetailDto;
import com.clothesshop.entities.ProductDetail;

@Service
public class ProductDetailServiceImp implements ProductDetailService{
	
	@Autowired
	private ProductDetailDao productDetailDao;
	@Autowired
	private ColorDao colorDao;
	@Autowired
	private SizeDao sizeDao;
	@Autowired
	private ProductDAO productDAO;

	@Override
	public boolean updateProductDetail(ProductDetailDto productDetailDto) {
		ProductDetail productDetail = productDetailDao.findProductDetailById(productDetailDto.getId());
		productDetail.setColorId(colorDao.getById(productDetailDto.getColorId()));
		productDetail.setSizeId(sizeDao.getById(productDetailDto.getSizeId()));
		productDetail.setQty(productDetailDto.getQty());
		return productDetailDao.updateProductDetail(productDetail);
	}

	@Override
	public boolean deleteProductDetailById(Long id) {
		return productDetailDao.deleteProductDetailById(id);
	}

	@Override
	public ProductDetailDto save(ProductDetailDto productDetailDto) {
		ProductDetail productDetail = new ProductDetail();
		productDetail.setColorId(colorDao.getById(productDetailDto.getColorId()));
		productDetail.setSizeId(sizeDao.getById(productDetailDto.getSizeId()));
		productDetail.setProductId(productDAO.getById(productDetailDto.getProduct_id()));
		productDetail.setQty(productDetailDto.getQty());
		productDetailDao.save(productDetail);
		ProductDetailDto productDetailDto2 = new ProductDetailDto();
		productDetailDto2.setId(productDetail.getId());
		productDetailDto2.setQty(productDetail.getQty());
		productDetailDto2.setColor(productDetail.getColorId().getName());
		productDetailDto2.setColorId(productDetail.getColorId().getId());
		productDetailDto2.setSize(productDetail.getSizeId().getName());
		productDetailDto2.setSizeId(productDetail.getSizeId().getId());
		productDetailDto2.setProduct_id(productDetail.getProductId().getId());
		return productDetailDto2;
	}
	
}
