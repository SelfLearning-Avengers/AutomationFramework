package com.trailrun;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.commonmethods.CommonMethods;
import com.exceptionhandling.PropertyFileReaderExceptions;
import com.exceptionhandling.WebDriverExceptions;
import com.propertyfilereader.PropertyFileReader;
import com.webdrivermanagement.BrowserFactory;
import com.webdrivermanagement.IGetBrowserFactory;
import com.webdrivermanagement.IWebDriver;

public class RunnerDemo {
	static ExtentTest loginfo;

	public static void main(String[] args) throws WebDriverExceptions, PropertyFileReaderExceptions {
		CommonMethods cm = new CommonMethods();
		try {
			loginfo = cm.getExtentTest("User Login", "User Login", "Given Launch Site", "Praveen Kumar Eruvanti");
			IGetBrowserFactory browserfact = new BrowserFactory();
			IWebDriver driver = browserfact.getBrowser("chrome");
			WebDriver driver1 = driver.getDriver();
			driver1.get(PropertyFileReader.getInstance().getPropertyReader().getApplicationUrl());
			driver1.manage().window().maximize();
			String currentURL = driver1.getCurrentUrl();
			loginfo.log(Status.INFO, currentURL);
			assertTrue(currentURL.contains("mc6qa"), "Browser Opened Successfully");
			loginfo.log(Status.PASS,
					"MC6 URL " + PropertyFileReader.getInstance().getPropertyReader().getApplicationUrl()
							+ " Launched Successfully");
			driver1.close();
			loginfo.log(Status.INFO, MarkupHelper.createLabel("Browser Closed", ExtentColor.GREEN));
			cm.saveExtentReport();
		} catch (Exception e) {
			loginfo.log(Status.INFO, e.getMessage());
		}
	}
}
