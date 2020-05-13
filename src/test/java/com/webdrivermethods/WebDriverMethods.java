package com.webdrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverMethods {

	WebDriver driver;
	WebDriverWait waitfor;

	public WebDriverMethods(WebDriver driver) {
		this.driver = driver;
		waitfor = new WebDriverWait(driver, 300);
	}

	public void click(WebElement element) {
		waitfor.until(ExpectedConditions.visibilityOf(element));
		waitfor.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void sendKeys(WebElement element, String value) {
		waitfor.until(ExpectedConditions.visibilityOf(element));
		waitfor.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(value);
	}

	
	public void reclick(WebElement element) {
		try {
			
			waitfor.until(ExpectedConditions.visibilityOf(element));
			waitfor.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}
}