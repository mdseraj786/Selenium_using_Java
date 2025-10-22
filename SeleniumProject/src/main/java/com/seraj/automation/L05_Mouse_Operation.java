package com.seraj.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class L05_Mouse_Operation {

	public static void rightClick(WebDriver driver) {
		// open url
		driver.get("https://demoqa.com/buttons");

		WebElement button = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));

		Actions action = new Actions(driver);
		action.contextClick(button).perform();// right click action perform

		System.out.println("complete");
	}

	public static void doubleClick(WebDriver driver) {
		driver.get("https://www.testautomationstudio.com/demo/actions/");

		WebElement button = driver.findElement(By.cssSelector("input#action1A"));
		Actions action = new Actions(driver);
		action.doubleClick(button).perform();

		System.out.println("completed double click");

	}

	public static void dragAndDrop(WebDriver driver) {
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		Switch to the iframe first
		WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
		driver.switchTo().frame(iframe);

//		find source and destination elements
		WebElement source = driver.findElement(By.cssSelector("img[alt='The peaks of High Tatras']"));
		WebElement destination = driver.findElement(By.cssSelector("div#trash"));

//		perform action
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination);
		
		System.out.println("drag and drop complete");
	}
	
	public static void dropTest(WebDriver driver) {
		driver.get("http://127.0.0.1:3000/c:/Users/mdser.SERAJ/Desktop/automation%20practice.html");
		
		WebElement source = driver.findElement(By.id("drag1"));
		WebElement destination = driver.findElement(By.id("div1"));
		

//		perform action
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination);
		
		System.out.println("drag and drop complete");
	}
	
	public static void moveMouseOverElement(WebDriver driver) {
		driver.get("https://www.ebay.com/");
		
		WebElement element = driver.findElement(By.linkText("Home & Garden"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		
	}

	public static void main(String... arg) throws InterruptedException {
		String driverName = "webdriver.chrome.driver";
		String chromeDriverPath = "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(driverName, chromeDriverPath);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		rightClick(driver);

//		doubleClick(driver);

// 		drag and drop not working 
//		dragAndDrop(driver);
//		dropTest(driver);

		moveMouseOverElement(driver);
		
		Thread.sleep(10000);
//		driver.close();
	}
}
