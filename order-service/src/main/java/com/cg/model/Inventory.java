package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="inventory")
public class Inventory {
	//private String id;
	@Id
	private String productCode;
	private int quantity;
	public Inventory() {}
	public Inventory(String productCode, int quantity) {
	
		
		this.productCode = productCode;
		this.quantity = quantity;
	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
//	@Override
//	public String toString() {
//		return "Inventory ["productCode=" + productCode + ", quantity=" + quantity + "]";
//	}

	
	
	
	

}
