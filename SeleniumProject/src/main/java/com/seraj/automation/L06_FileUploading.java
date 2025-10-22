package com.seraj.automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class L06_FileUploading {

	public static void uploadFile(WebDriver driver) {
		driver.get("https://demoqa.com/upload-download");

		driver.findElement(By.xpath("//input[@id='uploadFile'][@type='file']"))
				.sendKeys("C:\\Users\\mdser.SERAJ\\OneDrive\\Desktop\\Main.java");
	}

	public static void uploadFileByUsingRobotClass(WebDriver driver) throws AWTException {
		driver.get("https://demoqa.com/upload-download");

		WebElement element = driver.findElement(By.xpath("//input[@id='uploadFile']"));

		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();

		Robot rb = new Robot();
		rb.delay(5000);

//		copy file to clip-board 
		StringSelection ss = new StringSelection("C:\\Users\\mdser.SERAJ\\OneDrive\\Desktop\\Main.java");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

//		perform control + V action to paste file
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void main(String[] args) throws AWTException {
		String driverName = "webdriver.chrome.driver";
		String chromeDriverPath = "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(driverName, chromeDriverPath);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		uploadFile(driver);

		uploadFileByUsingRobotClass(driver);
	}
}
