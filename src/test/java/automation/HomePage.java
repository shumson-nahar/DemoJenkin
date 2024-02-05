package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
private WebDriver driver;
    
    private By addToCartButton = By.xpath("//input[@id='add-to-cart-button']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }
}


