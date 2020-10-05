package com.demo.utils;

public class AutomationConstants {
	
	public static String applicationUrl = PropertiesUtils.initEnvironmentProperties().getProperty("environmentUrl");
	public static String restApiEndPoint = PropertiesUtils.initEnvironmentProperties().getProperty("restApiEndPoint");
	
	public static String browserType = PropertiesUtils.initAutomatioProperties().getProperty("BrowserType");
	
	public static String firefox="firefox";
	public static String chrome="chrome";
	
	public static String apiEmpResource="employees";
	public static String apiEmpCreate="create";
	


}
