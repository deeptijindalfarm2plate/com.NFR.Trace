package com.demo.pages;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demo.baseutil.Basetest;
import com.demo.util.WebActionUtil;

public class Traceusers {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	int randomNumber = new Random().nextInt(1000);
	String randomValue;
	String emailaddress = "abc" + randomNumber + "@yopmail.com";
	String randomphnumber = actionutil.generateRandomNumber(10);
    


	public Traceusers(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
	}

	/* X-path for button login */
	@FindBy(xpath = "//button[@id='login_signin_button']")
	private WebElement signin;

	/* X-path for Network Management */
	@FindBy(xpath = "//*[@id='Network Management navbar_id']/div/span")
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
	
	
	/* X-path for Module Name */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[4]/div/div[1]/div/input")
	private WebElement module;
	
	/* X-path for Trace */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[4]/div/div[2]/ul/li/div/div[2]/div[contains(text(), 'Trace')]")
	private WebElement trace;
	
	/* X-path for EmailId */
	@FindBy(xpath = "//*[@id='org_email_input']")
	private WebElement email;
	
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
	
	/* X-path for order Management */
	
	
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div[3]/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div/div[1]/span[2]")
	//@FindBy(xpath = "//*[@id='root']/div/div[5]/div[3]/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div/div[1]/span[2]")
	private WebElement ordermgmt;
	
	/* X-path for soil dashboard */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div[3]/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/span[2]")
	//@FindBy(xpath = "//*[@id='root']/div/div[5]/div[3]/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/span[2]")
	private WebElement soildashboard;
	
	/* X-path for submit button */	
	@FindBy(xpath = "//button[@class = 'btn btn-light SolidButton_solidButton__3mY_r  undefined']")
	//@FindBy(xpath = "//*[@id=\"root\"]/div/div[5]/div[3]/div[2]/div[1]/div/div/div[2]/div/div[2]/button[2]")
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
	private WebElement pass;

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
	

/* X-path for users*/
	@FindBy(xpath = "//span[contains(text(),'Users')]")
	private WebElement users;

/* X-path for usermanagement*/
	@FindBy(xpath = "//span[@class='ant-menu-title-content' and contains(text(), 'User Management')]")
	private WebElement usermanagement;

/* X-path for add user*/
	@FindBy(xpath = "//h5[@id='ADD_NEW_USER']")
	private WebElement adduser;

/* X-path for Trace*/
	@FindBy(xpath = " //span[@class='ant-menu-title-content' and contains(text(), 'Trace')]")
	private WebElement trace1;

/* X-path for first name*/
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstname;

/* X-path for last name*/
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastname;

/* X-path for module name*/
	@FindBy(xpath = "//div[1]/div/div[1]/div/input[@placeholder ='Search and Select']")
	private WebElement modulename;


/* X-path for module name Item*/
	@FindBy(xpath = "//div[@class='d-flex align-items-center']/div/div[(contains(text(), 'Trace'))]")
	private WebElement modulenameitem;



/* X-path for assign name*/
	@FindBy(xpath = "//div[2]/div/div[1]/div/input[@placeholder ='Search and Select']")
	private WebElement assignnane;

/* X-path for assign item*/
	@FindBy(xpath = "//div[@class='d-flex align-items-center']")
	private WebElement assignitem;


/* X-path for email*/
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailuser;

/* X-path for sendinvite*/
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement sendinviteuser;

/* X-path for country code*/
	@FindBy(xpath = "//input[@placeholder ='Search Here']")
	private WebElement countrycode;

/* X-path for country code*/
	@FindBy(xpath = "//span[contains(text(), '+91')]")
	private WebElement countrycodeselect;

/* X-path for Phone number*/
	@FindBy(xpath = "//input[@name ='phoneNumber']")
	private WebElement phnumber;

	
	/**Description: To create generic function to select module*/
	public WebElement getModuleElement(String text1) {
	    String xpath = String.format("//*[@id='orgForm']/div[1]/div[4]/div/div[2]/ul/li/div/div[2]/div[contains(text(), text1)]");
	    return driver.findElement(By.xpath(xpath));
	}
	
	
	/**
	 * Description: Clicking on Sign In button and verify the UI of the Sign-in
	 * page.
	 * @throws InterruptedException 
	 */
	public void verifysignupPage() throws InterruptedException {
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


public void users() throws InterruptedException
{
	Thread.sleep(8000);
//	Thread.sleep(8000);
	actionutil.clickOnElement(trace1, "click on trace");
	Thread.sleep(4000);
	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", usermanagement);
	//actionutil.scrollDown();
	 Thread.sleep(2000);
	 actionutil.clickOnElement(usermanagement, "User Management is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(users, "users is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(adduser, "Add new is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(firstname, "first name is clicked");
	 Thread.sleep(2000);
	 actionutil.typeText(firstname, "abc", "first name is entered");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(lastname, "last name is clicked");
	 Thread.sleep(2000);
	 actionutil.typeText(lastname, "abc", "lastname name is entered");
			 Thread.sleep(2000);
	 actionutil.clickOnElement(modulename, "modulename is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(modulenameitem, "module name is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(assignnane, "assignrole is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(assignitem, "assignitem is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(emailuser, "emailuser is clicked");
	 Thread.sleep(2000);
	 actionutil.typeText(emailuser, emailaddress, "eamil is entered");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(countrycode, "countrycode is clicked");
	 Thread.sleep(2000);
	 actionutil.typeText(countrycode, "+91", "countrycode is entered");
	 Thread.sleep(4000);
	 actionutil.clickOnElement(countrycodeselect, "countrycode select is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(phnumber, "phnumber is clicked");
	 Thread.sleep(2000);
	 actionutil.typeText(phnumber, randomphnumber, "phnumber is entered");
	 Thread.sleep(4000);
	 actionutil.clickOnElement(sendinviteuser, "send invite user  is clicked");
	 Thread.sleep(2000);
	 Thread.sleep(2000);
	 String url = "https://yopmail.com/";
	 ((JavascriptExecutor) driver).executeScript("window.open('" + url + "','_blank');");
	 String newTabHandle = new String(driver.getWindowHandles().toArray()[1].toString());
   //  ((JavascriptExecutor) driver).executeScript("window.focus();", newTabHandle);
	 driver.switchTo().window(newTabHandle);
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
	 actionutil.clickOnElement(pass, "pass is clicked");
	 actionutil.typeText(pass, "Admin@1234", "Password is entered");		 
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
		Thread.sleep(3000);	
		//actionutil.clickOnElement(outermodal, "Press the signin button");
		actionutil.scrollDown();
		Thread.sleep(1000);
		actionutil.clickOnElement(modalbutton, "Press the button");
		//actionutil.clickOnElement(outermodal, "Press the signin button");
		actionutil.scrollDown();
		actionutil.clickOnElement(checkbox, "Press the signin button");
		Thread.sleep(2000);
		actionutil.clickOnElement(modalbutton, "Press the button");
 }

public String getEmailAddress() {
    return this.emailaddress;
}
}
