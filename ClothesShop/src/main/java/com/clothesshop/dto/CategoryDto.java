package com.clothesshop.dto;

import java.util.List;

public class CategoryDto {
	private Long id;
	private String name;
	private Long parentId;
	
	private List<ProductDto> productDtos;
	
	
	

	public CategoryDto() {
		super();
	}

	public CategoryDto(Long id, String name, Long parentId, List<ProductDto> productDtos) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.productDtos = productDtos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public List<ProductDto> getProductDtos() {
		return productDtos;
	}

	public void setProductDtos(List<ProductDto> productDtos) {
		this.productDtos = productDtos;
	}
	

	

}
