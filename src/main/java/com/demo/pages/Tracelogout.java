package com.demo.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.baseutil.Basetest;
import com.demo.util.WebActionUtil;

public class Tracelogout {

	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;

	public Tracelogout(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
	}

	/* X-path for Supplier button */
	@FindBy(xpath = "(//*[@id = 'header_user_dropdown'])[3]")
	private WebElement proflie;

	/* X-path for Supplier button */
	@FindBy(xpath = "//div/div/div[2]/div[2]/div/div[5]/button/div")
	private WebElement profile;

	/* X-path for button logout */
	@FindBy(xpath = "//*[@id='Logout_header_select']/span")
	private WebElement logout;

	@FindBy(xpath = "//div[@class='dropdown ImageDropdown_dropdown__1lqWL Navbar_profileDropdown__2ZJmL']//span[contains(text(),\"Logout\")]")
	private WebElement logout1;

	/* X-path for image logo */
	@FindBy(xpath = "//img[@src ='/static/media/white-logo.df363a79.svg']")
	private WebElement logo;

	/**
	 * Description: To verify the Logout Page
	 */
	public void verifylogout() {

		try {
			actionutil.clickOnElement(profile, "Click on profile account");
			actionutil.clickOnElement(logout1, "Logout the Farm2Plate account");
			String LoginPageURL = driver.getCurrentUrl();
			if (LoginPageURL.contains("login")) {
				Basetest.logger.info("Url contains login");
				//String loginPageTitle = driver.getTitle();
				assertEquals(LoginPageURL, Basetest.prop.getProperty("LoginPage"));
				Basetest.logger.info("User is on Sigin page.");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
