package com.shopping;

import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shopping.business.BillingAmountCalculator;
import com.shopping.business.DiscountContext;
import com.shopping.discount.impl.Slab1DiscountCalculator;
import com.shopping.discount.impl.Slab2DiscountCalculator;
import com.shopping.discount.impl.Slab3DiscountCalculator;

@EnableAutoConfiguration
@SpringBootApplication
public class ShoppingApplication {
		
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
		System.out.println("Enter Purchase Amount");
		double amount=sc.nextDouble();
		
		if(amount<=5000)
		{
			discountContext.setDiscountStrategy(slab1DiscountCalculator);			
		}
		else if(amount>5000 && amount<=10000)
		{
			discountContext.setDiscountStrategy(slab2DiscountCalculator);
		}
		else
		{
			discountContext.setDiscountStrategy(slab3DiscountCalculator);
		}
		
		double discount=discountContext.calculateDiscount(amount);
		
		System.out.println("discount Amount-->"+discount);
		
		double billAmount=billingAmountCalculator.prepareBill(amount,discount);
		
		System.out.println("Billed Amount-->"+billAmount);
	}

}
