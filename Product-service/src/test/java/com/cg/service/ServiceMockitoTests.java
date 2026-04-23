package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import com.cg.model.Product;
import com.cg.repository.ProductRepository;

@SpringBootTest(classes= {ServiceMockitoTests.class})
public class ServiceMockitoTests {
	
	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	ProductService productService;
	
	public List<Product> myProducts;
	
	
	 @Test
	@Order(1)
	public void  test_getProducts()
	{	List<Product> myProducts=new ArrayList<Product>();
		myProducts.add(new Product("Pen","Link","pen",BigDecimal.valueOf(100)));
		myProducts.add(new Product("Crayons","classmate","crayons",BigDecimal.valueOf(500)));
		
		when(productRepository.findAll()).thenReturn(myProducts);//Mocking
		productService.getAllProducts();
		
		assertEquals(2,productService.getAllProducts().size());
	}
	 
	
	@Test
	@Order(2)
	public void test_getProductByName() {
		List<Product> myProducts=new ArrayList<Product>();
		Product p1=new Product("Pen","Link","pen",BigDecimal.valueOf(100));
		Product p2=new Product("Crayons","classmate","crayons",BigDecimal.valueOf(500));
		myProducts.add(p1);
		myProducts.add(p2);
		String prodName="Pen";
		
		when(productRepository.findByName(prodName)).thenReturn((p1));
		assertEquals(prodName, productService.findByName(prodName).getName());
	}
	
	@Test
	@Order(3)
	public void test_CreateProduct() {
		Product p3=new Product("Spoon","utensil","spoon",BigDecimal.valueOf(199));
		
		productService.createProduct(p3);
		verify(productRepository,times(1)).save(p3);
	}
//	@Test
//	@Order(4)
//	public void test_UpdateProduct() {
//		List<Product> myProducts=new ArrayList<Product>();
//		Product p1=new Product("Spoon","utensil","spoon",BigDecimal.valueOf(199));
//		myProducts.add(p1);
//		Product p2=new Product("Spoon","utensil","spoon",BigDecimal.valueOf(99));
//		String prodName="Spoon";
//		when(productRepository.findByName(prodName)).thenReturn((p1));
//		productService.updateProduct(prodName,p2);
//		verify(productRepository,times(1)).save(p2);
//	}
////	

}
