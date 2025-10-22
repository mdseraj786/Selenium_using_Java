package com.seraj.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L09_WebTableOperation {
	public static void printAnyRowColumnValue(WebDriver driver) {
		driver.get("http://127.0.0.1:3000/c:/Users/mdser.SERAJ/Desktop/Automation/table.html?serverWindowId=238f879f-683b-4468-9552-012382f08e65");
		
//		print second row second column value
		WebElement element = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
		System.out.println(element.getText());
	}
	
	public static void printAllRowColumnValues(WebDriver driver) {
		driver.get("c:/Users/mdser.SERAJ/Desktop/Automation/table.html");
		
//		List<WebElement> rows = driver.findElements(By.tagName("tr"));
//		List<WebElement> column = driver.findElements(By.tagName("th"));
		
//		find total columns in webTable
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		
		System.out.println("Rows: " + rows.size());
		System.out.println("Column: " + columns.size());
		
		for(int i=2; i<=rows.size(); i++) {
			for(int j=1; j<=columns.size(); j++) {
				WebElement element = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]"));
				System.out.println(element.getText());
			}
		}
	}
	
	public static void testPrintAllRowColumnData(WebDriver driver) {
		driver.get("https://testautomationpractice.blogspot.com/p/playwrightpractice.html");
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr[1]/th"));
		
		System.out.println("Rows: " + rows.size());
		System.out.println("Column: " + columns.size());
		
		for(int i=2; i<=rows.size(); i++) {
			for(int j=1; j<=columns.size(); j++) {
				WebElement element = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]"));
				System.out.printf("|%-20s|",element.getText());
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		String driverName = "webdriver.chrome.driver";
		String chromeDriverPath = "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(driverName, chromeDriverPath);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		printAnyRowColumnValue(driver);
		
//		printAllRowColumnValues(driver);
		
		testPrintAllRowColumnData(driver);
	}
}
