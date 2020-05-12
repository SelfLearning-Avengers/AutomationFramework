package com.webdrivermanagement;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.exceptionhandling.PropertyFileReaderExceptions;
import com.exceptionhandling.WebDriverExceptions;
import com.propertyfilereader.PropertyFileReader;

public class ChromeWithCapabilities implements IWebDriver {

	WebDriver driver = null;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriver getDriver() throws WebDriverExceptions, PropertyFileReaderExceptions {
		DesiredCapabilities jsCapabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("intl.accept_languages", "en-US");
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--start-maximized");
		jsCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty(CHROME_DRIVER_PROPERTY,
				PropertyFileReader.getInstance().getPropertyReader().getDriverPath());
		return new ChromeDriver(options);
	}

}
