package com.tn.qa.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest {
	 private WebDriver driver;
	    private HomePage homePage;
	    private ProductPage productPage;
	    private CartPage cartPage;
	    private CheckoutPage checkoutPage;

	    @BeforeMethod
	    public void setUp() {
	        // Initialize WebDriver and open the browser
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://tutorialsninja.com/demo/");

	        // Initialize Page Objects
	        homePage = new HomePage(driver);
	        productPage = new ProductPage(driver);
	        cartPage = new CartPage(driver);
	        checkoutPage = new CheckoutPage(driver);
	    }

	    @Test
	    public void testCheckoutProcess() {
	        // Search for a product on the home page
	        homePage.searchProduct("iPhone");

	        // Click on the product and add it to the cart
	        productPage.clickOnProduct();
	        productPage.addToCart();

	        // Verify that the product is added to the cart
	        Assert.assertTrue(cartPage.isProductDisplayedInCart(), "Product is not added to the cart.");

	        // Proceed to checkout
	        cartPage.clickCheckoutButton();

	        // Fill in the checkout details
	        checkoutPage.enterBillingDetails("Shumson", "Nahar", "naharshumson@gmail.com", "2676001308", "123 Street",
	                "New York", "12345", "United States");

	        // Place the order
	        checkoutPage.placeOrder();

	        // Verify the order success message
	        Assert.assertTrue(checkoutPage.isOrderPlaced(), "Order is not placed successfully.");
	    }

	    @AfterMethod
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
	}


