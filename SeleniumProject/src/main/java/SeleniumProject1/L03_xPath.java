package SeleniumProject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L03_xPath {

	public static void xPath(WebDriver driver) {
		// open sauce lab web page
		driver.get("http://www.saucedemo.com");

		// 1 locate username using single attribute
		// driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

		// 2 locate user name using -- xpath contains[
		driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("standard_user");

		// 3 locate user name using -- xpath start-with
		driver.findElement(By.xpath("//input[starts-with(@name,'user')]")).sendKeys("standard_user");

		// locate password using xPath -- multiple attribute
		driver.findElement(By.xpath("//*[@id='password'][@name='password']")).sendKeys("secret_sauce");

		// locate login button
		driver.findElement(By.xpath("//input[@id='login-button']")).click();

		String currentWindowHandler = driver.getWindowHandle();
		driver.switchTo().window(currentWindowHandler);

		// add to cart item using xPath
		driver.findElement(By.xpath(
				"//button[@id='add-to-cart-sauce-labs-fleece-jacket' and @name='add-to-cart-sauce-labs-fleece-jacket']"))
				.click();
		driver.findElement(By.xpath(
				"//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)' or @name='add-to-cart-test.allthethings()-t-shirt-(red)']"))
				.click();

	}

	public static void xPathPositionAndLast(WebDriver driver) {
		driver.get("https://only-testing-blog.blogspot.com/2014/09/temp.html");

		// locate using position()
		driver.findElement(By.xpath("//input[@type='text'][position()=2]")).sendKeys("this is second column value");
		driver.findElement(By.xpath("//input[@type='text'][last()]")).sendKeys("this is last column value");
	}

	public static void main(String[] args) {
//		launch chrome driver
		String driverName = "webdriver.chrome.driver";
		String driverPath = "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(driverName, driverPath);

		WebDriver driver = new ChromeDriver();

		xPath(driver);

//		xPathPositionAndLast(driver);
	}

}
