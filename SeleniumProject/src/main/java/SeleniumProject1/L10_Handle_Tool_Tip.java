package SeleniumProject1;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class L10_Handle_Tool_Tip {
	public static void test1(WebDriver driver) {
		driver.get("https://testautomationpractice.blogspot.com/p/playwrightpractice.html");
		
		String actualToolTip = driver.findElement(By.cssSelector("a[title^='Home']")).getAttribute("title");
		String expectedToolTip = "Home page link";
		
		if(actualToolTip.equals(expectedToolTip)) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test failed");
		}
	}
	
	public static void facebookTestToolTip(WebDriver driver) {
		driver.get("https://www.facebook.com/");
		
		@Nullable
		String actualTip = driver.findElement(By.cssSelector("a[title^='Sign']")).getAttribute("title");
		
		String expectedTip = "Sign up for Facebook";
		
		if(actualTip.equals(expectedTip)) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
	}

	public static void main(String[] args) {
		String driverName = "webdriver.chrome.driver";
		String chromeDriverPath = "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(driverName, chromeDriverPath);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		test1(driver);
		
		facebookTestToolTip(driver);
	}

}
