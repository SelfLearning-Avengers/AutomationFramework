package com.webdrivermanagement;

public class BrowserFactory implements IGetBrowserFactory{

	public IWebDriver getBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome"))
			return new Chrome();
		else if (browser.equalsIgnoreCase("Firefox"))
			return new Firefox();
		else if (browser.equalsIgnoreCase("ie"))
			return new IE();
		return null;
	}
}
