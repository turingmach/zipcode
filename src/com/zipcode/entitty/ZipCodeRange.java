package com.zipcode.entitty;

/**
 * @author Bhavik Gandhi
 *
 */
public class ZipCodeRange {

	private ZipCode lowerZipCode;
	private ZipCode upperZipCode;
	
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
	 * @return ZipCode
	 */
	public ZipCode getLowerZipCode() {
		return lowerZipCode;
	}

	/**
	 * @param lowerZipCode
	 */
	public void setLowerZipCode(ZipCode lowerZipCode) {
		this.lowerZipCode = lowerZipCode;
	}

	/**
	 * @return ZipCode
	 */
	public ZipCode getUpperZipCode() {
		return upperZipCode;
	}

	/**
	 * @param upperZipCode
	 */
	public void setUpperZipCode(ZipCode upperZipCode) {
		this.upperZipCode = upperZipCode;
	}

	/**
	 * @return String
	 */
	@Override
	public String toString() {
		return "ZipCodeRange [lowerZipCode=" + lowerZipCode.toString() + ", upperZipCode=" + upperZipCode.toString() + "]";
	}
	
	
}
