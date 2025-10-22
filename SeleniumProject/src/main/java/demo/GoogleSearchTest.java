package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	public static void main(String[] args) {
		// Set the path to chromedriver if not set in system environment
		// System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
		String driverName = "webdriver.chrome.driver";
		String driverPath = "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(driverName, driverPath);

		// Initialize ChromeDriver
		WebDriver driver = new ChromeDriver();

		try {
			// Open Google
			driver.get("https://www.google.com");

			// Find the search box
			WebElement searchBox = driver.findElement(By.name("q"));

			// Type search query
			searchBox.sendKeys("youtube.com");

			// Submit the form
			searchBox.submit();

			// Wait for results to load (basic wait)
			Thread.sleep(20000);

			// Print titles of the results (first 5)
			for (int i = 1; i <= 5; i++) {
				try {
					WebElement result = driver.findElement(By.xpath("(//h3)[" + i + "]"));
					System.out.println("Result " + i + ": " + result.getText());
				} catch (Exception e) {
					System.out.println("Result " + i + ": Not found.");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}
