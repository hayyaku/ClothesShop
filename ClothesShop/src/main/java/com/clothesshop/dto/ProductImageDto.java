package com.clothesshop.dto;

public class ProductImageDto {
	private Long id;
	private String path;
	private Long productId;
	
	
	public ProductImageDto() {
		super();
	}
	public ProductImageDto(Long id, String path, Long productId) {
		super();
		this.id = id;
		this.path = path;
		this.productId = productId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
}
