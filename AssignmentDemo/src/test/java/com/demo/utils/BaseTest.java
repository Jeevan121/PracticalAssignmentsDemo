package com.demo.utils;
import org.openqa.selenium.WebDriver;

import com.demo.pages.FBHomePage;
import com.demo.pages.LoginPage;
import com.demo.pages.ProfilePage;
import com.demo.pages.WelComePage;


public class BaseTest {
	
	private WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	FBHomePage fbHomePage;
	WelComePage welComePage;
	ProfilePage profilePage;
	RestAssuredUtils restAssuredUtlis;
	JsonUtils jsonUtils;
	
	public void launchApplication(){
		driver=new BrowserCreation().createBrowser();
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public BasePage getBasePage() {
	    if (basePage == null) {
	      basePage = new BasePage(driver);
	    }
	    return basePage;
	}
	
	public LoginPage getLoginPage() {
	    if (loginPage == null) {
	    	loginPage = new LoginPage(driver);
	    }
	    return loginPage;
	}
	
	public FBHomePage getFBHomePage() {
	    if (fbHomePage == null) {
	    	fbHomePage = new FBHomePage(driver);
	    }
	    return fbHomePage;
	}
	
	public WelComePage getWelComePage() {
	    if (welComePage == null) {
	    	welComePage = new WelComePage(driver);
	    }
	    return welComePage;
	}
	
	public ProfilePage getProfilePage(){
		if(profilePage==null){
			profilePage = new ProfilePage(driver);
		}
		return profilePage;
	}
	
	public RestAssuredUtils getRestAssuredUtils(){
		if(restAssuredUtlis==null){
			restAssuredUtlis = new RestAssuredUtils();
		}
		return restAssuredUtlis;
	}
	
	public JsonUtils getJsonUtils(){
		if(jsonUtils==null){
			jsonUtils = new JsonUtils();
		}
		return jsonUtils;
	}
	
	
}
