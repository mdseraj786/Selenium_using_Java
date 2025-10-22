package com.seraj.automation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L11_CaptureScreenShot {
	public static void captureFullPageScreenshot(WebDriver driver) throws IOException {
		driver.get("https://www.facebook.com/");

		// capture full screenshot
		// step1: convert webDriver object to TakesScreenshot interface
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		// step2: call getScreenshotAs method to create image file
		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File("C:\\Users\\mdser.SERAJ\\eclipse-workspace\\SeleniumProject\\ScreenShot\\fullPage.png");

		// step3: copy image file to destination
		FileUtils.copyFile(src, dest);

	}

	public static void captureSectionScreenshot(WebDriver driver) throws IOException {
		driver.get("https://www.facebook.com/");
		
		//capture section of web page
		// step1: 
		WebElement section = driver.findElement(By.xpath("//form[@class='_9vtf']"));
		
		File src = section.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C:\\Users\\mdser.SERAJ\\eclipse-workspace\\SeleniumProject\\ScreenShot\\section.png");
		
		FileUtils.copyFile(src, dest);			
	}
	
	public static void captureSingleElement(WebDriver driver) throws IOException {
		driver.get("https://www.facebook.com/");
		
		//capture section of web page
		// step1: 
		WebElement section = driver.findElement(By.xpath("//button[ @name='login']"));
		
		File src = section.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C:\\Users\\mdser.SERAJ\\eclipse-workspace\\SeleniumProject\\ScreenShot\\login.png");
		
		FileUtils.copyFile(src, dest);			
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String driverName = "webdriver.chrome.driver";
		String chromeDriverPath = "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(driverName, chromeDriverPath);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		captureFullPageScreenshot(driver);
		
//		captureSectionScreenshot(driver);
		
		captureSingleElement(driver);
	}

}
