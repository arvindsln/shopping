/**
 * 
 */
package com.shopping.business;

import org.springframework.stereotype.Component;

/**
 * @author arvind.varma
 *
 */
@Component
public class DiscountCalculator {

	double percent=.01;
	public double getDiscount(Double amount,int discPercentage)
	{
		double discount=amount*(discPercentage*percent);
		return discount;
	}
}
