package com.comicrelief.apps.donation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.comicrelief.apps.donation.utils.WebUtil;

public class WorldPayPaymentPage {
	
	@FindBy(id="cardNumber")
	private WebElement cardNumberField;
	
	@FindBy(id="expiryMonth")
	private WebElement expiryMonthField;
	
	@FindBy(id="expiryYear")
	private WebElement expiryYearField;
	
	@FindBy(id="securityCode")
	private WebElement securityCodeField;
	
	@FindBy(css=".btn-make-payment")
	private WebElement makePaymentBtn;
	
	public void makePayment(WebDriver driver){
		
		WebUtil.wiatUntilIdElementVisibility(driver, "cardNumber");
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
