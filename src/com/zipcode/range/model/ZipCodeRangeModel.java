package com.zipcode.range.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.zipcode.data.inputreader.ZipCodeInputReader;
import com.zipcode.entitty.ZipCode;
import com.zipcode.entitty.ZipCodeRange;

public class ZipCodeRangeModel {
	
	private List<ZipCodeRange> invalidZpCodeRangeList;
	ZipCodeInputReader zir =  new ZipCodeInputReader();

	public List<ZipCodeRange> getZipCodeRangeList() {
		if (invalidZpCodeRangeList == null) {
			invalidZpCodeRangeList = zir.readZipCodeRangeList();
		}
		return invalidZpCodeRangeList;
	}
	
	private void setZipCodeRangeList(List<ZipCodeRange> invalidZpCodeRangeList) {
		this.invalidZpCodeRangeList = invalidZpCodeRangeList;
	}

	public void printZipCodeRangeList(List<ZipCodeRange> invalidZpCodeRangeList) {
		invalidZpCodeRangeList.forEach(i -> System.out.println(i.toString()));
	}
	
	/**
	 * Takes a list of Zip Code Ranges and returns minimum set of Zip Code Ranges covering all the invalid ZipCodes.
	 * @param inputList
	 * @return
	 */
	public List<ZipCodeRange> processZipCodeRangeList(List<ZipCodeRange> inputList) {
		List<ZipCodeRange> tempList = new ArrayList<ZipCodeRange>();		
		ListIterator<ZipCodeRange> inputListIter = inputList.listIterator();
		while(inputListIter.hasNext()){
			ZipCodeRange inputZipCodeRange = inputListIter.next();
			if (tempList.isEmpty()) {
				tempList.add(inputZipCodeRange);
			} else {
				ListIterator<ZipCodeRange> tempListIter = tempList.listIterator();
				boolean addtoTempList = true;				
				while(tempListIter.hasNext()){
					ZipCodeRange tempZipCodeRange = tempListIter.next();					
					Integer inputListLowerLimit = inputZipCodeRange.getLowerZipCode().getValue();
					Integer inputListUpperLimit = inputZipCodeRange.getUpperZipCode().getValue();
					Integer tempListLowerLimit = tempZipCodeRange.getLowerZipCode().getValue();
					Integer tempListUpperLimit = tempZipCodeRange.getUpperZipCode().getValue();
					
					// When first range lies within another range ignore it
					if (inputListLowerLimit >= tempListLowerLimit 
							&& inputListUpperLimit <= tempListUpperLimit) {
						addtoTempList = false;
					//When two ranges are mutually exclusive include both
					} else if (inputListLowerLimit > tempListUpperLimit
							|| inputListUpperLimit < tempListLowerLimit) {
						addtoTempList = true;
					//When the existing range is smaller than the new Range 
					// remove the existing range and add the new range
					} else if (tempListLowerLimit > inputListLowerLimit 
							&& tempListUpperLimit < inputListUpperLimit) {
						tempListIter.remove();
						addtoTempList = true;
					// When upper limit of the new range is larger than the existing range update the upper limit of existing range
					} else if (tempListLowerLimit > inputListLowerLimit 
							&& tempListUpperLimit > inputListUpperLimit) {
						inputZipCodeRange.setUpperZipCode(tempZipCodeRange.getUpperZipCode());
						tempListIter.remove();
						addtoTempList = true;
					// When lower limit of the new range is lower than the existing range update the lower limit of existing range
					} else if (tempListLowerLimit < inputListLowerLimit 
							&& tempListUpperLimit < inputListUpperLimit) {
						inputZipCodeRange.setLowerZipCode(tempZipCodeRange.getLowerZipCode());
						tempListIter.remove();
						addtoTempList = true;
					}					
				}
				if (addtoTempList) {
					tempList.add(inputZipCodeRange);
				}
			}
		}
		return tempList;
	}
	
	/**
	 * Takes a list of invalid Zip Code Ranges and list of Zipcodes and returns valid zipcodes which do not lie within the given ZipCode Ranges
	 * @param invalidZpCodeRangeList
	 * @param zipCodeCheckList
	 * @return
	 */
	public List<ZipCode> getValidZipCodes(List<ZipCodeRange> invalidZipCodeRangeList, List<ZipCode> zipCodeCheckList) {
		List<ZipCode> validZipCodes = new ArrayList<ZipCode>();	
		boolean validZipCode = true;
		for (ZipCode zipCode :zipCodeCheckList) {
			for (ZipCodeRange zipCodeRange : invalidZipCodeRangeList) {
				if (zipCodeRange.getLowerZipCode().getValue() <= zipCode.getValue() 
						&& zipCodeRange.getUpperZipCode().getValue() >= zipCode.getValue()) {
					validZipCode = false;
					break;
				}
			}
			if (validZipCode) {
				validZipCodes.add(zipCode);
			}
			validZipCode = true;			
		}
		return validZipCodes;
	}

	public static void main(String[] args) {
		ZipCodeRangeModel zipCodeRangeModel = new ZipCodeRangeModel();
		zipCodeRangeModel.setZipCodeRangeList(zipCodeRangeModel.processZipCodeRangeList(zipCodeRangeModel.getZipCodeRangeList()));
		zipCodeRangeModel.printZipCodeRangeList(zipCodeRangeModel.getZipCodeRangeList());
		

		// Takes input from text file to check valid Zip Code given invalid Zip Code Ranges
//		ZipCodeInputReader zir =  new ZipCodeInputReader();
//		List<ZipCode> zipCodeCheckList = zir.readZipCodeCheckList();
//		List<ZipCode> validZipCodeList = zipCodeRangeModel.getValidZipCodes(zipCodeRangeModel.getZipCodeRangeList(), zipCodeCheckList);
//		validZipCodeList.forEach(z -> System.out.println(z.getValue()));
	}
	
}
