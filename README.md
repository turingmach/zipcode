# Sample Java Project

This is a reference for setting up the Java Project to determine Invalid Zip Code Ranges. 


## Problem
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

## Dependencies

Java SE 8 or highe 
JUnit 4 or higher

## Usage

The Java project can be executed as Java Application.
Main method is available in ZipCodeRangeModel.java
Use text file ZipCodeRange.txt to provide Invalid Zip Code Ranges
Use text file ZipCodeCheckList.txt to provide list of Zip Code to be checked for validity against the given range.
Unit tests are available in the package com.zipcode.unittest. Unit test for ZipCodeInputReader class can be implemented using Mockito

