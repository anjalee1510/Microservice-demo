package com.cg.controller;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Order;
import com.cg.repository.OrderRepository;
import com.cg.service.OrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderRepository orderRepository;
	
	@PostMapping
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
//		call Inventory service and place order if product is in stock
		orderService.placeOrder(order);
		return new ResponseEntity<>(order,HttpStatus.OK);
//		
//		Order ord=orderService.placeOrder(order);
//		Optional<Order> ord1= Optional.ofNullable(orderService.placeOrder(order));
//		if(ord1.isPresent()) {
//			orderRepository.save(ord1.get());
//			return new ResponseEntity<>("Order placed successfully. your order no is : "+order.getOrderNo(),HttpStatus.OK);
//		}
//		return new ResponseEntity<>("Sorry!not enough items in stock",HttpStatus.OK);
		}
	@GetMapping
	public ResponseEntity<Object> getAllOrders(){
		return new ResponseEntity<>(orderService.getAllOrders(),HttpStatus.OK);
	}
	
	@GetMapping("/{orderNo}")
	public ResponseEntity<Object> findByOrderNo(@PathVariable("orderNo") String orderNo) {
		return new ResponseEntity<>(orderService.findByOrderNo(orderNo),HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateOrder(@RequestBody Order order) {
		orderService.updateOrder(order);
		return new ResponseEntity<>("Order updated successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{orderNo}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("orderNo") String orderNo){
		orderService.deleteOrder(orderNo);
		return new ResponseEntity<>("Order is deleted successfully",HttpStatus.OK);
	}

}
