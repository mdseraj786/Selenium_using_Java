package com.seraj.automation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Stopwatch;

public class L14_JavaScript_Executer {

	public static void typeAndClickOperation(WebDriver driver) {
		// Open the webpage
		driver.get("https://testautomationpractice.blogspot.com/");

		// Create JavaScriptExecutor object
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Enter text in search box using JavaScript
		js.executeScript("document.getElementById('Wikipedia1_wikipedia-search-input').value='raju';");

		// Find search button and click using JavaScript
		WebElement element = driver.findElement(By.xpath("//input[@type='submit']"));
		js.executeScript("arguments[0].click()", element);

		System.out.println("Test complete");
	}

	public static void refreshBrowser(WebDriver driver) {
		// Open the webpage
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Set implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Refresh the page using JavaScript
		js.executeScript("history.go(0)");

		System.out.println("Page refreshed");
	}

	public static void find_Domain_Title_Url(WebDriver driver) {
		// Open the webpage
		driver.get("https://www.reddit.com/r/ProgrammerHumor/comments/1of3l3e/vibecodingisthefutureexceptifyouarewritingsoftware/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Get domain name using JavaScript
		String domainName = js.executeScript("return document.domain;").toString();
		System.out.println("Domain name of this site is: " + domainName);

		// Get title using JavaScript
		String title = js.executeScript("return document.title;").toString();
		System.out.println("Title of this site is: " + title);

		// Get URL using JavaScript
		String url = js.executeScript("return document.URL;").toString();
		System.out.println("URL of this site is: " + url);
	}

	public static void drawBorder(WebDriver driver) {
		// Open the webpage
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Find element to highlight
		WebElement element = driver.findElement(By.xpath("//h2[.='Dynamic Button']"));

		// Draw a red border around the element
		js.executeScript("arguments[0].style.border = '3px solid red';", element);
	}

	public static void zoomPage(WebDriver driver) {
		// Open the webpage
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Zoom the page to 50%
		js.executeScript("document.body.style.zoom = '50%';");
	}

	public static void get_Height_Width(WebDriver driver) {
		// Open the webpage
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Get viewport height and width using JavaScript
		String height = js.executeScript("return window.innerHeight;").toString();
		String width = js.executeScript("return window.innerWidth;").toString();

		// Print height and width
		System.out.println("Height : " + height);
		System.out.println("Width : " + width);
	}

	public static void performScroll(WebDriver driver) throws InterruptedException {
		// Open the webpage
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll from top to bottom
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println("Scrolled: top to bottom");

		// Start stopwatch
		Stopwatch watch = Stopwatch.createStarted();

		// Wait to see the scrolling effect
		Thread.sleep(15000);

		// Scroll from bottom to top
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		watch.stop();

		// Print time taken
		System.out.println("Time elapsed: " + watch.elapsed(TimeUnit.SECONDS) + " seconds");
		System.out.println("Scrolled: bottom to top");
	}

	public static void generateAlertPopUp(WebDriver driver) {
		// Open the webpage
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Generate alert popup using JavaScript
		js.executeScript("alert('Alert message from Mr. Seraj.')");
	}

	public static void navigateToDifferenPag(WebDriver driver) {
		// Open the webpage
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Navigate to another page using JavaScript
		js.executeScript("window.location='https://www.pavanonlinetrainings.com/'");
	}

	public static void flashElement(WebDriver driver) throws InterruptedException {
		// Open the webpage
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Find button element
		WebElement element = driver.findElement(By.xpath("//button[@class='start']"));

		// Get initial background color
		String initialBgColor = element.getCssValue("backgroundColor");

		// Flash element by changing background color repeatedly
		for (int i = 0; i <= 50; i++) {
			// Change color to red
			js.executeScript("arguments[0].style.backgroundColor= 'red'", element);
			Thread.sleep(100);

			// Back to original color
			js.executeScript("arguments[0].style.backgroundColor= '" + initialBgColor + "'", element);
			Thread.sleep(100);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		String driverName = "webdriver.chrome.driver";
		String driverPath = "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(driverName, driverPath);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		typeAndClickOperation(driver);

//		refreshBrowser(driver);

//		find_Domain_Title_Url(driver);

//		drawBorder(driver);

//		zoomPage(driver);

//		get_Height_Width(driver);

//		performScroll(driver);

//		generateAlertPopUp(driver);

//		navigateToDifferenPag(driver);

		// flash element test
		flashElement(driver);

		// Wait for 15 seconds to observe result
		Thread.sleep(15000);

		// Close browser
		driver.quit();
	}
}
