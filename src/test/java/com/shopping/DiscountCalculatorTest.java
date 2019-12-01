package com.shopping;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopping.business.DiscountCalculator;
import static com.shopping.constant.DiscountEnum.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {DiscountCalculator.class})
public class DiscountCalculatorTest {
	
	@Autowired
	DiscountCalculator discountCalculator;

	@BeforeClass
	public static void setUp(){	
	}
		
	@Test
	public void getDiscountZeroPercentTest() {		
		assertTrue(discountCalculator.getDiscount((double) 4000,ZERO.getValue())==(double)0.0);
	}
	
	@Test
	public void getDiscountTenPercentTest() {		
		assertTrue(discountCalculator.getDiscount((double) 8000,TEN.getValue())==(double)800.0);
	}
	
	@Test
	public void getDiscountTwentyPercentTest() {		
		assertTrue(discountCalculator.getDiscount((double) 12000,TWENTY.getValue())==(double)2400.0);
	}

}
