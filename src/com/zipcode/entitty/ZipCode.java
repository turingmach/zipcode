package com.zipcode.entitty;

/**
 * @author Bhavik Gandhi
 * 
 * Defines ZipCode object
 */
public class ZipCode {
	
	private Integer value;
	public ZipCode(Integer value) {
		this.value = value;
	}
	/**
	 * Getter method Zip Code value
	 * @return String
	 */
	public Integer getValue() {
		return value;
	}
	/**
	 * Setter method Zip Code value
	 * @param value
	 */
	public void setValue(Integer value) {
		this.value = value;
	}
	
	
	/**
	 * Implements toString method to print Zip Code object
	 * @return String
	 */
	@Override
	public String toString() {
		return "ZipCode [value=" + value + "]";
	}

}
