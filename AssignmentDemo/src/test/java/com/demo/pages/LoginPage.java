package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.utils.BasePage;

public class LoginPage extends BasePage{
	WebDriver driver;
	public LoginPage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	By userNameTxt = new By.ById("email");
	By passwordTxt = new By.ById("pass");
	By loginBtn = new By.ByName("login");
	
	public FBHomePage loginIntoApplication(String usrName,String password){
		safeType(userNameTxt, usrName);
		safeType(passwordTxt, password);
		safeClick(loginBtn);
		return new FBHomePage(driver);
		
	}

}
