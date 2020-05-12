package com.webdrivermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.exceptionhandling.PropertyFileReaderExceptions;
import com.exceptionhandling.WebDriverExceptions;
import com.propertyfilereader.PropertyFileReader;

public class Chrome implements IWebDriver {
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriver getDriver() throws WebDriverExceptions, PropertyFileReaderExceptions {
		System.setProperty(CHROME_DRIVER_PROPERTY,
				PropertyFileReader.getInstance().getPropertyReader().getDriverPath());
		return new ChromeDriver();
	}

}
