package com.demo.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demo.baseutil.Basetest;
import com.demo.util.WebActionUtil;

public class Tracemodules {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	Tracesignuppage oldemailaddress = new Tracesignuppage(driver, eto, actionutil);
	String oldemail = oldemailaddress.getEmailAddress();

	public Tracemodules(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
	}

	/* X-path for email */
	@FindBy(xpath = "//input[@id = 'username_login_input']")
	private WebElement email;

	/* X-path for password */
	@FindBy(xpath = "//input[@id = 'password_login_input']")
	private WebElement pass;

	/* X-path for Signin button */
	@FindBy(xpath = "//button[@id = 'login_submit_button']")
	private WebElement signin;

	/* X-path for trace button */
	@FindBy(xpath = "//*[@id='root']/div/div[4]/aside/div/ul/li[1]/div/span")
	private WebElement trace;

	/* X-path for trace button */
	@FindBy(xpath = "//*/li[1]/span")
	private WebElement dashboard;

	/* X-path for SoilScans button */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/div[2]/div[2]/div/div[4]/div/div/div[1]/div")
	private WebElement soilscans;

	/* X-path for lots button */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/div[2]/div[2]/div/div[3]/div/div/div[1]/div")
	private WebElement lots;

	/* X-path for product registered button */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/div[2]/div[2]/div/div[2]/div/div/div[1]/div")
	private WebElement productreg;

	/* X-path for organization Network */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/div[2]/div[2]/div/div[1]/div/div/div[1]/div")
	private WebElement orgnw;

	public void tracemudules() throws InterruptedException {

		// actionutil.clickOnElement(email, "email address field is clicked");
		// actionutil.typeText(email, oldemail, "Email Id Entered");
		// actionutil.clickOnElement(pass, "Enter the password");
		// actionutil.typeText(pass, "Admin@1234", "Password Id Entered");
		// actionutil.clickOnElement(signin, "Press the signin button");
		Thread.sleep(8000);
		actionutil.clickOnElement(trace, "click on trace");
		Thread.sleep(2000);
		actionutil.clickOnElement(dashboard, "click on dashboard");
		Thread.sleep(2000);
		// **Get the current window handle (Tab1)
		String tab1Handle = driver.getWindowHandle();
		actionutil.clickOnElement(orgnw, "click on organisation network");
		Thread.sleep(2000);
		// Switch to the new tab (Tab2)

		actionutil.switchToNewTab(tab1Handle);
		// String newTabHandle = new
		// String(driver.getWindowHandles().toArray()[1].toString());
		// ((JavascriptExecutor) driver).executeScript("window.focus();", newTabHandle);
		// driver.switchTo().window(newTabHandle);
		Thread.sleep(3000);
		String url1 = "https://qa.develop.farmtoplateapps.io/dlt-network/existing-organization";
		String url2 = "https://qa.develop.farmtoplateapps.io/products/existing-products";
		String url3 = "https://qa.develop.farmtoplateapps.io/reports/all-reports";
		String siginPageTitle = driver.getCurrentUrl();

		System.out.println("print the value of signpagetitle" + "  " + siginPageTitle);
		assertEquals(siginPageTitle, url1);
		Basetest.logger.info("Sign in title matched");
		Basetest.logger.info("UI verified for Organisation network page.");
		actionutil.switchToOriginalTab(tab1Handle);
		// driver.close();
		/*
		 * String newTabHandle1 = new
		 * String(driver.getWindowHandles().toArray()[0].toString());
		 * //((JavascriptExecutor) driver).executeScript("window.focus();",
		 * newTabHandle1); driver.switchTo().window(newTabHandle1);
		 */

		Thread.sleep(2000);
		// String tab1Handle1 = driver.getWindowHandle();
		actionutil.clickOnElement(productreg, "click on product register");
		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));

		Thread.sleep(2000);
		String s1 = driver.getCurrentUrl();
		System.out.println("print the value of s1    " + s1);
		Thread.sleep(2000);
		// System.out.println("print the value of signpagetitle" + " " +
		// siginPageTitle);
		assertEquals(s1, url2);
		Basetest.logger.info("Sign in title matched");
		Basetest.logger.info("UI verified for Product page.");

		driver.switchTo().window(tabs.get(0));
		Thread.sleep(1000);

		actionutil.clickOnElement(lots, "click on lots");
		Thread.sleep(2000);
		ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(3));
		Thread.sleep(2000);
		String s11 = driver.getCurrentUrl();
		System.out.println("print the value of s11    " + s11);
		Thread.sleep(2000);
		assertEquals(s11, url3);
		Basetest.logger.info("Sign in title matched");
		Basetest.logger.info("UI verified for Lots page.");
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		// Get all the window handles
		ArrayList<String> tabs22 = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("print the sixe of tabs---" + tabs22.size());

		// Iterate through the tabs
		for (int i = 1; i <tabs22.size(); i++) {
		    // Switch to each tab and close it
		    driver.switchTo().window(tabs22.get(i));
		    driver.close();
		}

		// Switch back to the first tab
		driver.switchTo().window(tabs22.get(0));
		
		return;
	}

}
