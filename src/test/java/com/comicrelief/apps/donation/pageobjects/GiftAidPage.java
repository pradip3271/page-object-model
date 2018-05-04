package com.comicrelief.apps.donation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GiftAidPage {
	
	@FindBy(css="#comicrelief_payinbundle_payment_giftaid")
	private WebElement giftAidChkBox;
	
	@FindBy(css="#comicrelief_payinbundle_payment_giftaid")
	private WebElement optEmail;
	
	@FindBy(css="#comicrelief_payinbundle_payment_permissionPost")
	private WebElement optPostal;
	
	@FindBy(css="#comicrelief_payinbundle_payment_card")
	private WebElement payByCardBtn;
	
	@FindBy(css=".xcomponent-component-frame")
	private WebElement payPalBtnIframe;
	
	private JavascriptExecutor executor;
	
	public void fillGiftAidAndMarketPrefernce(WebDriver driver) {
		
		executor = (JavascriptExecutor)driver;
		
		// Tick giftaid check box
		executor.executeScript("arguments[0].click();", giftAidChkBox);
		
		// Tick opt email
		executor.executeScript("arguments[0].click();", optEmail);
		
		// Tick not opt postal
		executor.executeScript("arguments[0].click();", optPostal);
		
	}
	
	// Click pay by card
	public void clickPayByCard(WebDriver driver) {
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", payByCardBtn);
				
	}
			
	public void completePayPalPayment(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		// Switch to the paypal button iframe
		String iFrameName = payPalBtnIframe.getAttribute("name");
		driver.switchTo().frame(iFrameName);
		WebElement payPalButton = driver.findElement(By.cssSelector(".paypal-button"));

		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", payPalButton);
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		// Switch to popup paypal window		
		for(String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
		driver.findElement(By.id("email")).sendKeys("paypal_sponsorship-buyer@comicrelief.com");
		driver.findElement(By.id("password")).sendKeys("frostuser");
		driver.findElement(By.id("btnLogin")).click(); 
		
	}

}


//public function iCompletePaypalSandboxPayment()
//{
//    $this->getSession()->wait(30000);
//    $page = $this->getSession()->getPage();
//
//    // Check if Choose a way to pay screen is present
//    $chooseAWayToPayPresent = null;
//    try {
//        $this->assertSession()->elementExists('css', '#loadLogin');
//        $chooseAWayToPayPresent = true;
//    } catch (\Behat\Mink\Exception\Exception $e) {
//        $chooseAWayToPayPresent = false;
//    }
//
//    // Check if Got a Paypal account screen is present with login button
//    $loginButtonPresent = null;
//    try {
//        $this->assertSession()->elementExists('css', '#loginSection .baslLoginButtonContainer >a');
//        $loginButtonPresent = true;
//    } catch (\Behat\Mink\Exception\Exception $e) {
//        $loginButtonPresent = false;
//    }
//
//    // Check if user is already logged in and delivery address is present
//    $PayNowButtonPresent = null;
//    try {
//        $this->assertSession()->elementExists('css', '#confirmButtonTop');
//        $PayNowButtonPresent = true;
//    } catch (\Behat\Mink\Exception\Exception $e) {
//        $PayNowButtonPresent = false;
//    }
//
//    // Direct login screen
//    $emailPasswordFieldsPresent = false;
//    try {
//        $this->assertSession()->elementExists('css', '#email');
//        $this->assertSession()->elementExists('css', '#password');
//        $emailPasswordFieldsPresent = true;
//    } catch (\Behat\Mink\Exception\Exception $e) {
//        // Continue
//    }
//
//    $email = 'paypal_sponsorship-buyer-2@comicrelief.com';
//    $password = 'frostuser';
//
//    // Progress with the payment depending on the variant
//    if ($chooseAWayToPayPresent) {
//        $page->find('css', '#loadLogin')->click();
//        $this->getSession()->wait(15000);
//        $page->find('css', '#login_email')->setValue($email);
//        $page->find('css', '#login_password')->setValue($password);
//        $page->find('css', '#submitLogin')->click();
//        $this->getSession()->wait(15000);
//        $page->find('css', '#continue_abovefold')->click();
//        $this->getSession()->wait(10000);
//    } elseif ($emailPasswordFieldsPresent) {
//#          $this->getSession()->switchToIFrame('injectedUl');
//        $page->find('css', '#email')->setValue($email);
//        $page->find('css', '#password')->setValue($password);
//        $page->find('css', '#btnLogin')->click();
//#           $this->getSession()->switchToIFrame();
//        $this->getSession()->wait(15000);
//        $page->find('css', '#confirmButtonTop')->click();
//        $this->getSession()->wait(10000);
//    } elseif ($loginButtonPresent) {
//        $page->find('css', '#loginSection .baslLoginButtonContainer a')->click();
//        $this->getSession()->wait(15000);
//        $this->getSession()->switchToIFrame('injectedUl');
//        $page->find('css', '#email')->setValue($email);
//        $page->find('css', '#password')->setValue($password);
//        $page->find('css', '#btnLogin')->click();
//        $this->getSession()->switchToIFrame();
//        $this->getSession()->wait(15000);
//        $page->find('css', '#confirmButtonTop')->click();
//        $this->getSession()->wait(10000);
//    } elseif ($PayNowButtonPresent) {
//        $page->find('css', '#confirmButtonTop')->click();
//        $this->getSession()->wait(10000);
//    } else {
//        echo 'A new variant page is shown for Paypal';
//    }
//}
//
