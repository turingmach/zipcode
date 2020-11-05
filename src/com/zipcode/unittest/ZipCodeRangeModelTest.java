/**
 * 
 */
package com.zipcode.unittest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.zipcode.entitty.ZipCode;
import com.zipcode.entitty.ZipCodeRange;
import com.zipcode.range.model.ZipCodeRangeModel;


/**
 * This is JUnit Test with a few tests for the methods in Model class
 * @author Bhavik Gandhi
 *
 */
class ZipCodeRangeModelTest {

	ZipCodeRangeModel zipCodeRangeModel = new ZipCodeRangeModel();
    ZipCodeRange zipCodeRange1 = new ZipCodeRange(new ZipCode("00000", 0), new ZipCode("19999", 19999));
    ZipCodeRange zipCodeRange2 = new ZipCodeRange(new ZipCode("20000", 20000), new ZipCode("39999", 39999));
    ZipCodeRange zipCodeRange3 = new ZipCodeRange(new ZipCode("10000", 10000), new ZipCode("29999", 29999));
    List<ZipCodeRange> zipCodeRangeList = new ArrayList<ZipCodeRange>();
	/**
	 * Test method for {@link com.zipcode.range.model.ZipCodeRangeModel#printZipCodeRangeList(java.util.List)}.
	 */
	@Test
	void testPrintZipCodeRangeList() {
	    zipCodeRangeList.add(zipCodeRange1);
	    zipCodeRangeList.add(zipCodeRange2);
	    zipCodeRangeList.add(zipCodeRange3);
	    zipCodeRangeList = zipCodeRangeModel.processZipCodeRangeList(zipCodeRangeList);
		zipCodeRangeModel.printZipCodeRangeList(zipCodeRangeList);
	}

	/**
	 * 
	 * 
	 * Test method for {@link com.zipcode.range.model.ZipCodeRangeModel#processZipCodeRangeList(java.util.List)}.
	 */
	@Test
	void testProcessZipCodeRangeList() {
		
		
		zipCodeRangeList.add(zipCodeRange1);
		List<ZipCodeRange> resultZipCodeRangeList = zipCodeRangeModel.processZipCodeRangeList(zipCodeRangeList);

		assertSame(1, resultZipCodeRangeList.size());

		zipCodeRangeList.add(zipCodeRange2);

		resultZipCodeRangeList = zipCodeRangeModel.processZipCodeRangeList(zipCodeRangeList);

		assertSame(2, resultZipCodeRangeList.size());

		zipCodeRangeList.add(zipCodeRange3);

		resultZipCodeRangeList = zipCodeRangeModel.processZipCodeRangeList(zipCodeRangeList);

		assertSame(1, resultZipCodeRangeList.size());
	     
	     
	}

}
