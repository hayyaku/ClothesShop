package com.clothesshop.dto;

import java.util.List;

public class ProductDto {

	private Long id;
	private String category;
	private Long categoryId;
	private String name;
	private Double oldPrice;
	private Double newPrice;
	private Integer qty;
	private String description;
	
	private List<ProductDetailDto> productDetailDtos;
	
	private List<ProductImageDto> productImageDtos ;
	
	public ProductDto() {
		super();
	}
	
	public ProductDto(Long id, String category, Long categoryId, String name, Double oldPrice, Double newPrice,
			Integer qty, String description, List<ProductDetailDto> productDetailDtos,
			List<ProductImageDto> productImageDtos) {
		super();
		this.id = id;
		this.category = category;
		this.categoryId = categoryId;
		this.name = name;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
		this.qty = qty;
		this.description = description;
		this.productDetailDtos = productDetailDtos;
		this.productImageDtos = productImageDtos;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public List<ProductImageDto> getProductImageDtos() {
		return productImageDtos;
	}
	public void setProductImageDtos(List<ProductImageDto> productImageDtos) {
		this.productImageDtos = productImageDtos;
	}
	public List<ProductDetailDto> getProductDetailDtos() {
		return productDetailDtos;
	}
	public void setProductDetailDtos(List<ProductDetailDto> productDetailDtos) {
		this.productDetailDtos = productDetailDtos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}
	public Double getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
