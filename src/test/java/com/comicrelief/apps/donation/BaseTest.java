package com.comicrelief.apps.donation;

import org.testng.annotations.AfterClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.comicrelief.apps.donation.pageobjects.GiftAidPage;
import com.comicrelief.apps.donation.pageobjects.HomePage;
import com.comicrelief.apps.donation.pageobjects.PersonalDetailPage;
import com.comicrelief.apps.donation.pageobjects.ThankYouPage;
import com.comicrelief.apps.donation.pageobjects.WorldPayPaymentPage;


public class BaseTest {

WebDriver driver;

	protected HomePage homePage;
	protected GiftAidPage giftAidPage;
	protected PersonalDetailPage personalDetailPage;
	protected WorldPayPaymentPage worldPayPaymentPage;
	protected ThankYouPage thankYouPage;
	public static String baseUrl = null;
	public static String userName = null;
	public static String accessKey = null;
		
	@BeforeSuite
	public void setUp() throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/java/files/env.properties");
		prop.load(fis);
		
		baseUrl = prop.getProperty("BASE_URL");
		
		userName = System.getenv("BROWSERSTACK_USERNAME");
		accessKey = System.getenv("BROWSERSTACK_ACCESSKEY");
		if(userName == null || accessKey == null) {
			userName = prop.getProperty("BROWSERSTACK_USERNAME");
			accessKey = prop.getProperty("BROWSERSTACK_ACCESSKEY");
		}
		
	}
	
	@BeforeClass
	@Parameters(value={"browser","browserVersion","os","osVersion"})
	public void setDriver(String browserName, String browserVersion, String osName, String osVersion) throws Exception {
		
		System.out.println("<<<<<<<<<< Capability : " + browserName + " " + browserVersion + " " + osName + " " + osVersion);
				
		// ******************* Parallel test run in Browser Stack ***********************
		
		// Parallel testing using TestNG involves creating test and xml file where we can specify the maximum number of parallel instances 
		// of the test can run and the parameters that need to pass to the test.
		
		
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("browser", browserName);
		capability.setCapability("browser_version", browserVersion);
		capability.setCapability("os", osName);	    
	    capability.setCapability("os_version", osVersion);
	    capability.setCapability("project", "P1");
	    capability.setCapability("build", "1.0");
	    driver = new RemoteWebDriver(
	      new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"),
	      capability);
		
	    driver.manage().window().maximize();
		
	}
	
	public void goToHomePage(WebDriver driver) {
		
		driver.get(baseUrl);	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
