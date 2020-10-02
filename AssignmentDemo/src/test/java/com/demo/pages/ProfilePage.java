package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.utils.BasePage;

public class ProfilePage extends BasePage{
	
	WebDriver driver;
	public ProfilePage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	By fullName = new By.ByXPath("//h1[text()='Jeevantkumar Borale']");
	public String getFullName(){
		String data = getText(fullName);
		return data;
	}

}
