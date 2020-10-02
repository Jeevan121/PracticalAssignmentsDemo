package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.utils.BasePage;

public class WelComePage extends BasePage{
	WebDriver driver;
	public WelComePage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	By addPictureBtn = new By.ByXPath("//div[@aria-label='Add Picture']");
	
	public boolean validateAddPictureBtn(){
		boolean flag = isElementPresent(addPictureBtn);
		return flag;
	}
	

}
