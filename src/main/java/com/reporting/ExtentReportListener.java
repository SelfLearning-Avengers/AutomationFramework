package com.reporting;

import java.sql.Timestamp;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener {

	static ExtentReportListener extentreportlistener = null;
	ExtentHtmlReporter report = null;
	ExtentReports extent = null;
	ExtentTest test = null;

	private ExtentReportListener() {

	}

	public static synchronized ExtentReportListener getInstance() {
		if (extentreportlistener == null) {
			return new ExtentReportListener();
		}
		return extentreportlistener;

	}

	public ExtentReports setUp() {
		String timestamp = new Timestamp(System.currentTimeMillis()).toString();
		timestamp = timestamp.substring(0, timestamp.length() - 6).replace(":", "");
		if (extent != null)
			return extent;
		report = new ExtentHtmlReporter("AutomationFrameWork_" + timestamp + ".html");
		report.config().setTimeStampFormat("MM-dd-yyy");
		report.config().setDocumentTitle("Automation Frame Work Report");
		report.config().setReportName("Automation Frame Work Report");
		report.config().setTheme(Theme.DARK);
		report.start();
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "Name of the Application");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		return extent;
	}
}
