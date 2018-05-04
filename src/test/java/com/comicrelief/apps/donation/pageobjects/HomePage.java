package com.comicrelief.apps.donation.pageobjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(css="[data-amount='30'].select-amount-btn")
	private WebElement amount30;
	
	@FindBy(css="#comicrelief_payinbundle_payment_amount_submit")
	private WebElement donateBtn;
	
	@FindBy(css="div#amount-error")
	private WebElement amountErrorElement;
		
	public void selectAmountToDonate(WebDriver driver) {
		
		amount30.click();
		
	}

	public void clickDonateButton(WebDriver driver) {
		
		donateBtn.click();
		
	}

	public String getAmountFieldErrorMsg() {
	
		return amountErrorElement.getText();
	}


}
