package com.tn.qa.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	private WebDriver driver;

    @FindBy(xpath = "//div[@id='content']//a[contains(@href,'checkout')]")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public boolean isProductDisplayedInCart() {
        return driver.getPageSource().contains("iPhone");
    }
}



