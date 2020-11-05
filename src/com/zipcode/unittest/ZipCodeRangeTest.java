/**
 * 
 */
package com.zipcode.unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.zipcode.entitty.ZipCode;
import com.zipcode.entitty.ZipCodeRange;

/**
 * @author Bhavik Gandhi
 *
 */
class ZipCodeRangeTest {

	/**
	 * Test method for {@link com.zipcode.entitty.ZipCodeRange#getLowerZipCode()}.
	 */
	@Test
	void testGetLowerZipCode() {
		ZipCode lowerZipCode = new ZipCode("10000",10000);
		ZipCode upperZipCode = new ZipCode("20000",20000);
		ZipCodeRange zipCodeRange = new ZipCodeRange(lowerZipCode, upperZipCode);
		assertEquals(lowerZipCode, zipCodeRange.getLowerZipCode());
	}

	/**
	 * Test method for {@link com.zipcode.entitty.ZipCodeRange#setLowerZipCode(com.zipcode.entitty.ZipCode)}.
	 */
	@Test
	void testSetLowerZipCode() {
		ZipCode lowerZipCode = new ZipCode("10000",10000);
		ZipCode upperZipCode = new ZipCode("20000",20000);
		ZipCode newLowerZipCode = new ZipCode("10500",10500);
		ZipCodeRange zipCodeRange = new ZipCodeRange(lowerZipCode, upperZipCode);
		zipCodeRange.setLowerZipCode(newLowerZipCode);
		assertEquals(newLowerZipCode, zipCodeRange.getLowerZipCode());
	}

	/**
	 * Test method for {@link com.zipcode.entitty.ZipCodeRange#getUpperZipCode()}.
	 */
	@Test
	void testGetUpperZipCode() {
		ZipCode lowerZipCode = new ZipCode("10000",10000);
		ZipCode upperZipCode = new ZipCode("20000",20000);
		ZipCodeRange zipCodeRange = new ZipCodeRange(lowerZipCode, upperZipCode);
		assertEquals(upperZipCode, zipCodeRange.getUpperZipCode());
	}

	/**
	 * Test method for {@link com.zipcode.entitty.ZipCodeRange#setUpperZipCode(com.zipcode.entitty.ZipCode)}.
	 */
	@Test
	void testSetUpperZipCode() {
		ZipCode lowerZipCode = new ZipCode("10000",10000);
		ZipCode upperZipCode = new ZipCode("20000",20000);
		ZipCode newUpperZipCode = new ZipCode("20500",20500);
		ZipCodeRange zipCodeRange = new ZipCodeRange(lowerZipCode, upperZipCode);
		zipCodeRange.setLowerZipCode(newUpperZipCode);
		assertEquals(newUpperZipCode, zipCodeRange.getUpperZipCode());
	}

	/**
	 * Test method for {@link com.zipcode.entitty.ZipCodeRange#toString()}.
	 */
	@Test
	void testToString() {
		ZipCode lowerZipCode = new ZipCode("10000",10000);
		ZipCode upperZipCode = new ZipCode("20000",20000);
		ZipCodeRange zipCodeRange = new ZipCodeRange(lowerZipCode, upperZipCode);
		assertNotNull(zipCodeRange.toString());
	}

}
