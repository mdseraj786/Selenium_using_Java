package SeleniumProject1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L0_Locator {
	public static void main(String[] args) throws InterruptedException {
//		launch chrome driver
		String driverName = "webdriver.chrome.driver";
		String driverPath = "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(driverName, driverPath);

		WebDriver driver = new ChromeDriver();

//		locatorBasic(driver);

//		cssLocator(driver);

//		

	}
	public static void locatorBasic(WebDriver driver) throws InterruptedException {
		// open sauce demo web page
		driver.get("http:\\www.saucedemo.com");

		// locate user name by id
		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		// locate password by name
		driver.findElement(By.name("password")).sendKeys("secret_sauce");

		// locate login button by className
		driver.findElement(By.className("submit-button")).click();

		// switch to product page
		String currentWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(currentWindowHandle);

		// locate Sauce Labs Bike Light
//				driver.findElement(By.linkText("Sauce Labs Bike Light")).click(); // link click
		// by.linkText required a complete link text
//				driver.findElement(By.partialLinkText("Sauce")).click();

		List<WebElement> elements = driver.findElements(By.partialLinkText("Sauce"));
		System.out.println(elements.size());

		Thread.sleep(2000);

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

//				driver.quit();
	}
	
}