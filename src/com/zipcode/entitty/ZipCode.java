package com.zipcode.entitty;

/**
 * @author Bhavik Gandhi
 *
 */
public class ZipCode {
	
	private String stringValue;
	private Integer value;
	public ZipCode(String stringValue, Integer value) {
		this.value = value;
		this.stringValue = stringValue;
	}
	/**
	 * @return String
	 */
	public Integer getValue() {
		return value;
	}
	/**
	 * @param value
	 */
	public void setValue(Integer value) {
		this.value = value;
	}
	
	
	public String getStringValue() {
		return stringValue;
	}
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	/**
	 * @return String
	 */
	@Override
	public String toString() {
		return "ZipCode [value=" + stringValue + "]";
	}

}
