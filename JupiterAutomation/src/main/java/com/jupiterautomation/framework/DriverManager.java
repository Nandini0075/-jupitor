/**
 * 
 */
package com.jupiterautomation.framework;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverManager {

	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);
	public static WebDriver webDriver = null;

	public static WebDriver getWebDriver() {
		if (DriverManager.webDriver == null) {
			webDriver = DriverManager.setUp();
		}
		return webDriver;
	}

	public DriverManager() {
		setUp();
	}

	private static WebDriver setUp() {
		webDriver = null;
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		System.out.println("Launching chorme....");

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("safebrowsing.enabled", "false");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--headless");
		options.setExperimentalOption("prefs", chromePrefs);
		options.setExperimentalOption("forceDevToolsScreenshot", true);
		options.addArguments("--start-fullscreen");
		options.addArguments("--browser.helperApps.neverAsk.saveToDisk=application/pdf");
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		try {
			webDriver = new ChromeDriver(cap);
			webDriver.manage().deleteAllCookies();

			webDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		} catch (Exception e) {
			LOGGER.debug("exception is: " + e.getMessage());
		}
		LOGGER.debug("launching chrome done...");
		return webDriver;
	}

	public static void quitWebDriver() {
		webDriver.quit();
	}

	

	

}