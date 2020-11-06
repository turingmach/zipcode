/**
 * 
 */
package com.zipcode.unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.zipcode.entitty.ZipCode;

/**
 * @author Bhavik Gandhi
 * 
 * Unit test for Zip Code class
 */
class ZipCodeTest {

	/**
	 * Test method for {@link com.zipcode.entitty.ZipCode#getValue()}.
	 */
	@Test
	void testGetValue() {
		ZipCode zipcode = new ZipCode(10000);
		assertEquals(10000,zipcode.getValue());
	}

	/**
	 * Test method for {@link com.zipcode.entitty.ZipCode#setValue(java.lang.Integer)}.
	 */
	@Test
	void testSetValue() {
		ZipCode zipcode = new ZipCode(10000);
		zipcode.setValue(20000);
		assertEquals(20000,zipcode.getValue());
	}

	/**
	 * Test method for {@link com.zipcode.entitty.ZipCode#toString()}.
	 */
	@Test
	void testToString() {
		ZipCode zipcode = new ZipCode(10000);
		assertNotNull(zipcode.toString());
	}

}
