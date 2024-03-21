package com.demo.pages;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.baseutil.Basetest;
import com.demo.util.WebActionUtil;

public class Tracelogin {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public static Properties prop = new Properties();
	public long eto = 30;
	public static final String usrdir = "user.dir";
	public static final String CONFIGPATH = System.getProperty(usrdir) + "./config/config.properties";

	public Tracelogin(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
	}
	static {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(CONFIGPATH);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
	
	/* X-path for Supplier button */
	@FindBy(xpath = "(//button[@id = 'header_user_dropdown'])[3]")
	private WebElement proflie;
	
	@FindBy(xpath = "//a[@id = 'Logout_header_select']")
	private WebElement signout;

	/**
	 * Description: Clicking on Sign In button and verify the UI of the Sign-in
	 * page.
	 * @throws InterruptedException 
	 */
	public void verifyLogin(String emailfield, String passwordfield) throws InterruptedException {
		actionutil.info("Sign in function call");
		actionutil.clickOnElement(email, "email address field is clicked");
		actionutil.typeText(email, emailfield, "Email Id Entered");
		actionutil.clickOnElement(pass, "Enter the password");
		actionutil.typeText(pass, passwordfield, "Password Id Entered");
		actionutil.clickOnElement(signin, "Press the signin button");
		Thread.sleep(2000);
		String siginPageTitle = driver.getTitle();
		//System.out.println("print the value of siginPageTitle" + siginPageTitle );
		assertEquals(siginPageTitle, Basetest.prop.getProperty("HomePageTitle"));
		Basetest.logger.info("HomePage title  is matched");
		Thread.sleep(2000);		
		return;
	}
	
	public void verifysuperadminLogin() throws InterruptedException {
		actionutil.info("Sign in function call");
		String emailfield = prop.getProperty("emailfield");
		String passwordfield = prop.getProperty("passwordfield");
		actionutil.clickOnElement(email, "email address field is clicked");
		actionutil.typeText(email, emailfield, "Email Id Entered");
		actionutil.clickOnElement(pass, "Enter the password");
		actionutil.typeText(pass, passwordfield, "Password Id Entered");
		actionutil.clickOnElement(signin, "Press the signin button");
		Thread.sleep(8000);	
		String siginPageTitle = driver.getTitle();
		assertEquals(siginPageTitle, Basetest.prop.getProperty("HomePageTitle"));
		Basetest.logger.info("HomePage title  is matched");
		Thread.sleep(8000);		
		return;
	}
}
