package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.model.Inventory;
import com.cg.model.Order;
import com.cg.model.Product;
import com.cg.repository.OrderRepository;

@SpringBootTest(classes= ServiceTestClass.class)
public class ServiceTestClass {
	
	@Mock
	OrderRepository orderRepository;
	
	@InjectMocks
	OrderService orderService;
	
	public List<Order> myOrders;
	public List<Product> myProducts;
	public List<Inventory> mInventories;
	
	
	 @Test

	public void  test_getAllOrders()
	{	List<Order> myOrders=new ArrayList<Order>();
		myOrders.add(new Order("101","Pen",10,BigDecimal.valueOf(100)));
		myOrders.add(new Order("102","Crayons",5,BigDecimal.valueOf(500)));
		
		when(orderRepository.findAll()).thenReturn(myOrders);//Mocking
		orderService.getAllOrders();
		
		assertEquals(2,orderService.getAllOrders().size());
	}
	 
	 @Test
	 public void test_findByOrderNo() {
			List<Order> myOrders=new ArrayList<Order>();
			Order o1=new Order("101","Pen",10,BigDecimal.valueOf(100));
			Order o2=new Order("102","Crayons",5,BigDecimal.valueOf(500));
			myOrders.add(o1);
			myOrders.add(o2);
			String ordNo="101";
			
			when(orderRepository.findById(ordNo)).thenReturn(Optional.ofNullable(o1));
			assertEquals(ordNo, orderService.findByOrderNo(ordNo).getOrderNo());
		}
	 
	 @Test
	 public void test_UpdateOrder() {
		 Order ord=new Order("103","Spoon",5,BigDecimal.valueOf(50));
		 orderService.updateOrder(ord);
		 verify(orderRepository,times(1)).save(ord);
		}
	
	 @Test
	 public void test_deleteOrder() {
			List<Order> myOrders=new ArrayList<Order>();
			Order o1=new Order("101","Pen",10,BigDecimal.valueOf(100));
			myOrders.add(o1);
//			Inventory inventory=new Inventory("spoon",20);
			String ordNo="101";
			when(orderRepository.findById(ordNo)).thenReturn(Optional.ofNullable(o1));
			orderService.deleteOrder(ordNo);
			verify(orderRepository,times(1)).deleteById(ordNo);
		}
	 
}
