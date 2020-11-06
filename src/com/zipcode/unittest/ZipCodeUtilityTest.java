/**
 * 
 */
package com.zipcode.unittest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zipcode.entitty.ZipCode;
import com.zipcode.entitty.ZipCodeRange;
import com.zipcode.range.model.ZipCodeRangeModel;
import com.zipcode.utility.ZipCodeUtility;

/**
 * @author Bhavik Gandhi
 * 
 * Unit test for Zip Code Utility class
 */
class ZipCodeUtilityTest {

//	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	 
	ZipCodeRangeModel zipCodeRangeModel = new ZipCodeRangeModel();
    ZipCodeRange zipCodeRange1 = new ZipCodeRange(new ZipCode(00001), new ZipCode(19999));
    ZipCodeRange zipCodeRange2 = new ZipCodeRange(new ZipCode(20000), new ZipCode(39999));
    ZipCodeRange zipCodeRange3 = new ZipCodeRange(new ZipCode(10000), new ZipCode(29999));
    List<ZipCodeRange> zipCodeRangeList = new ArrayList<ZipCodeRange>();
    
	@BeforeEach
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	/**
	 * Test method for {@link com.zipcode.utility.ZipCodeUtility#isValidZipCode(java.lang.String)}.
	 */
	@Test
	void testIsValidZipCode() {
		String nullString = null;
		assertFalse(ZipCodeUtility.isValidZipCode(nullString));

		String emptyString = "";
		assertFalse(ZipCodeUtility.isValidZipCode(emptyString));

		String zipCodeWithZeros = "00000";
		assertFalse(ZipCodeUtility.isValidZipCode(zipCodeWithZeros));

		String invalidZipCode = "974369348747397";
		assertFalse(ZipCodeUtility.isValidZipCode(invalidZipCode));

		String validZipCode = "10000";
		assertTrue(ZipCodeUtility.isValidZipCode(validZipCode));
	}

	/**
	 * Test method for {@link com.zipcode.utility.ZipCodeUtility#printZipCodeRangeList(java.util.List)}.
	 */
	@Test
	void testPrintZipCodeRangeList() {
		List<ZipCodeRange> zipCodeRangeList = new ArrayList<ZipCodeRange>();		
		ZipCodeUtility.printZipCodeRangeList(zipCodeRangeList);
		
	    Assert.assertEquals("Zip Code Range List is Empty", outputStreamCaptor.toString()
	    	      .trim());
	    
	    
	    zipCodeRangeList.add(zipCodeRange1);
	    zipCodeRangeList.add(zipCodeRange2);
	    zipCodeRangeList.add(zipCodeRange3);
	    zipCodeRangeList = zipCodeRangeModel.processZipCodeRangeList(zipCodeRangeList);
	    ZipCodeUtility.printZipCodeRangeList(zipCodeRangeList);

	    Assert.assertNotEquals("Zip Code Range List is Empty", outputStreamCaptor.toString()
	    	      .trim());
	}

}
