package com.cg;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.intThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InventoryServiceApplicationTests {
	private Calculator calculator=new Calculator();

	@Test
	void contextLoads() {
		
	}
	
	
	void testSum() {
		int expectedReults=17;
		
		int actualResult=calculator.doSum(12, 3, 2);
		
		assertThat(actualResult).isEqualTo(expectedReults);
	}
	

}
