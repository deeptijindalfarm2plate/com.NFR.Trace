package com.demo.baseutil;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createdriver {

	private static Createdriver instance = null;

	private Createdriver() {
	}

	/**
	 * getInstance method to retrieve active driver instance
	 *
	 * @return CreateDriver
	 */
	public static Createdriver getInstance() {
		if (instance == null) {
			instance = new Createdriver();
		}
		return instance;
	}

	public WebDriver setDriver(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//DesiredCapabilities capabilities= new DesiredCapabilities();
			 
			/*
			 * ChromeOptions chromeOptions = new ChromeOptions();
			 * chromeOptions.addArguments("--headless");
			 * chromeOptions.addArguments("--disable-popup-blocking");
			 * chromeOptions.addArguments("--disable-infobars"); return new
			 * ChromeDriver(chromeOptions);
			 */return new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();
		} else {
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
	}

	/**
	 * Description :Sets the capabilities of web driver according to the Browser
	 *
	 * @author Deepti Jindal
	 * @param browser
	 * @param capabilities
	 * @param LOCAL_HUB_URL
	 *
	 */
	/*
	 * public WebDriver setWebDriverGrid(String browser, String localhuburl) throws
	 * IOException {
	 * 
	 * DesiredCapabilities capabilities; switch (browser) {
	 * 
	 * case "Firefox": FirefoxOptions firefoxOptions = new FirefoxOptions();
	 * firefoxOptions.setHeadless(true); ProfilesIni profile = new ProfilesIni();
	 * FirefoxProfile testprofile = profile.getProfile(null);
	 * testprofile.setPreference("dom.webnotifications.enabled", false);
	 * testprofile.setPreference("dom.push.enabled", false); capabilities = new
	 * DesiredCapabilities(); capabilities.setBrowserName(BrowserType.FIREFOX);
	 * capabilities.setCapability(FirefoxDriver.PROFILE, testprofile);
	 * capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
	 * firefoxOptions.merge(capabilities); break; case "Chrome": ChromeOptions
	 * chromeOptions = new ChromeOptions();
	 * chromeOptions.addArguments("--headless");
	 * chromeOptions.addArguments("--disable-popup-blocking");
	 * chromeOptions.addArguments("--disable-infobars"); capabilities = new
	 * DesiredCapabilities(); capabilities.setBrowserName(BrowserType.CHROME);
	 * capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
	 * chromeOptions.merge(capabilities); break; case "Edge": capabilities = new
	 * DesiredCapabilities(); capabilities.setBrowserName(BrowserType.EDGE);
	 * capabilities.setPlatform(Platform.WINDOWS); break; case "Safari":
	 * capabilities = new DesiredCapabilities();
	 * capabilities.setBrowserName(BrowserType.SAFARI);
	 * 
	 * break; default: capabilities = null; }
	 * 
	 * try { return new RemoteWebDriver(new URL(localhuburl), capabilities);
	 * 
	 * } catch (MalformedURLException e) {
	 * 
	 * } return null; }
	 * 
	 */
	}
