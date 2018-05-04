package com.comicrelief.apps.donation;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.comicrelief.apps.donation.pageobjects.HomePage;
import com.comicrelief.apps.donation.pageobjects.GiftAidPage;
import com.comicrelief.apps.donation.pageobjects.PersonalDetailPage;

public class VerifyErrorMessageTest extends BaseTest {
	
	private HomePage homePage;
	
	private String expectedAmountErrorMsg = "Please enter a number between 1 and 5000";
	private String expectedFirstNameErrorMsg = "Please fill in your first name";
	private String expectedLastNameErrorMsg = "Please fill in your last name";
	private String expectedEmailErrorMsg = "Please enter a valid e-mail address";
	
	@Test
	public void verifyErrorMsgDonateHomePage() {
		
		// Go to home page
		goToHomePage(driver);
		
		homePage = PageFactory.initElements(driver, HomePage.class);
		
		// Click donate button
		homePage.clickDonateButton(driver);
		
		String actualErrorMsg = homePage.getAmountFieldErrorMsg();
		
		Assert.assertEquals(actualErrorMsg, expectedAmountErrorMsg);
	}
	
	@Test
	public void verifyErrorMsgPersonalDetailPage() {
		
		// Go to home page
		goToHomePage(driver);
				
		homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.selectAmountToDonate(driver);
		
		homePage.clickDonateButton(driver);
		
		giftAidPage = PageFactory.initElements(driver, GiftAidPage.class); 
		
		giftAidPage.clickPayByCard(driver);
		
		personalDetailPage = PageFactory.initElements(driver, PersonalDetailPage.class);
		
		personalDetailPage.clickContinue(driver);
				
		Assert.assertEquals(personalDetailPage.getFirstNameErrorMsg(), expectedFirstNameErrorMsg);
						
		Assert.assertEquals(personalDetailPage.getLastNameErrorMsg(), expectedLastNameErrorMsg);
				
		Assert.assertEquals(personalDetailPage.getEmailErrorMsg(), expectedEmailErrorMsg);
				
		
	}

}
