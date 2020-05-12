package com.webdrivermanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.exceptionhandling.PropertyFileReaderExceptions;
import com.exceptionhandling.WebDriverExceptions;
import com.propertyfilereader.PropertyFileReader;

public class IEWithCapabilities implements IWebDriver {

	WebDriver driver = null;
	private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";

	public WebDriver getDriver() throws WebDriverExceptions, PropertyFileReaderExceptions {

		System.setProperty(IE_DRIVER_PROPERTY, PropertyFileReader.getInstance().getPropertyReader().getDriverPath());
		return new InternetExplorerDriver();
	}

}
