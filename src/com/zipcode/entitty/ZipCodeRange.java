package com.zipcode.entitty;

/**
 * @author Bhavik Gandhi
 * 
 * Stores uppper and lower Zip Code limits to define a Zip Code range
 */
public class ZipCodeRange {

	/**
	 * Stores the lower limit of Zip Code Range
	 */
	private ZipCode lowerZipCode;
	/**
	 * Stores the upper limit of Zip Code Range
	 */
	private ZipCode upperZipCode;
	
	/**
	 * Initializes Zip Code Range object with lower and upper limit. 
	 * @param lowerZipCode
	 * @param upperZipCode
	 */
	public ZipCodeRange(ZipCode lowerZipCode, ZipCode upperZipCode) {
		super();
		if (lowerZipCode.getValue() < upperZipCode.getValue()) {
			this.lowerZipCode = lowerZipCode;
			this.upperZipCode = upperZipCode;
		} else {
			this.lowerZipCode = upperZipCode;
			this.upperZipCode = lowerZipCode;

		}
	}

	/**
	 * Getter method for lower limit of Zip Code Range
	 * @return ZipCode
	 */
	public ZipCode getLowerZipCode() {
		return lowerZipCode;
	}

	/**
	 * Setter method for lower limit of Zip Code Range
	 * @param lowerZipCode
	 */
	public void setLowerZipCode(ZipCode lowerZipCode) {
		this.lowerZipCode = lowerZipCode;
	}

	/**
	 * Getter method for upper limit of Zip Code Range
	 * @return ZipCode
	 */
	public ZipCode getUpperZipCode() {
		return upperZipCode;
	}

	/**
	 * Setter method for upper limit of Zip Code Range
	 * @param upperZipCode
	 */
	public void setUpperZipCode(ZipCode upperZipCode) {
		this.upperZipCode = upperZipCode;
	}

	/**
	 * Implements toString method to print Zip Code Range object
	 * @return String
	 */
	@Override
	public String toString() {
		return "ZipCodeRange [lowerZipCode=" + lowerZipCode.toString() + ", upperZipCode=" + upperZipCode.toString() + "]";
	}
	
	
}
