package com.shopping;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.shopping.business.DiscountCalculator;

@SpringBootTest
class ShoppingApplicationTests {
	
	DiscountCalculator discountCalculator;

	@Test
	void contextLoads() {
	}
	
	@Test
	void discountCalTest() {
		
		discountCalculator.getDiscount((double) 4000, 0);
	}
	

}
