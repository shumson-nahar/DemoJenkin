package automation;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonshoppingcartTest {
	private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up the WebDriver instance (e.g., ChromeDriver)
        driver = new ChromeDriver();
    }

    @Test
    public void testShoppingCart() {
        // Navigate to the Amazon shopping cart page
        driver.get("https://www.amazon.com/gp/cart/view.html");
        
        // Create an instance of the AmazonShoppingCartPage and pass the driver instance
        AmazonShoppingCartPage cartPage = new AmazonShoppingCartPage(driver);

        // Use the methods defined in the page class to interact with the shopping cart
        double totalPrice = cartPage.getTotalPrice();
        System.out.println("Total Price: $" + totalPrice);

        cartPage.updateQuantity(2);

        List<String> productTitles = cartPage.getProductTitles();
        System.out.println("Product Titles: " + productTitles);
    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver instance
        driver.quit();
    }
}


