/**
 * 
 */
package com.shopping.business;

import org.springframework.stereotype.Component;

import com.shopping.discount.DiscountStrategy;

/**
 * @author arvind.varma
 *
 */
@Component
public class DiscountContext {
	DiscountStrategy discountStrategy;
	public void setDiscountStrategy(DiscountStrategy discountStrategy)
	{
		this.discountStrategy=discountStrategy;
	}
	
	public double calculateDiscount(double amount)
	{
		return discountStrategy.calculateDiscount(amount);
	}	

}
