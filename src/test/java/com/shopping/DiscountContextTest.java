package com.shopping;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopping.business.DiscountCalculator;
import com.shopping.business.DiscountContext;
import com.shopping.discount.impl.Slab1DiscountCalculator;
import com.shopping.discount.impl.Slab2DiscountCalculator;
import com.shopping.discount.impl.Slab3DiscountCalculator;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {DiscountContext.class,DiscountCalculator.class,Slab1DiscountCalculator.class, Slab2DiscountCalculator.class,Slab3DiscountCalculator.class})
public class DiscountContextTest {
	
	@Autowired
	DiscountContext discountContext;
	
	@Autowired
	Slab1DiscountCalculator slab1DiscountCalculator;
	
	@Autowired
	Slab2DiscountCalculator slab2DiscountCalculator;
	
	@Autowired
	Slab3DiscountCalculator slab3DiscountCalculator;

	@BeforeClass
	public static void setUp(){	
	}
		
	@Test
	public void slab1CalculateDiscountTest() {
		discountContext.setDiscountStrategy(slab1DiscountCalculator);
		assertTrue(discountContext.calculateDiscount((double) 500)==(double)0.0);
	}
	
	@Test
	public void slab2CalculateDiscountTest() {
		discountContext.setDiscountStrategy(slab2DiscountCalculator);
		assertTrue(discountContext.calculateDiscount((double) 5500)==(double)550.0);
	}
	
	@Test
	public void slab3CalculateDiscountTest() {
		discountContext.setDiscountStrategy(slab3DiscountCalculator);
		assertTrue(discountContext.calculateDiscount((double) 20000)==(double)4000.0);
	}
	
	@AfterClass
	public static void tearDown(){	
	}
}
