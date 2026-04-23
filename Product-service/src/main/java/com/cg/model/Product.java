package com.cg.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="product")
public class Product {
	@Id
	private String id;
	private String name;
	private String description;
	private String productCode;
	private BigDecimal price;
	
	public Product() {}
	
	public Product(String name, String description,String productCode, BigDecimal price) {
		this.name = name;
		this.description = description;
		this.productCode=productCode;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", productCode=" + productCode
				+ ", price=" + price + "]";
	}

	
	
	

}
