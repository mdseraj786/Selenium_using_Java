package com.seraj.automation;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Stopwatch;

public class L13_Synchronization {

	public static void implicitWait(WebDriver driver) {
		driver.get("https://www.ebay.com/");

		// find web element advanced search
		driver.findElement(By.xpath("//a[.='Advanced']")).click();

		// Wait of 10 second
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		Stopwatch stop = null;
		try {
			stop = Stopwatch.createStarted();
			// find web element that is not present on page
			driver.findElement(By.xpath("//a[.='this is wrong ']")).click();

		} catch (Exception e) {
			stop.stop();
			System.out.println(e);
			System.out.println(stop.elapsed(TimeUnit.SECONDS));

		}

	}

	public static void explicitWait(WebDriver driver) {
		driver.get("https://www.ebay.com/");

		// find web element advanced search
		driver.findElement(By.xpath("//a[.='Advanced']")).click();
		System.out.println(driver.getCurrentUrl());
		// explicit Wait of 10 second
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Stopwatch stop = null;
		try {
			stop = Stopwatch.createStarted();
			// find web element that is not present on page
			String rightLocator = "input[name='_nkw'][id='_nkw']";
			String wrongLocator = "This is wrong locator"; // it will throw exception after 10 second explicit wait if
															// locator is not present
			WebElement webElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(wrongLocator)));

			webElement.sendKeys("Seraj");

		} catch (Exception e) {
			stop.stop();
			System.out.println(e);

		} finally {
			System.out.println("time taken: " + stop.elapsed(TimeUnit.SECONDS) + "sec");
		}
	}

	public static void fluentWait(WebDriver driver) {
		driver.get("https://www.ebay.com/");

		// find web element advanced search
		driver.findElement(By.xpath("//a[.='Advanced']")).click();
		System.out.println(driver.getCurrentUrl());

		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
//				.withMessage("This is the custom message for exception")
				.ignoring(NoSuchElementException.class);

		String rightLocator = "input[name='_nkw'][id='_nkw']";
		String wrongLocator = "This is wrong locator"; // it will throw exception after 10 second explicit wait if

		WebElement webElement = fluentWait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(wrongLocator)));
		webElement.sendKeys("Seraj");

	}

	public static void main(String[] args) {
		String driverName = "webdriver.chrome.driver";
		String driverPath = "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(driverName, driverPath);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		implicitWait(driver);

//		explicitWait(driver);

		fluentWait(driver);

	}

}
