package com.demo.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demo.baseutil.Basetest;
import com.demo.util.WebActionUtil;

public class Tracedashboard {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	Tracesignuppage oldemailaddress = new Tracesignuppage(driver, eto, actionutil);
	String oldemail = oldemailaddress.getEmailAddress();
	String randomString = new Random().toString();
	String randomValue = actionutil.generateRandomAlphanumeric(8);
	int randomNumber = new Random().nextInt(1000);
	String emailaddress = randomValue + randomNumber + "@yopmail.com";	
	
	public Tracedashboard(WebDriver driver, long eto, WebActionUtil actionutil) {
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
	
	/* X-path for Network Management */
	@FindBy(xpath = "//*/li[2]/span")
	private WebElement networkmgmt;
	
	/* X-path for Add New */
	@FindBy(xpath = "//h5[@id='ADD_NEW_ORGANIZATION']")
	private WebElement addnew;
	
	/* X-path for Organisation Name */
	@FindBy(xpath = "//input[@id='org_name_input']")
	private WebElement orgname;
	
	/* X-path for Organisation Type */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[2]/div/div[1]/div/input")
	private WebElement orgtype;
	
	/* X-path for Organisation Upstream */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[2]/div/div[2]/ul/li[1]/div/div/div")
	private WebElement upstream;
	
	/* X-path for Organisation Role */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[3]/div/div[1]")
	private WebElement orgrole;
	
	/* X-path for Role */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[3]/div/div[2]/ul/li[2]/div/div/div")
	private WebElement rolesupplier;
	
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[3]/div/div[2]/ul/li[1]/div/div/div")
	private WebElement rolemanufacture;
	
	
	
	
	/* X-path for Module Name */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[4]/div/div[1]/div/input")
	private WebElement module;
	
	
	/* X-path for Trace */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[4]/div/div[2]/ul/li/div/div[2]/div[contains(text(), 'Trace')]")
	private WebElement trace1;
	
	/* X-path for EmailId */
	@FindBy(xpath = "//*[@id='org_email_input']")
	private WebElement email11;
	
	/* X-path for EmailId after password reset */
	@FindBy(xpath = "//*[@id='username_login_input']")
	private WebElement email1;
	
	/* X-path for password */
	@FindBy(xpath = "//input[@id = 'password_login_input']")
	private WebElement pass1;

	/* X-path for Signin button */
	@FindBy(xpath = "//button[@id = 'login_submit_button']")
	private WebElement signin1;
	/* X-path for Database Type */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[7]/div/div[1]/div/input")
	private WebElement dbtype;
	
	/* X-path for fabric */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[7]/div/div[2]/ul/li[1]/div/div/div")
	private WebElement fabric;

	/* X-path for sendinvte */
	@FindBy(xpath = "//button[@id='org_invite_button']")
	private WebElement sendinvite;

	/* X-path for submit */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/div[3]/div[2]/div[1]/div/div/div[2]/div/div[2]/button[2]")
	private WebElement submit;
	
	/* X-path for input email address */
	@FindBy(xpath = "//input[@placeholder='Enter your inbox here']")
	private WebElement inputemailaddress;
	
	/* X-path for arrow key */
	@FindBy(xpath = "//*[@id='refreshbut']/button/i")
	private WebElement arrow;
	
	/* X-path for first email */
	@FindBy(xpath = "(//button[@class='lm'])[1]")
	private WebElement firstemail;
	
	/* X-path for email subject */
	@FindBy(xpath = "/html/body/header/div[3]/div[1]")
	private WebElement emailsubject;
	
	/* X-path for email link */
	@FindBy(xpath = "//*[@id='mail']/div/div/div[1]/section/a")
	private WebElement link;
	
	/* X-path for enter password */
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passenter;

	/* X-path for enter confirm password */
	@FindBy(xpath = "//input[@name='confirmPassword']")
	private WebElement confirmpass;
	
	/* X-path for button */
	@FindBy(xpath = "//*[@id='root']/div/div[1]/div[2]/form/button")
	private WebElement button;
	

	/* X-path for modal window button */
	@FindBy(xpath = "//button[@class='btn btn-light SolidButton_solidButton__3mY_r  undefined']")
	private WebElement modalbutton;
	
	

	/* X-path for checkbox modal window */
	@FindBy(xpath = "//input[@class='MyAccount_checkbox__2UV1r']")
	private WebElement checkbox;
	
	/* X-path for outer modal window */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/div[2]/div")
		private WebElement outermodal;
	

	/* X-path for outer modal window */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/div[2]/div/div/div[2]")	
	private WebElement outermodal1;
	
	/* X-path for my profile first name */
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement myprofilefirstname;
	
	/* X-path for my profile last name */
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement myprofilelasttname;
	
	/* X-path for my profile  destination*/
	@FindBy(xpath = "//input[@name='designation']")
	private WebElement myprofiledest;
	
	/* X-path for submit */
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement myprofilesubmit;

	/* X-path for profile */
	@FindBy(xpath = "//*[@id='Admin Profile']")
	private WebElement myprofile;
	
	/* X-path for business */
	@FindBy(xpath = "//*[@id='Admin Profile']")
	private WebElement mybusiness;
	
	/* X-path for business company*/
	@FindBy(xpath = "//input[@id='business_profile_company_name']")
	private WebElement cmpname;
	
	/* X-path for business address*/
	@FindBy(xpath = " //input[@id='business_profile_address_input']")
	private WebElement cmpadd;
	
	/* X-path for business state*/
	@FindBy(xpath = "//input[@id='business_profile_province_input']")
	private WebElement cmpstate;
	
	/* X-path for business city*/
	@FindBy(xpath = "//input[@id='business_profile_city_input']")
	private WebElement cmpcity;
	
	/* X-path for business zipcode*/
	@FindBy(xpath = "//input[@id='business_profile_zipcode_input']")
	private WebElement cmpzip;
	
	
	
	/* X-path for business company*/
	@FindBy(xpath = " //button[@id='business_profile_save_changes']")
	private WebElement cmpsubmit;
	
	/* X-path for last cross*/
	@FindBy(xpath = " //*[@id='___reactour']/div[4]/div/button")
	private WebElement closebutton;

	
	/* X-path for Asset and Infrastructure */
	@FindBy(xpath = "//span[text()='Asset & Infrastructure Data']")
	private WebElement assetinfra;
	
	/* X-path for Asset */
	@FindBy(xpath = "//span[text()='Assets']")
	private WebElement asset;
	
	/* X-path for Add New Asset*/
	@FindBy(xpath = "//h5[@id='ADD_ASSET']")
	private WebElement addnew1;
	
	/* X-path for type */
	@FindBy(xpath = "//input[@placeholder='Select here']")
	private WebElement assettype;

	/* X-path for dropdown value */
	@FindBy(xpath = "//div[contains(text(),'Vehicle')]")
	private WebElement vehicle;

	/* X-path for vehicle name */
	@FindBy(xpath = "//input[@id='vehicle_name_input']")
	private WebElement vehiclename;
	
	/* X-path for vehiclenumber */
	@FindBy(xpath = "//input[@id='vehicle_number_input']")
	private WebElement vehicleno;
	
	/* X-path for make */
	@FindBy(xpath = "//input[@id='make_id']")
	private WebElement make;

	/* X-path for model */
	@FindBy(xpath = "//input[@id='model_id']")
	private WebElement model;
	
	/* X-path for enginenumber */
	@FindBy(xpath = "//input[@id='engine_number_input']")
	private WebElement engineno;
	
	/* X-path for classgvwr */
	@FindBy(xpath = "//input[@id='class_gvwr_input']")
	private WebElement classgvwr;
	
	/* X-path for weightcapacity */
	@FindBy(xpath = "//div[contains(@class,'ant-input-number-input-wrap')]//input[@placeholder='Enter here']")
	private WebElement weightcapacity;
	
	/* X-path for dropdown */
	@FindBy(xpath = "//span[@title='lbs']")
	private WebElement uom;
	
	/* X-path for kgs */
	@FindBy(xpath = "//div[contains(@class,'ant-select-item-option-content')][normalize-space()='kgs']")
	private WebElement dropdown;
	
	/* X-path for Add button */
	@FindBy(xpath = "//button[@id='org_invite_button']")
	private WebElement add;



	


	public void tracemudulesdashboard() throws InterruptedException {

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
		System.out.println("print the value of s1.    " + s1);
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
		System.out.println("print the value of s11.    " + s11);
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
		Thread.sleep(2000);
		
		return;
	}
	
	
	public void tracemudulenetworkmgmt() throws InterruptedException {
		Thread.sleep(8000);
		actionutil.clickOnElement(trace, "click on trace");
		Thread.sleep(2000);
			
		 actionutil.clickOnElement(networkmgmt, "Network Management is clicked");
		 Thread.sleep(5000);
		 actionutil.clickOnElement(addnew, "Add new is clicked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(orgname, "Organisation Name is clicked");
		String randomValue = actionutil.generateRandomAlphanumeric(8);
		 actionutil.typeText(orgname, randomValue, "Organisation is Entered");
		 actionutil.clickOnElement(orgtype, "Organisation type is clicked");
		 actionutil.clickOnElement(upstream, "upstream is selected");
		 actionutil.clickOnElement(orgrole, "Organisation role is clicked");
		 actionutil.clickOnElement(rolemanufacture, "Organisation role is selected");
		 actionutil.clickOnElement(module, "module is clicked");
		 actionutil.clickOnElement(trace1, "module is selected");
		 actionutil.clickOnElement(email11, "email field is clicked");
		// String emailaddress = randomNumber + "@yopmail.com";
		  System.out.println("Print the value of emailadress" + emailaddress);
		 actionutil.typeText(email11, emailaddress, "emailid is Entered");
		 //actionutil.clickOnElement(dbtype, "Database Type is clicked");
		// actionutil.clickOnElement(fabric, "Db is selected");
		// Thread.sleep(2000);
		// actionutil.scrollDown();
		Thread.sleep(1000);
		 actionutil.clickOnElement(sendinvite, "sendinvite button is clicked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(submit, "submit is selected");
		 Thread.sleep(5000);	
		 Thread.sleep(2000);
		 String url = "https://yopmail.com/";
		 ((JavascriptExecutor) driver).executeScript("window.open('" + url + "','_blank');");
		 String newTabHandle = new String(driver.getWindowHandles().toArray()[1].toString());
	   //  ((JavascriptExecutor) driver).executeScript("window.focus();", newTabHandle);
		 driver.switchTo().window(newTabHandle);
		 Thread.sleep(8000);
		 actionutil.clickOnElement(inputemailaddress, "Email address input field is clicked");
		 actionutil.typeText(inputemailaddress, emailaddress, "email address is entered");
		 actionutil.clickOnElement(arrow, "arrow button is clicked");
		 Thread.sleep(3000);
		 driver.switchTo().frame("ifinbox");
		 actionutil.clickOnElement(firstemail, "first email is clicked");
		 Thread.sleep(2000);
		 driver.switchTo().defaultContent();
		 driver.switchTo().frame("ifmail");
			 actionutil.clickOnElement(link, "email address is clicked");
			 String newTabHandle1 = new String(driver.getWindowHandles().toArray()[2].toString());
			 driver.switchTo().window(newTabHandle1);
		 Thread.sleep(2000);
		 actionutil.clickOnElement(passenter, "pass is clicked");
		 actionutil.typeText(passenter, "Admin@1234", "Password is entered");		 
		 actionutil.clickOnElement(confirmpass, "confirm password is clicked");
		 actionutil.typeText(confirmpass, "Admin@1234", "Confirm Password is entered");
		 Thread.sleep(2000);
		 actionutil.scrollDown();
		 actionutil.clickOnElement(button, "button is clicked");
		 Thread.sleep(2000);
		  actionutil.clickOnElement(email1, "email address field is clicked");
			actionutil.typeText(email1, emailaddress, "Email Id Entered");
			actionutil.clickOnElement(pass1, "Enter the password");
			actionutil.typeText(pass, "Admin@1234", "Password Id Entered");
			actionutil.scrollDown();
			actionutil.clickOnElement(signin1, "Press the signin button");
			Thread.sleep(6000);	
			actionutil.clickOnElement(outermodal1, "Press the signin button");
			//actionutil.scrollDown();
			Thread.sleep(1000);
			actionutil.clickOnElement(modalbutton, "Press the button");
			Thread.sleep(3000);
			actionutil.clickOnElement(outermodal, "Press the signin button");
			actionutil.scrollDown();
			actionutil.clickOnElement(checkbox, "Press the signin button");
			actionutil.clickOnElement(modalbutton, "Press the button");	
		return;
	}
	
	

}
