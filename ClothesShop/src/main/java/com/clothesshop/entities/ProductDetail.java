package com.clothesshop.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_detail")
public class ProductDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer qty;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="product_id" ,referencedColumnName = "id")
	private Product productId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="size_id" ,referencedColumnName = "id")
	private Size sizeId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="color_id" ,referencedColumnName = "id")
	private Color colorId;

	
	
	public ProductDetail() {
		super();
	}

	public ProductDetail(Integer qty, Product productId, Size sizeId, Color colorId) {
		super();
		this.qty = qty;
		this.productId = productId;
		this.sizeId = sizeId;
		this.colorId = colorId;
	}

	public Long getId() {
		return id;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Size getSizeId() {
		return sizeId;
	}

	public void setSizeId(Size sizeId) {
		this.sizeId = sizeId;
	}

	public Color getColorId() {
		return colorId;
	}

	public void setColorId(Color colorId) {
		this.colorId = colorId;
	}
	
	
	
	
}
