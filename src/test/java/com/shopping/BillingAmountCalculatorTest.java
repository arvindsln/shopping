package com.shopping;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopping.business.BillingAmountCalculator;
import com.shopping.business.DiscountCalculator;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {BillingAmountCalculator.class})
public class BillingAmountCalculatorTest {
	
	@Autowired
	BillingAmountCalculator billingAmountCalculator;

	@BeforeClass
	public static void setUp(){	
	}
		
	@Test
	public void discountCalTest() {		
		assertTrue(billingAmountCalculator.prepareBill((double) 6000,600)==(double)5400.0);
	}
}
