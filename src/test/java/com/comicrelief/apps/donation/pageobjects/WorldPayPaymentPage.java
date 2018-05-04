package com.comicrelief.apps.donation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorldPayPaymentPage {
	
	@FindBy(css="#cardNumber")
	private WebElement cardNumberField;
	
	@FindBy(css="#expiryMonth")
	private WebElement expiryMonthField;
	
	@FindBy(css="#expiryYear")
	private WebElement expiryYearField;
	
	@FindBy(css="#securityCode")
	private WebElement securityCodeField;
	
	@FindBy(css=".btn-make-payment")
	private WebElement makePaymentBtn;
	
	public void makePayment(){

		cardNumberField.sendKeys("4444333322221111");
		expiryMonthField.sendKeys("10");
		expiryYearField.sendKeys("2023");
		securityCodeField.sendKeys("234");
		makePaymentBtn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
