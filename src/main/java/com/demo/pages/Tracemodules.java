package com.demo.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.baseutil.Basetest;
import com.demo.util.WebActionUtil;

public class Tracemodules
{
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;

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
	@FindBy(xpath = "//*[@id='rc-menu-uuid-98958-1-Trace-popup']/li[1]/span")
	private WebElement dashboard;
	

	public void tracemudules() throws InterruptedException
	{
		Tracesignuppage oldemailaddress = new Tracesignuppage(driver, eto, actionutil);
        String oldemail = oldemailaddress.getEmailAddress();
       
		
		actionutil.clickOnElement(email, "email address field is clicked");
		actionutil.typeText(email, oldemail, "Email Id Entered");
		actionutil.clickOnElement(pass, "Enter the password");
		actionutil.typeText(pass, "Admin@1234", "Password Id Entered");
		actionutil.clickOnElement(signin, "Press the signin button");
		Thread.sleep(8000);	
		actionutil.clickOnElement(trace, "click on trace");
		
		return;
	}

}
