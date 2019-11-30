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
public class BillingAmountCalculator {
	public double prepareBill(double purchaseAmount,double discountAmount)
	{
		return purchaseAmount-discountAmount;
	}
}
