package com.commonmethods;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.reporting.ExtentReportListener;

public class CommonMethods {
	ExtentTest loginfo;
	ExtentReports extent = ExtentReportListener.getInstance().setUp();
	ExtentTest test;

	public ExtentTest getExtentTest(String featurename, String feature, String scenarioname, String author) {
		try {
			test = extent.createTest(Scenario.class, featurename).createNode(Feature.class, feature)
					.createNode(Scenario.class, scenarioname);
			loginfo = test.createNode(new GherkinKeyword("Given"), scenarioname);
			loginfo.assignAuthor(author);
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}

		return loginfo;
	}
	
	public void saveExtentReport()
	{
		extent.flush();
	}
	

	


	}



