package com.clothesshop.dto;

public class ProductDetailDto {
	private Long id;
	private Long product_id;
	private String size;
	private Long sizeId;
	private String color;
	private Long colorId;
	private Integer qty;
	
	
	
	public ProductDetailDto() {
		super();
	}

	public ProductDetailDto(Long id, Long product_id, String size, Long sizeId, String color, Long colorId,
			Integer qty) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.size = size;
		this.sizeId = sizeId;
		this.color = color;
		this.colorId = colorId;
		this.qty = qty;
	}

	public Long getSizeId() {
		return sizeId;
	}
	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}
	public Long getColorId() {
		return colorId;
	}
	public void setColorId(Long colorId) {
		this.colorId = colorId;
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	
}
