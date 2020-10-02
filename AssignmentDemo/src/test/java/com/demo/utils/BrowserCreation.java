package com.demo.utils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserCreation {
	
	private WebDriver driver;
	public WebDriver createBrowser1(){
		final String driverPath = System.getProperty("user.dir") +File.separator+"driver"+File.separator+"chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		final ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--disable-extensions");
        options.addArguments("test-type");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(AutomationConstants.applicationUrl);
        return driver;
       
	}
	
	public WebDriver createBrowser2(){
		WebDriverManager.chromedriver().setup();
		final ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--disable-extensions");
        options.addArguments("test-type");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get(AutomationConstants.applicationUrl);
        return driver;
	}
	
	public WebDriver createBrowser() {
	    try {
	      if (AutomationConstants.browserType.equalsIgnoreCase(AutomationConstants.firefox)) {
	    	  WebDriverManager.firefoxdriver().setup();
	    	  FirefoxProfile profile = new FirefoxProfile();
	    	  profile.setPreference("permissions.default.desktop-notification", 1);
	    	  DesiredCapabilities capabilities=DesiredCapabilities.firefox();
	    	  capabilities.setCapability(FirefoxDriver.PROFILE, profile);
	    	  capabilities.setCapability("marionette",true);
	    	  capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, false);
	          driver = new FirefoxDriver(capabilities);
	        
	      } else if (AutomationConstants.browserType.equalsIgnoreCase(AutomationConstants.chrome)) {
	    	  WebDriverManager.chromedriver().setup();
	  		  final ChromeOptions options = new ChromeOptions();
	          options.addArguments("--disable-web-security");
	          options.addArguments("--allow-running-insecure-content");
	          options.addArguments("--disable-extensions");
	          options.addArguments("test-type");
	          options.addArguments("--start-maximized");
	          Map prefs=new HashMap();
	          prefs.put("profile.default_content_setting_values.notifications", 1);
	          options.setExperimentalOption("prefs",prefs);
	          driver = new ChromeDriver(options);
	      } 
	    } catch (final Exception e) {
	      System.out.println(" Caught Exception in while launching browser" + e);
	    }
		    driver.manage().deleteAllCookies();
	        driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.get(AutomationConstants.applicationUrl);
		    return driver;
	  }

}
