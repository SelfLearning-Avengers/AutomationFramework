package com.webdrivermanagement;

public class BrowserWithCapabilitiesFactory implements IGetBrowserFactory{

	public IWebDriver getBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome"))
			return new ChromeWithCapabilities();
		else if (browser.equalsIgnoreCase("Firefox"))
			return new FirefoxWithCapabilities();
		else if (browser.equalsIgnoreCase("ie"))
			return new IEWithCapabilities();
		return null;
	}
}
