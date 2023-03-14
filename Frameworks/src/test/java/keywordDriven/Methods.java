package keywordDriven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Methods {
	
	static WebDriver driver;
	
	public static void openBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}
	
	public static void maximizeIt() {
		driver.manage().window().maximize();
	}
	
	public static void navigateTo(String url) {
		driver.get(url);
	}
	
	public static void enterInvalidUsername(String value, String param) {
		driver.findElement(By.id(value)).sendKeys(param);
	}
	
	public static void enterInvalidPassword(String value, String param) {
		driver.findElement(By.id(value)).sendKeys(param);
	}
	
	public static void clickLoginBtn(String locator, String value) {
		if(locator.equals("xpath")) {
			driver.findElement(By.xpath(value)).click();
		}
		
		else if(locator.equals("name")) {
			driver.findElement(By.name(value)).click();
		}
	}
	
	public static void verifyErrorMsg(String locator, String value, String param) {
		String expectedMessage = param;
		String actualMessage = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		

		if(locator.equals("xpath")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
			actualMessage = driver.findElement(By.xpath(value)).getText();
		}
		else if(locator.equals("id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
			actualMessage = driver.findElement(By.id(value)).getText();
		}		
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	
	
	public static void closeBrowser() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
