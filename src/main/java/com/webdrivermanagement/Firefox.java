package com.webdrivermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.exceptionhandling.PropertyFileReaderExceptions;
import com.exceptionhandling.WebDriverExceptions;
import com.propertyfilereader.PropertyFileReader;

public class Firefox implements IWebDriver {

	WebDriver driver = null;
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";

	public WebDriver getDriver() throws WebDriverExceptions, PropertyFileReaderExceptions {
		System.setProperty(FIREFOX_DRIVER_PROPERTY,
				PropertyFileReader.getInstance().getPropertyReader().getDriverPath());
		return new FirefoxDriver();
	}

}
