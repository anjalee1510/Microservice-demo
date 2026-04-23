package com.cg.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Inventory;
import com.cg.model.Order;
import com.cg.model.Product;
import com.cg.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void placeOrder(Order order) {
		
		
		order.setOrderNo((UUID.randomUUID().toString()));
		String productName=order.getName();
		//System.out.println(productName);
		// Calling product-service to receive product code and price with the help of product name  
		ResponseEntity<Product> product= restTemplate.getForEntity("http://product-service/api/product/view/"+productName,Product.class);
		Product pdt= product.getBody(); 
		BigDecimal PSprice=pdt.getPrice();
		//System.out.println(PSPrice+");
			
		String productCode= pdt.getProductCode();
//		
		ResponseEntity<Inventory> inventory= restTemplate.getForEntity("http://inventory-service/api/inventory/view/"+productCode,Inventory.class);
		Inventory inv=inventory.getBody();
		int invQty=inv.getQuantity();
		System.out.println(invQty);
//		
		if(invQty>=order.getQuantity()) {

			BigDecimal oSPrice=BigDecimal.valueOf(order.getQuantity()).multiply(PSprice);
			order.setPrice(oSPrice);
		Order order1=(new Order(order.getOrderNo(),order.getName(),order.getQuantity(),
				order.getPrice()));
		
		

		//	Updating Inventory after the order is placed
		Inventory updatedInv = new Inventory(productCode, invQty-order.getQuantity());
		restTemplate.put("http://inventory-service/api/inventory/update/"+ productCode, updatedInv,Inventory.class);
		orderRepository.save(order1);
//		return order1;

		}
		else {
			throw new ResourceNotFoundException("Sorry! Not enough items in stock");
//			return null;
		}
		}
	
	public List<Order> getAllOrders(){
		List<Order> lst=orderRepository.findAll();
		if(lst.isEmpty()) {
			throw new ResourceNotFoundException("Order list is empty");
		}
		return orderRepository.findAll();
	}
	
	public Order findByOrderNo(String orderNo) {
		Optional<Order> orderOpt=orderRepository.findById(orderNo);
		if(orderOpt.isPresent()) {
			return orderOpt.get();
		}
		else {
		throw new ResourceNotFoundException("Order by order id no. +"+orderNo+ "does not exist" );
	}}
	
	public void updateOrder(Order order) {
		orderRepository.save(order);
	}
	
	public void deleteOrder(String orderNo) {
		Optional<Order> ordOptional=orderRepository.findById(orderNo);
		if(ordOptional.isPresent()) {
		orderRepository.deleteById(orderNo);
	}
		else {
			throw new ResourceNotFoundException("Order by order id no. +"+orderNo+ "does not exist" );
		}
		
	
	}
}

