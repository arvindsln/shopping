/**
 * 
 */
package com.shopping.discount.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.business.DiscountCalculator;
import com.shopping.constant.DiscountEnum;
import com.shopping.discount.DiscountStrategy;

/**
 * @author arvind.varma
 *
 */
@Component
public class Slab1DiscountCalculator implements DiscountStrategy{

	@Autowired
	DiscountCalculator discountCalculator;
	
	@Override
	public double calculateDiscount(Double purchaseAmount) {
		return	discountCalculator.getDiscount(purchaseAmount, DiscountEnum.ZERO.getValue());
	}

}
