package automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonShoppingCartPage {
	 private WebDriver driver;

	    public AmazonShoppingCartPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Define the web elements on the shopping cart page using @FindBy annotations
	    @FindBy(css = "span.sc-product-price")
	    private List<WebElement> productPrices;

	    @FindBy(css = "input[name='quantity']")
	    private WebElement quantityInput;

	    @FindBy(css = "span.sc-product-title")
	    private List<WebElement> productTitles;

	    // Create methods to interact with the elements on the shopping cart page
	    public double getTotalPrice() {
	        double totalPrice = 0.0;
	        for (WebElement price : productPrices) {
	            totalPrice += Double.parseDouble(price.getText().replace("$", ""));
	        }
	        return totalPrice;
	    }

	    public void updateQuantity(int quantity) {
	        quantityInput.clear();
	        quantityInput.sendKeys(String.valueOf(quantity));
	        quantityInput.sendKeys(Keys.ENTER);
	    }

	    public List<String> getProductTitles() {
	        List<String> titles = new ArrayList<>();
	        for (WebElement title : productTitles) {
	            titles.add(title.getText());
	        }
	        return titles;
	    }
	}


