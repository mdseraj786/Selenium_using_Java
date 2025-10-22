package com.seraj.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L08_Alert_Handle {
	
	public static void clickAlertButton(WebDriver driver) {
		driver.get("https://demoqa.com/alerts");
		
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		
//		switch to alert window and accept alert
		driver.switchTo().alert().accept();	// ok
//		driver.switchTo().alert().dismiss();	// dismiss
		
	}
	
	public static void comformAlert(WebDriver driver) {
		driver.get("https://demoqa.com/alerts");
		
		driver.findElement(By.id("confirmButton")).click();
		
//		switch to alert window and accept alert
		driver.switchTo().alert().accept();	// ok
		
	}
	
	public static void promptAlert(WebDriver driver) {
		driver.get("https://demoqa.com/alerts");
		
		driver.findElement(By.id("promtButton")).click();
		
//		switch to alert window and accept alert
		driver.switchTo().alert().sendKeys("Hi! This is Seraj");	// send message
		driver.switchTo().alert().accept();

		
	}
	public static void main(String[] args) {
		String driverName = "webdriver.chrome.driver";
		String chromeDriverPath = "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(driverName, chromeDriverPath);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		clickAlertButton(driver);
		
//		comformAlert(driver);
		
		promptAlert(driver);
		
		
//		driver.close();
	}
}
