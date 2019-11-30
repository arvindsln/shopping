/**
 * 
 */
package com.shopping.constant;

/**
 * @author arvind.varma
 *
 */
public enum DiscountEnum {
	ZERO("0",0),
	TEN("10",10),
	TWENTY("20",20);

    private final String key;
    private final Integer value;

    DiscountEnum(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
}
}
