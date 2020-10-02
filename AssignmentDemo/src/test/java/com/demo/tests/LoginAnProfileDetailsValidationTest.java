package com.demo.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demo.dataprovider.DataProviderUtils;
import com.demo.utils.BaseTest;

public class LoginAnProfileDetailsValidationTest extends BaseTest{
	
	@BeforeTest
	public void setUp(){
		launchApplication();
	}
	
	@Test(dataProviderClass=DataProviderUtils.class,dataProvider="LoginAnProfileDetailsValidationTest",enabled=true,alwaysRun=true)
	public void loginAnProfileDetailsValidationTest(String userName,String	password,String	profileNme,String fullNme){
		//login into the application with respective user name and password
		getLoginPage().loginIntoApplication(userName,password);
		//Validating the FB Logo should be displayed on the Home Page
		boolean flagLogo=getFBHomePage().validateFBLogo();
		Assert.assertEquals(flagLogo, true,"fb logo is not present in the home page");
		//Validating the Covid17Information center link should be displayed on the Home Page
		boolean flagCovid19=getFBHomePage().validateCovid19InfoCenterLnk();
		Assert.assertEquals(flagCovid19, true,"Covid19InformationCenter Link is not present in the home page");
		//Validating Profile should be displayed on the home page
		String profileName = getFBHomePage().getProfileName(profileNme);
		Assert.assertEquals(profileName, profileNme,"profile name is not matching");
		
		//navigating to the welcome page while clicking on the welcome link
		getFBHomePage().clickOnWelcomeLnk();
		//Validating the Add Picture Button should displayed on the home page
		boolean flagAddPicture=getWelComePage().validateAddPictureBtn();
		Assert.assertEquals(flagAddPicture, true,"add picture button is not present in the home page");
		
		// Navigating to the profile details page while clicking on the profile name link
		getFBHomePage().clickOnProfileLnk(profileNme);
		// Validating the full name should be displayed on the profile details page
		String fullName=getProfilePage().getFullName();
		Assert.assertEquals(fullName,fullNme,"full name is not matching");
	}
	
	@AfterTest
	public void tearDown(){
		getDriver().quit();
	}
	

}
