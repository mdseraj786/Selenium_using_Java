package com.seraj.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TestCase1 {
    public static void main(String[] args) {
        String driverName = "webdriver.chrome.driver";
        String driverPath = "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
        System.setProperty(driverName, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.gmail.com/");
        driver.manage().window().fullscreen();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("identifierId")).sendKeys("seraj@gmail.com");

        // Click on "Next" button after it becomes clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']/parent::button"))).click();

        String at = driver.getTitle();
        String et = "gmail";
        System.out.println(at);
        driver.close();

        if (at.equalsIgnoreCase(et)) {
            System.out.println("Test Successful");
        } else {
            System.out.println("Test Failure");
        }
    }
}
