package com.clothesshop.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(name="old_price")
	private Double oldPrice;
	@Column(name="new_price")
	private Double newPrice;
	private Integer qty;
	private String description;
	
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="category_id", referencedColumnName = "id")
	private Category categoryId;
	
	@OneToMany(mappedBy = "productId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch (value = FetchMode.SUBSELECT)
	private List<ProductDetail> productDetails = new ArrayList<ProductDetail>();
	
	
	@OneToMany(mappedBy = "productId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch (value = FetchMode.SUBSELECT)
	private List<ProductImage> productImages = new ArrayList<ProductImage>();
	
	
	
	public Product() {
		super();
	}

	

	public Product( String name, Double oldPrice, Double newPrice, Integer qty, String description,
			Category categoryId, List<ProductDetail> productDetails, List<ProductImage> productImages) {
		super();
		this.name = name;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
		this.qty = qty;
		this.description = description;
		this.categoryId = categoryId;
		this.productDetails = productDetails;
		this.productImages = productImages;
	}



	public List<ProductImage> getProductImages() {
		return productImages;
	}



	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}



	public Long getId() {
		return id;
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

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public List<ProductDetail> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}


}
	
	

	
	
	
	

