package com.zipcode.data.inputreader;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import com.zipcode.entitty.ZipCode;
import com.zipcode.entitty.ZipCodeRange;
import com.zipcode.utility.ZipCodeUtility;

/**
 * @author Bhavik Gandhi
 * 
 * Reader class to read Zip Code data inputs from text files
 */
public class ZipCodeInputReader {
	
	
	/**
	 * File not Found String Constant
	 */
	private static final String FILE_NOT_FOUND_MSG = "File not Found.";

	/**
	 * Incorrect Zip Code Exception Constant
	 */
	private static final String INCORRECT_ZIPCODE_EXCEPTION = "Incorrect Zipcode";

	/**
	 * Text Resource Folder
	 */
	private static final String TEXT_RESOURCES_FOLDER = "TextResources";
	
	/**
	 * Invalid Zip Code Range Input Text File
	 */
	private static final String INVALID_ZIP_CODE_RANGE_TXT_FILENAME = TEXT_RESOURCES_FOLDER +"/ZipCodeRange.txt";
	
	/**
	 * Zip Code Check List File
	 */
	private static final String ZIP_CODE_CHECK_LIST_TXT_FILENAME = TEXT_RESOURCES_FOLDER +"/ZipCodeCheckList.txt";
	/**
	 * Scanner object to read data from input files
	 */
	Scanner myReader;
	
	/** Reads List Zip Code Ranges from an External Text File with a Zip Code Range per line 
	 * and with an lower and upper limit separated by space, comma or tab.
	 * @return List<ZipCodeRange>
	 */
	public List<ZipCodeRange> readZipCodeRangeList() {
		List<ZipCodeRange> zipCodeRangeList = new ArrayList<ZipCodeRange>();
		try {
	      File myObj = new File(INVALID_ZIP_CODE_RANGE_TXT_FILENAME);
	      myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	    	String[] zipCodeArray = new String[2];
	    	zipCodeArray = data.split("[\s\t,]");
	    	
	        if (ZipCodeUtility.isValidZipCode(zipCodeArray[0]) && ZipCodeUtility.isValidZipCode(zipCodeArray[1])) {
    	    	ZipCode zipcode1 = new ZipCode(Integer.parseInt(zipCodeArray[0]));
				ZipCode zipCode2 = new ZipCode(Integer.parseInt(zipCodeArray[1]));
				ZipCodeRange zipCodeRange = new ZipCodeRange(zipcode1, zipCode2);
				zipCodeRangeList.add(zipCodeRange);
        	} else {
        		throw new Exception(INCORRECT_ZIPCODE_EXCEPTION);
        	}
	      }
	    } catch (FileNotFoundException e) {
	      System.out.println(FILE_NOT_FOUND_MSG);
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
	      File myObj = new File(ZIP_CODE_CHECK_LIST_TXT_FILENAME);
	      myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
        	if (ZipCodeUtility.isValidZipCode(data)) {
		    	zipCodeList.add(new ZipCode(Integer.parseInt(data)));
        	} else {
        		throw new Exception(INCORRECT_ZIPCODE_EXCEPTION);
        	}
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println(FILE_NOT_FOUND_MSG);
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
