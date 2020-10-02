package com.demo.dataprovider;

import java.io.File;

import org.testng.annotations.DataProvider;

import com.demo.utils.ExcelUtils;



public class DataProviderUtils {
	
	@DataProvider(name = "LoginAnProfileDetailsValidationTest")
	  public static Object[][] loginAnProfileDetailsValidationTest() {
	    final Object[][] objReturn = ExcelUtils.getTableArray(
	        System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"Automation_Test_Input_Data.xls", "Demo", "LoginAnProfileDetailsValidationTest");
	    return objReturn;
	  }
	
	@DataProvider(name = "RestAPIDemoTest")
	  public static Object[][] restAPIDemoTest() {
	    final Object[][] objReturn = ExcelUtils.getTableArray(
	        System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"Automation_Test_Input_Data.xls", "Demo", "RestAPIDemoTest");
	    return objReturn;
	  }
	
	@DataProvider(name = "PostRestAPIDemo")
	  public static Object[][] postRestAPIDemo() {
	    final Object[][] objReturn = ExcelUtils.getTableArray(
	        System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"Automation_Test_Input_Data.xls", "Demo", "PostRestAPIDemo");
	    return objReturn;
	  }
	
	
}
