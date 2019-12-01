package com.shopping;

import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shopping.business.BillingAmountCalculator;
import com.shopping.business.DiscountContext;
import static com.shopping.constant.ShoppingEnum.*;
import com.shopping.discount.impl.Slab1DiscountCalculator;
import com.shopping.discount.impl.Slab2DiscountCalculator;
import com.shopping.discount.impl.Slab3DiscountCalculator;

@EnableAutoConfiguration
@SpringBootApplication
public class ShoppingApplication {
		
	private static final Logger logger = LoggerFactory.getLogger(ShoppingApplication.class);
	
	@Autowired
	DiscountContext discountContext;
	
	@Autowired
	Slab1DiscountCalculator slab1DiscountCalculator;
	
	@Autowired
	Slab2DiscountCalculator slab2DiscountCalculator;
	
	@Autowired
	Slab3DiscountCalculator slab3DiscountCalculator;
	
	@Autowired
	BillingAmountCalculator billingAmountCalculator;
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);		
	}
	
	@PostConstruct
	public void init()
	{
		Scanner sc=new Scanner(System.in);
		logger.info("Enter Purchase Amount");
		double amount=sc.nextDouble();
		
		if(amount<=FIVE_THOUSAND.getValue())
		{
			discountContext.setDiscountStrategy(slab1DiscountCalculator);			
		}
		else if(amount<=TEN_THOUSAND.getValue())
		{
			discountContext.setDiscountStrategy(slab2DiscountCalculator);
		}
		else
		{
			discountContext.setDiscountStrategy(slab3DiscountCalculator);
		}
		
		double discount=discountContext.calculateDiscount(amount);
		
		logger.info("Discount Amount-->"+discount);
		
		double billAmount=billingAmountCalculator.prepareBill(amount,discount);
		
		logger.info("Billed Amount-->"+billAmount);
	}

}
