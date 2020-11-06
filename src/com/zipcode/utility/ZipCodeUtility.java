/**
 * 
 */
package com.zipcode.utility;

import java.util.List;

import com.zipcode.entitty.ZipCodeRange;

/**
 * @author Bhavik Gandhi
 * 
 * Utility class for Zip Code and Zip Code Range
 */
public class ZipCodeUtility {

	/**
	 * 
	 * Utility method Checks if the given String contains valid Zip Code.
	 * 
	 * @param data
	 * @return
	 */
	public static boolean isValidZipCode(String data) {
		boolean isValid = false;
		if (data != null) {
			data = data.trim();
			// Invalid Zipcode Empty or not 5 digits or 00000
			if (!data.isBlank() && data.length() == 5 && !data.equalsIgnoreCase("00000")) {
				isValid = true;
			}
		}
		return isValid;
	}

	/**
	 * Prints a List of Zip Code Range
	 * @param zipCodeRangeList
	 */
	public static void printZipCodeRangeList(List<ZipCodeRange> zipCodeRangeList) {
		if (zipCodeRangeList != null && !zipCodeRangeList.isEmpty()) {
			zipCodeRangeList.forEach(i -> System.out.println(i.toString()));			
		} else {
			System.out.println("Zip Code Range List is Empty");			
		}
	}
	
}
