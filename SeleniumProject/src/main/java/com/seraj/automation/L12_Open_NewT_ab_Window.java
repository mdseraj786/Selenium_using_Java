package com.seraj.automation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class L12_Open_NewT_ab_Window {
	
	public static void openNewTab(WebDriver driver) {
		driver.get("http://www.google.com");
		System.out.println("First page: "+ driver.getTitle());
		
		// switch tab 
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("http://www.facebook.com");
		System.out.println("Second page: "+ driver.getTitle());
		
		// collect all window handles
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<>();
		handles.addAll(windowHandles);
		
		driver.close(); // disconnect handle
			
		driver.switchTo().window(handles.get(0));// re-connect to first handle
		
		System.out.println("Reconnected page: " + driver.getTitle());
		
	}
	
	public static void openNewWindow(WebDriver driver) {
		driver.get("http://www.google.com");
		driver.get("http://www.google.com");
		System.out.println("First page: "+ driver.getTitle());
		
		// switch window 
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("http://www.facebook.com");
		System.out.println("Second page: "+ driver.getTitle());
		
		// collect all window handles
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<>();
		handles.addAll(windowHandles);
		
		driver.close(); // disconnect handle
			
		driver.switchTo().window(handles.get(0));// re-connect to first handle
		
		System.out.println("Reconnected page: " + driver.getTitle());
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String driverName = "webdriver.chrome.driver";
		String chromeDriverPath = "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(driverName, chromeDriverPath);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		openNewTab(driver);
		
		openNewWindow(driver);
	}
}
