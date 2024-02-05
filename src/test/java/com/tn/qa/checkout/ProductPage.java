package com.tn.qa.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	 private WebDriver driver;

	    @FindBy(css = ".product-layout .product-thumb")
	    private WebElement product;

	    @FindBy(xpath = "//button[@id='button-cart']")
	    private WebElement addToCartButton;

	    public ProductPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void clickOnProduct() {
	        product.click();
	    }

	    public void addToCart() {
	        addToCartButton.click();
	    }
	}


