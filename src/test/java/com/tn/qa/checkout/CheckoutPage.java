package com.tn.qa.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
	 private WebDriver driver;

	    @FindBy(id = "input-payment-firstname")
	    private WebElement firstNameInput;

	    @FindBy(id = "input-payment-lastname")
	    private WebElement lastNameInput;

	    @FindBy(id = "input-payment-email")
	    private WebElement emailInput;

	    @FindBy(id = "input-payment-telephone")
	    private WebElement telephoneInput;

	    @FindBy(id = "input-payment-address-1")
	    private WebElement addressInput;

	    @FindBy(id = "input-payment-city")
	    private WebElement cityInput;

	    @FindBy(id = "input-payment-postcode")
	    private WebElement postcodeInput;

	    @FindBy(id = "input-payment-country")
	    private WebElement countryInput;

	    @FindBy(id = "button-payment-address")
	    private WebElement continueButton;

	    @FindBy(id = "button-shipping-address")
	    private WebElement continueShippingButton;

	    @FindBy(name = "comment")
	    private WebElement commentInput;

	    @FindBy(id = "button-shipping-method")
	    private WebElement continueShippingMethodButton;

	    @FindBy(name = "agree")
	    private WebElement agreeCheckbox;

	    @FindBy(id = "button-payment-method")
	    private WebElement continuePaymentMethodButton;

	    @FindBy(id = "button-confirm")
	    private WebElement confirmOrderButton;

	    @FindBy(xpath = "//h1[contains(text(),'Your order has been placed!')]")
	    private WebElement orderSuccessMessage;

	    public CheckoutPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void enterBillingDetails(String firstName, String lastName, String email, String telephone,
	                                    String address, String city, String postcode, String country) {
	        firstNameInput.sendKeys(firstName);
	        lastNameInput.sendKeys(lastName);
	        emailInput.sendKeys(email);
	        telephoneInput.sendKeys(telephone);
	        addressInput.sendKeys(address);
	        cityInput.sendKeys(city);
	        postcodeInput.sendKeys(postcode);
	        Select countrySelect = new Select(countryInput);
	        countrySelect.selectByVisibleText(country);
	        continueButton.click();
	        continueShippingButton.click();
	        commentInput.sendKeys("This is a test order.");
	        continueShippingMethodButton.click();
	        agreeCheckbox.click();
	        continuePaymentMethodButton.click();
	    }

	    public void placeOrder() {
	        confirmOrderButton.click();
	    }

	    public boolean isOrderPlaced() {
	        return orderSuccessMessage.isDisplayed();
	    }
	}


