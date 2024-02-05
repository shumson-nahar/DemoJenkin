package practice_tutorialninja;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Practice_Register {
	public WebDriver driver;
	public ChromeOptions options;

	@BeforeMethod
	public void openBrowser() {
	options = new ChromeOptions();
	options.setPageLoadStrategy(PageLoadStrategy.EAGER);
	options.addArguments("--start-maximized");
	options.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(options);
	driver.get("url");
	}//This is parameterization TestNG thats why not indivitual run
	@Test(priority=1)
	@Parameters({"Browser","url","email","password"})
	public void verifyRegisteringAnAccountWithMandatoryFields( String Browser, String url ,
			String email, String password) throws InterruptedException {
		
	
		driver.findElement(By.id("input-firstname")).sendKeys(("selenium "));
		Thread.sleep(3000);
		driver.findElement(By.id("input-lastname")).sendKeys(("panda"));
		Thread.sleep(3000);
		driver.findElement(By.id("input-email")).sendKeys(email);
		Thread.sleep(3000);
		driver.findElement(By.id("input-telephone")).sendKeys(("2676001308"));
		Thread.sleep(3000);
		driver.findElement(By.id("input-password")).sendKeys((password));
		Thread.sleep(3000);
		driver.findElement(By.id("input-confirm")).sendKeys((password));
		
		driver.findElement(By.name("agree")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.cssSelector("input.btn.primary")).click();
}

	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
}
