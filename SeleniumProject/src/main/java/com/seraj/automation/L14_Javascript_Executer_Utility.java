package com.seraj.automation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Stopwatch;

public class L14_Javascript_Executer_Utility {

	// Type text into an input box using JavaScript
	public static void typeText(WebDriver driver, String elementId, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('" + elementId + "').value='" + text + "';");
	}

	// Click on a WebElement using JavaScript
	public static void clickElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	// Refresh the browser using JavaScript
	public static void refreshPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0);");
	}

	// Get domain name of the page
	public static String getDomain(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.domain;").toString();
	}

	// Get title of the page
	public static String getTitle(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.title;").toString();
	}

	// Get current page URL
	public static String getUrl(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.URL;").toString();
	}

	// Draw a border around an element
	public static void drawBorder(WebDriver driver, WebElement element, String color) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid " + color + "';", element);
	}

	// Zoom the entire webpage
	public static void zoomPage(WebDriver driver, int percentage) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='" + percentage + "%';");
	}

	// Get window height
	public static String getWindowHeight(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return window.innerHeight;").toString();
	}

	// Get window width
	public static String getWindowWidth(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return window.innerWidth;").toString();
	}

	// Scroll down to bottom of the page
	public static void scrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	// Scroll to top of the page
	public static void scrollToTop(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
	}

	// Generate an alert popup
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "');");
	}

	// Navigate to a different URL
	public static void navigateTo(WebDriver driver, String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='" + url + "';");
	}

	// Flash (blink) an element
	public static void flashElement(WebDriver driver, WebElement element, int times) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String originalColor = element.getCssValue("backgroundColor");
		for (int i = 0; i < times; i++) {
			js.executeScript("arguments[0].style.backgroundColor='red';", element);
			Thread.sleep(100);
			js.executeScript("arguments[0].style.backgroundColor='" + originalColor + "';", element);
			Thread.sleep(100);
		}
	}

	// Scroll from top to bottom and back up with delay
	public static void scrollUpAndDown(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println("Scrolled down");
		Stopwatch watch = Stopwatch.createStarted();
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		watch.stop();
		System.out.println("Scrolled up in " + watch.elapsed(TimeUnit.SECONDS) + " seconds");
	}
}
