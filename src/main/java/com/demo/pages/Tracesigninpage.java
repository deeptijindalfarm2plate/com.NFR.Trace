package com.demo.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.baseutil.Basetest;
import com.demo.util.WebActionUtil;

public class Tracesigninpage {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;

	public Tracesigninpage(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
	}

	/* X-path for button login */
	@FindBy(xpath = "//button[@id='login_signin_button']")
	private WebElement signin;

	/**
	 * Description: Clicking on Sign In button and verify the UI of the Sign-in
	 * page.
	 * @throws InterruptedException 
	 */
	public void verifysigninPage() throws InterruptedException {
		actionutil.clickOnElement(signin, "Sign in with FarmtoPlate account");
		String siginPageURL = driver.getCurrentUrl();
		if (siginPageURL.contains("farmtoplateapps.io/login")) {
			Basetest.logger.info("Url contains farmtoplateapps.io/login");
			String siginPageTitle = driver.getTitle();
			assertEquals(siginPageTitle, Basetest.prop.getProperty("HomePageTitle"));
			Basetest.logger.info("Sign in title matched");
			Basetest.logger.info("UI verified for Sigin page.");
		}
	}

}
