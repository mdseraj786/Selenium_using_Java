package com.seraj.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L02_CssSelector {

	public static void cssSelector(WebDriver driver) {
		// open sauce lab web page
		driver.get("http://www.saucedemo.com");

		// locate user name -- tag#id
		// driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");

		//
		// locate password -- tag[attribute=value]
		driver.findElement(By.cssSelector("input[name=password")).sendKeys("secret_sauce");

		// locate login button -- tag.value of class name
		driver.findElement(By.cssSelector("input.submit-button")).click();

		// switch to product page
		String currentWindowHandlle = driver.getWindowHandle();
		driver.switchTo().window(currentWindowHandlle);

		// add to card items using CSS selector
		// tag.valueClass[attribute=value]
		driver.findElement(By.cssSelector("button.btn[name=add-to-cart-sauce-labs-fleece-jacket]")).click();

		// tag[attribute$=substring] ^ = startWith, $ = endWith, * = contains
		driver.findElement(By.cssSelector("button[name$=light]")).click();

	}

	public static void main(String[] args) {
//		launch chrome driver
		String driverName = "webdriver.chrome.driver";
		String driverPath = "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(driverName, driverPath);

		WebDriver driver = new ChromeDriver();
		cssSelector(driver);
	}
}
