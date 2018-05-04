package com.comicrelief.apps.donation;

import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

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
	
	@BeforeClass
	public void setDriver() {
		
		String browserName = System.getenv("browser");
		
		String baseDir = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", baseDir + "/src/test/java/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		
//		if(browserName != null && browserName.equalsIgnoreCase("chrome")) {
//			
//			System.setProperty("webdriver.chrome.driver", baseDir + "/src/test/java/drivers/chromedriver");
//			driver = new ChromeDriver();
//			
//		} else {
//			System.setProperty("webdriver.gecko.driver", baseDir + "/src/test/java/drivers/geckodriver");
//			driver = new FirefoxDriver();			
//		}
		
	}
	
	public void goToHomePage(WebDriver driver) {
		
		driver.get("https://donation-systest.apps.comicrelief.com/");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
