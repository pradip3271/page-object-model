package com.comicrelief.apps.donation.pageobjects;

import java.util.Locale;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.comicrelief.apps.donation.utils.WebUtil;
import com.github.javafaker.Faker;

public class PersonalDetailPage {
	
	@FindBy(css="#comicrelief_payinbundle_payment_firstName")
	private WebElement firstName;
	
	@FindBy(css="#comicrelief_payinbundle_payment_lastName")
	private WebElement lastName;
	
	@FindBy(css="#comicrelief_payinbundle_payment_email_first")
	private WebElement emailField;
	
	@FindBy(css="#comicrelief_payinbundle_payment_email_second")
	private WebElement confirmEmail;
	
	@FindBy(css="#comicrelief_payinbundle_payment_postcode")
	private WebElement postCode;
	
	@FindBy(css="#postcode_button")
	private WebElement postCodeButton;
	
	@FindBy(css="#comicrelief_payinbundle_payment_address1")
	private WebElement address1;
	
	@FindBy(css="#comicrelief_payinbundle_payment_address2")
	private WebElement address2;
	
	@FindBy(css="#comicrelief_payinbundle_payment_address3")
	private WebElement address3;
	
	@FindBy(css="#comicrelief_payinbundle_payment_town")
	private WebElement townCity;

	@FindBy(css="#comicrelief_payinbundle_payment_country")
	private WebElement country;
	
	@FindBy(css="#comicrelief_payinbundle_payment_submit")
	private WebElement continueButton;
	
	@FindBy(css="#first-name-error>span")
	private WebElement firstNameErrorElement;
	
	@FindBy(css="#last-name-error>span")
	private WebElement lastNameErrorElement;
	
	@FindBy(css="#email-first-error>span")
	private WebElement emailErrorElement;
	
	private JavascriptExecutor executor;
		
	public void fillPersonalDetailsAndClickContinue(WebDriver driver) {
		
		Faker faker = new Faker(Locale.UK);
		
		firstName.sendKeys(faker.name().firstName());
		lastName.sendKeys(faker.name().lastName());
		String email = faker.internet().emailAddress();
		emailField.sendKeys(email);
		confirmEmail.sendKeys(email);
		postCode.sendKeys(faker.address().zipCode());
		address1.sendKeys(faker.address().streetAddressNumber());
		address2.sendKeys(faker.address().streetName());
		address3.sendKeys(faker.address().secondaryAddress());
		townCity.sendKeys(faker.address().cityName());
		
		Select countryDropDown = new Select(country);
		countryDropDown.selectByVisibleText("United Kingdom");
		
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", continueButton);

	}

	public String getFirstNameErrorMsg() {
		
		return firstNameErrorElement.getText();
	}

	public String getLastNameErrorMsg() {
		
		return lastNameErrorElement.getText();
	}

	public String getEmailErrorMsg() {
		
		return emailErrorElement.getText();
	}

	public void clickContinue(WebDriver driver) {
		
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", continueButton);
		
	}

}
