package com.cg.model;

import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="order")
public class Order {
//	private String id;
	@Id
	private String orderNo;
	//private List<OrderLineItems> orderLineItems;
	private String name;
	private BigDecimal price;
	private int quantity;
	
	public Order() {}

//	public Order(String skuCode, BigDecimal price, Integer quantity) {
//		this.skuCode = skuCode;
//		this.price = price;
//		this.quantity = quantity;
//	}
	
	public Order(String orderNo,String name, int quantity, BigDecimal price) {
		this.orderNo=orderNo;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

//	public String getId() {
//		return id;
//	}
//
//
//	public void setId(String id) {
//		this.id = id;
//	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

//	@Override
//	public String toString() {
//		return "Order [id=" + id + ", orderNo=" + orderNo + ", name=" + name + ", price=" + price + ", quantity="
//				+ quantity + "]";
//	}
	}
	
//	private List<OrderLineItems> getOrderLineItems() {
//		List<OrderLineItems> lineItems = new ArrayList()<OrderLineItems>(
//				new OrderLineItems();
//				);
//		
//		return lineItems;
//
//	}
	


