package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AddToCartTest {
	public WebDriver driver;

	@Test
	public void verifyAddtocart() {
		
		 // Set up the WebDriver (assuming ChromeDriver is used)
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		driver = new FirefoxDriver();
		
				driver.manage().window().maximize();

        // Instantiate the homepage
        HomePage homePage = new HomePage(driver);
        
        // Open the Amazon.com homepage
        driver.get("https://www.amazon.com");

        // Perform actions on the page
        homePage.clickAddToCart();
        
        // Close the browser
        driver.quit();
    }


	}


