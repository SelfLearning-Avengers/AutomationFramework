package com.webdrivermanagement;

import org.openqa.selenium.WebDriver;

import com.exceptionhandling.PropertyFileReaderExceptions;
import com.exceptionhandling.WebDriverExceptions;

public interface IWebDriver {

	public WebDriver getDriver() throws WebDriverExceptions, PropertyFileReaderExceptions;

}
