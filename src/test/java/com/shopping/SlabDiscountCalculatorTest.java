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
import com.shopping.discount.impl.Slab1DiscountCalculator;
import com.shopping.discount.impl.Slab2DiscountCalculator;
import com.shopping.discount.impl.Slab3DiscountCalculator;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {DiscountCalculator.class,Slab1DiscountCalculator.class, Slab2DiscountCalculator.class,Slab3DiscountCalculator.class})
public class SlabDiscountCalculatorTest {
	
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
		assertTrue(slab1DiscountCalculator.calculateDiscount((double) 2000)==(double)0.0);
	}
	
	@Test
	public void slab2CalculateDiscountTest() {
		assertTrue(slab2DiscountCalculator.calculateDiscount((double) 8000)==(double)800.0);
	}
	
	@Test
	public void slab3CalculateDiscountTest() {
		assertTrue(slab3DiscountCalculator.calculateDiscount((double) 15000)==(double)3000.0);
	}
	
	@AfterClass
	public static void tearDown(){	
	}
}
