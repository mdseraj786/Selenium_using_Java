package com.seraj.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumScript {

    public static void main(String[] args) {
        // Set path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\mdser.SERAJ\\Library\\Selenium WebDriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

       WebDriver driver = new ChromeDriver();
       
       driver.get("https://www.edureka.co");
       System.out.println(driver.getTitle());
//       driver.quit();
    }
}
