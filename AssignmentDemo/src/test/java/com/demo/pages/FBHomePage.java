package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.utils.BasePage;

public class FBHomePage extends BasePage{
	
	WebDriver driver;
	public FBHomePage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	By fbLogo = new By.ByXPath("//a[@aria-label='Facebook']");
	By fbTitle = new By.ByXPath("//span[text()='Welcome to Facebook, Jeevantkumar']");
	By covid19InfoCenterLnk = new By.ByXPath("//span[text()='COVID-19 Information Centre']");
	By welcomeLnk = new By.ByXPath("//span[text()='Welcome']");
	
	//Validate Facebook Logo from the Home Page
	public boolean validateFBLogo(){
		boolean flag = isElementPresent(fbLogo);
		return flag;
	}
	
	public String getProfileName(String data){
		By profileLnk = new By.ByXPath("//a[@aria-label='"+data+"']");
		String text = getAttributeValues(profileLnk, "aria-label");
		return text;
	}
	
	public FBHomePage clickOnProfileLnk(String data){
		By profileLnk = new By.ByXPath("//a[@aria-label='"+data+"']");
		safeClick(profileLnk);
		return this;
	}
	
	public boolean validateCovid19InfoCenterLnk(){
		boolean flag = isElementPresent(covid19InfoCenterLnk);
		return flag;
	}
	
	public FBHomePage clickOnWelcomeLnk(){
		safeClick(welcomeLnk);
		return this;
	}
	
	
	

}
