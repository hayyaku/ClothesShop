package com.clothesshop.filter;

import java.util.List;

import com.clothesshop.dto.ProductDto;

public class ProductFilter {
	private Long categoryId;
	private Integer curentPage;
	private int totalPage;

	private List<ProductDto> productDtos;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCurentPage() {
		return curentPage;
	}

	public void setCurentPage(Integer curentPage) {
		this.curentPage = curentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<ProductDto> getProductDtos() {
		return productDtos;
	}

	public void setProductDtos(List<ProductDto> productDtos) {
		this.productDtos = productDtos;
	}

	public ProductFilter(Long categoryId, Integer curentPage, int totalPage, List<ProductDto> productDtos) {
		super();
		this.categoryId = categoryId;
		this.curentPage = curentPage;
		this.totalPage = totalPage;
		this.productDtos = productDtos;
	}

	public ProductFilter() {
		super();
	}

}
