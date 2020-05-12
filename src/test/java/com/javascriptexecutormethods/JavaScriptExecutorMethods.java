package com.javascriptexecutormethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptExecutorMethods {
	JavascriptExecutor js;
	WebDriverWait waitfor;

	public JavaScriptExecutorMethods(WebDriver driver) {
		this.js = (JavascriptExecutor) driver;
		waitfor = new WebDriverWait(driver, 300);
	}

	public void jsclick(WebElement element) {
		waitfor.until(ExpectedConditions.visibilityOf(element));
		waitfor.until(ExpectedConditions.elementToBeClickable(element));
		js.executeScript("aruguments[0].click();", element);
	}

}
