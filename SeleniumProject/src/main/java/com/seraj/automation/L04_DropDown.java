package com.seraj.automation;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;
import java.time.Duration;

import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class L04_DropDown {

	public static void dropDown(WebDriver driver) {
		driver.get("https://practice.expandtesting.com/dropdown");

		WebElement element = driver.findElement(By.id("dropdown"));

		Select dropDown1 = new Select(element);

//		dropDown.selectByVisibleText("Option 2");
//		dropDown.selectByIndex(1);
		dropDown1.selectByValue("2");

		WebElement element2 = driver.findElement(By.cssSelector("select#elementsPerPageSelect"));
		Select dropDown2 = new Select(element2);
		dropDown2.selectByContainsVisibleText("20");

		WebElement element3 = driver.findElement(By.xpath("//select[@id='country']"));
		Select dropDown3 = new Select(element3);
		dropDown3.selectByIndex(10);
	}

	public static void countAndPrintHyperlink(WebDriver driver) {
		driver.get("https://practice.expandtesting.com/#examples");
		List<WebElement> hyperlinks = driver.findElements(By.tagName("a"));

		System.out.println("Total hyperlinks : " + hyperlinks.size());

		hyperlinks.forEach(a -> System.out.println(a.getText()));
	}

	public static void brokenLinks(WebDriver driver) {

	
		// wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("http://www.deadlinkcity.com/");

		List<WebElement> elements = driver.findElements(By.tagName("a"));
		System.out.println("Total links : " + elements.size());

		int brokenLinks = 0;

		for (WebElement urls : elements) {
			String url = urls.getAttribute("href");
			try {
				URL urlLink = new URL(url);

				HttpURLConnection urlConnections = (HttpURLConnection) urlLink.openConnection();
				urlConnections.setRequestMethod("HEAD");
				urlConnections.connect();

				int responseCode = urlConnections.getResponseCode();

				if (responseCode >= 400) {
					System.out.println(url + "broken link");
					brokenLinks++;
				}
			} catch (MalformedURLException e) {

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		System.out.println("Broken Links : " + brokenLinks);
	}

	public static void countRadioButton(WebDriver driver) {
	
		// wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://practice.expandtesting.com/radio-buttons");
		
		List<WebElement> elements = driver.findElements(By.xpath("//input[@type='radio']"));
		
		System.out.println(elements.size());
	}
	
	public static void clickImage(WebDriver driver) throws InterruptedException {
		String path = "//img[@class='screenshot_100'][@src='images/optint_start.png']";
		
		driver.get("https://www.testresults.io/definitions/image-based-test-automation");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//img[@loading='lazy']")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equalsIgnoreCase("Automated software testing of entire business processes | TestResults")) {
			System.out.println("Image click successful");
		}
		else {
			System.out.println("Image click unsuccessful");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		String driverName = "webdriver.chrome.driver";
		String driverPath = "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(driverName, driverPath);

		WebDriver driver = new ChromeDriver();
		
		// maximize the window size
		driver.manage().window().maximize();

//		dropDown(driver);

//		countAndPrintHyperlink(driver);

//		brokenLinks(driver);
		
//		countRadioButton(driver);
		
		clickImage(driver);
		
		
		
		driver.close();
	}
}