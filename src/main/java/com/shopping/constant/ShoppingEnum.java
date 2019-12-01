/**
 * 
 */
package com.shopping.constant;

/**
 * @author arvind.varma
 *
 */
public enum ShoppingEnum {
	FIVE_THOUSAND("5000",5000),
	TEN_THOUSAND("10000",10000);
	

    private final String key;
    private final Integer value;

    ShoppingEnum(String key, Integer value) {
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
