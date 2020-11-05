package com.zipcode.data.inputreader;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import com.zipcode.entitty.ZipCode;
import com.zipcode.entitty.ZipCodeRange;

public class ZipCodeInputReader {
	
	Scanner myReader;
	
	
	/** Reads List Zip Code Ranges from an External Text File with a Zip Code Range per line 
	 * and with an lower and upper limit separated by space, comma or tab.
	 * @return List<ZipCodeRange>
	 */
	public List<ZipCodeRange> readZipCodeRangeList() {
		List<ZipCodeRange> zipCodeRangeList = new ArrayList<ZipCodeRange>();
		try {
	      File myObj = new File("TextResources/ZipCodeRange.txt");
	      myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	    	String[] zipCodeArray = new String[2];
	    	zipCodeArray = data.split("[\s\t,]");
	    	
	        if (zipCodeArray[0] != null && zipCodeArray[1] != null) {
	        	zipCodeArray[0] = zipCodeArray[0].trim();
	        	if (zipCodeArray[0].length() == 5 && zipCodeArray[1].length() == 5) {
	    	    	ZipCode zipcode1 = new ZipCode(zipCodeArray[0], Integer.parseInt(zipCodeArray[0]));
					ZipCode zipCode2 = new ZipCode(zipCodeArray[1], Integer.parseInt(zipCodeArray[1]));
					ZipCodeRange zipCodeRange = new ZipCodeRange(zipcode1, zipCode2);
					zipCodeRangeList.add(zipCodeRange);
	        	} else {
	        		throw new Exception("Incorrect Zipcodes");
	        	}
	        }
	      }
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    } catch (Exception e) {
		      System.out.println(e.getMessage());
		      e.printStackTrace();
	    } finally {
	    	if (myReader != null) {
			      myReader.close();	    	
	    	}
	    }
		return zipCodeRangeList;
	}

	/** Reads a list of Zip Code input to be checked against the Invalid Zip Code Ranges 
	 * @return List<ZipCode>
	 */
	public List<ZipCode> readZipCodeCheckList() {
		List<ZipCode> zipCodeList = new ArrayList<ZipCode>();
		try {
	      File myObj = new File("TextResources/ZipCodeCheckList.txt");
	      myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        if (data != null) {
	        	data = data.trim();
	        	if (data.length() == 5) {
			    	zipCodeList.add(new ZipCode(data, Integer.parseInt(data)));
	        	} else {
	        		throw new Exception("Incorrect Zipcode");
	        	}
	        }
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    } catch (Exception e) {
		      System.out.println(e.getMessage());
		      e.printStackTrace();
	    } finally {
	    	if (myReader != null) {
			      myReader.close();	    	
	    	}
		}
		return zipCodeList;
	}

}
