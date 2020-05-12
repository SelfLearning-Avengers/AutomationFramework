package com.propertyfilereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.exceptionhandling.PropertyFileReaderExceptions;

public class PropertyConfigReader implements IPropertyInterface {

	private Properties properties;
	private static final String PROPERTYFILEPATH = ".\\src\\main\\resources\\Properties\\Properties.properties";
	private static final String USERDIR = System.getProperty("user.dir") + "\\src\\test\\resources\\SampleAssets\\";

	public PropertyConfigReader() throws PropertyFileReaderExceptions {
		BufferedReader reader = null;
		properties = new Properties();
		try {
			reader = new BufferedReader(new FileReader(PROPERTYFILEPATH));
		} catch (FileNotFoundException e) {
			e.getMessage();
			throw new PropertyFileReaderExceptions("Configuration.properties not found at " + PROPERTYFILEPATH);
		}
		try {
			properties.load(reader);
			reader.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public String getDriverPath() throws PropertyFileReaderExceptions {
		String driverPath = properties.getProperty("driverpath");
		if (driverPath != null) {
			return properties.getProperty("driverpath");
		}
		return driverPath;
	}

	public String getApplicationUrl() throws PropertyFileReaderExceptions {
		String url = properties.getProperty("URL");
		if (url != null)
			return url;
		else
			throw new PropertyFileReaderExceptions("url not specified in the Configuration.properties file." + url);
	}

	public String getBrowser() throws PropertyFileReaderExceptions {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome"))
			return "chrome";
		else if (browserName.equalsIgnoreCase("firefox"))
			return "firefox";
		else if (browserName.equals("iexplorer"))
			return "ie";
		else
			throw new PropertyFileReaderExceptions(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public String getMCUserName() throws PropertyFileReaderExceptions {
		return properties.getProperty("Username");
	}

	public String getMCPwd() throws PropertyFileReaderExceptions {
		return properties.getProperty("Password");
	}

	public String getUploadFile() throws PropertyFileReaderExceptions {
		return USERDIR + properties.getProperty("uploadfile");
	}

}
