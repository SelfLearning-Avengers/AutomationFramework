package com.actionsmethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsMethods {
	Actions actions;
	WebDriverWait waitfor;

	public ActionsMethods(WebDriver driver) {
		actions = new Actions(driver);
		waitfor = new WebDriverWait(driver, 300);
	}
	
	public void actionsclick(WebElement element) {
		waitfor.until(ExpectedConditions.visibilityOf(element));
		waitfor.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void actionSendKeys(WebElement element, String value) {
		waitfor.until(ExpectedConditions.visibilityOf(element));
		waitfor.until(ExpectedConditions.elementToBeClickable(element));
		actions.sendKeys(value).build().perform();
	}
}
