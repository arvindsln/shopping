/**
 * @author arvind.varma
 *
 */
package com.shopping.discount.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.business.DiscountCalculator;
import com.shopping.constant.DiscountEnum;
import com.shopping.discount.DiscountStrategy;


@Component
public class Slab3DiscountCalculator implements DiscountStrategy{

	@Autowired
	DiscountCalculator discountCalculator;
	
	@Override
	public double calculateDiscount(Double purchaseAmount) {
		return	discountCalculator.getDiscount(purchaseAmount, DiscountEnum.TWENTY.getValue());
	}

}
