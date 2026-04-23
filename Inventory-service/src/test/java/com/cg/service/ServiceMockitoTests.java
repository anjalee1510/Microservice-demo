package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.model.Inventory;
import com.cg.repository.InventoryRepository;

@SpringBootTest(classes= {ServiceMockitoTests.class})
public class ServiceMockitoTests {
	
	@Mock
	InventoryRepository inventoryRepository;
	
	@InjectMocks
	InventoryService inventoryService;
	
	
	public List<Inventory> myInventories;
	
	
	@Test
	@Order(1)
	public void  test_getAllInventories()
	{	List<Inventory> myInventories=new ArrayList<Inventory>();
		myInventories.add(new Inventory("pen",10));
		myInventories.add(new Inventory("crayons",15));
		
		when(inventoryRepository.findAll()).thenReturn(myInventories);//Mocking
		inventoryService.getInventories();
		
		assertEquals(2,inventoryService.getInventories().size());
	}
	
	@Test
	@Order(2)
	public void test_getProductByCode() {
		List<Inventory> myInventories=new ArrayList<Inventory>();
		Inventory i1=new Inventory("pen",10);
		Inventory i2=new Inventory("crayons",15);
		myInventories.add(i1);
		myInventories.add(i2);
		String invCode="pen";
		
		when(inventoryRepository.findById(invCode)).thenReturn(Optional.ofNullable(i1));
		assertEquals(invCode, inventoryService.findByCode(invCode).getProductCode());
	}
	
	@Test
	@Order(3)
	public void test_AddInventory() {
		Inventory inventory=new Inventory("spoon",20);
		
		inventoryService.addInventory(inventory);
		verify(inventoryRepository,times(1)).save(inventory);
	}
	@Test
	@Order(4)
	public void test_UpdateInventory() {
		List<Inventory> myInventories=new ArrayList<Inventory>();
		Inventory i1=new Inventory("spoon",10);
		myInventories.add(i1);
		Inventory inventory=new Inventory("spoon",20);
		String code="spoon";
		when(inventoryRepository.findById(code)).thenReturn(Optional.ofNullable(i1));
		inventoryService.updateInventory(code,inventory);
		verify(inventoryRepository,times(1)).save(inventory);
	}
	
	@Test
	@Order(5)
	public void test_deleteInventory() {
		List<Inventory> myInventories=new ArrayList<Inventory>();
		Inventory i1=new Inventory("pen",10);
		myInventories.add(i1);
//		Inventory inventory=new Inventory("spoon",20);
		String code="pen";
		when(inventoryRepository.findById(code)).thenReturn(Optional.ofNullable(i1));
		inventoryService.deleteInventory(code);
		verify(inventoryRepository,times(1)).deleteById(code);
	}

}
