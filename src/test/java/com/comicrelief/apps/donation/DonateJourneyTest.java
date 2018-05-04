package com.comicrelief.apps.donation;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comicrelief.apps.donation.pageobjects.HomePage;
import com.comicrelief.apps.donation.pageobjects.GiftAidPage;
import com.comicrelief.apps.donation.pageobjects.PersonalDetailPage;
import com.comicrelief.apps.donation.pageobjects.ThankYouPage;
import com.comicrelief.apps.donation.pageobjects.WorldPayPaymentPage;

public class DonateJourneyTest extends BaseTest{
	
	@Test
	public void donateJourneyWorldPay() {
		
		// Go to home page
		goToHomePage(driver);
		
		// Initialize the home page
		homePage = PageFactory.initElements(driver, HomePage.class);
		
		// Select amount to donate
		homePage.selectAmountToDonate(driver);
		
		// Click donate button
		homePage.clickDonateButton(driver);
		
		// Initialize the GiftAid page
		giftAidPage = PageFactory.initElements(driver, GiftAidPage.class); 
		
		// fill giftaid and market prefernece
		giftAidPage.fillGiftAidAndMarketPrefernce(driver);
			
		// Click pay by card option
		giftAidPage.clickPayByCard(driver);
		
		// Initialize the personal detail page
		personalDetailPage = PageFactory.initElements(driver, PersonalDetailPage.class);
		
		// fill personal details and click continue button
		personalDetailPage.fillPersonalDetailsAndClickContinue(driver);	
		
		// Initialize the World pay payment page
		worldPayPaymentPage = PageFactory.initElements(driver, WorldPayPaymentPage.class);
		
		// make payment with world pay
		worldPayPaymentPage.makePayment();
		
		// Verify thank you page
		thankYouPage = PageFactory.initElements(driver, ThankYouPage.class);
		
		thankYouPage.getThankYouMsg();
		
		
	}
	
	@Test
	public void donateJourneyPayPal() {
	
		// Go to home page
		goToHomePage(driver);
				
		// Initialize the home page
		homePage = PageFactory.initElements(driver, HomePage.class);
		
		// Select amount to donate
		homePage.selectAmountToDonate(driver);
		
		// Click donate button
		homePage.clickDonateButton(driver);
		
		// Initialize the GiftAid page
		giftAidPage = PageFactory.initElements(driver, GiftAidPage.class);
				
//		giftAidPage.completePayPalPayment(driver);
		
	}
		

}
