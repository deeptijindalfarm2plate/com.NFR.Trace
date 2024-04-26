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

public class Traceroles {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	int randomNumber = new Random().nextInt(1000);
	String randomValue;
	String emailaddress = "abc" + randomNumber + "@yopmail.com";
	String randomphnumber = actionutil.generateRandomNumber(10);
	String rolename1 = "rolename" + randomNumber;
    


	public Traceroles(WebDriver driver, long eto, WebActionUtil actionutil) {
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
	@FindBy(xpath = "//h5[@id='ADD_ROLE']")
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
	private WebElement nxtbutton123;

/* X-path for country code*/
	@FindBy(xpath = "//span[contains(text(), '+91')]")
	private WebElement countrycodeselect;

/* X-path for Phone number*/
	@FindBy(xpath = "//input[@name ='phoneNumber']")
	private WebElement phnumber;
	

/* X-path for Phone number*/
	@FindBy(xpath = "//span[@class='ant-menu-title-content' and contains(text(), 'Roles')]")
	private WebElement roles;
	
	

/* X-path for Role name*/
	@FindBy(xpath = "//input[@name='roleName']")
	private WebElement rolename;
	
	/* X-path for Role type*/
	@FindBy(xpath = "(//input[@tabindex='-1'])[1]")
	private WebElement roletype;

/* X-path for Role type*/
	@FindBy(xpath = "//div[contains(text(), 'Admin')]")
	private WebElement admin;

/* X-path for Role type*/
	@FindBy(xpath = "//div[contains(text(), 'Member')]")
	private WebElement member;

/* X-path for Role type*/
	@FindBy(xpath = "//div[contains(text(), 'Cooperative')]")
	private WebElement cooperative;
	/* X-path for Module*/
	@FindBy(xpath = "(//input[@tabindex='-1'])[2]")
	private WebElement modulenew;

/* X-path for Module*/
	@FindBy(xpath = "//div[contains(text(), 'Trace')]")
	private WebElement tracemodule;

/* X-path for orgaqnisationdept*/
	@FindBy(xpath = "(//input[@tabindex='-1'])[3]")
	private WebElement orgdept;

/* X-path for org dept select*/
	@FindBy(xpath = "//div[contains(text(), 'Select All')]")
	private WebElement orgdeptselect;


/* X-path for Next*/
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement nxtbutton;


/* X-path for Next button 1*/
	@FindBy(xpath = "//button[@type='button' and contains(text(),'Next')]")
	private WebElement nxtbutton1;



/* X-path for update*/
	//@FindBy(xpath = "(//input[@name='updateAll'])[1]")
    @FindBy(xpath = "//*[@id='undefined']/div[1]/div[3]/span")
	private WebElement update1;
	
	

/* X-path for update*/
	@FindBy(xpath = "//*[@id='set2']/div[1]/div[3]/span")
	private WebElement update2;

/* X-path for update*/
	@FindBy(xpath = "//*[@id='undefined']/div[1]/div[4]/span")
	private WebElement alert1;

/* X-path for update*/
	@FindBy(xpath = "//*[@id='set2']/div[1]/div[4]/span")
	private WebElement alert2;

/* X-path for Submit button*/
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement submitbtn;



	
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


public void roles() throws InterruptedException
{
	Thread.sleep(8000);
	Thread.sleep(8000);
	actionutil.clickOnElement(trace1, "click on trace");
	Thread.sleep(4000);
	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", usermanagement);
	//actionutil.scrollDown();
	 Thread.sleep(2000);
	 actionutil.clickOnElement(usermanagement, "User Management is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(roles, "roles is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(adduser, "Add new is clicked");
	 Thread.sleep(5000);
	 actionutil.clickOnElement(rolename, "role name is clicked");
	 Thread.sleep(2000);
	 actionutil.typeText(rolename, rolename1, "rolename is entered");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(roletype, "roletype is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(admin, "Admin is clicked");
			 Thread.sleep(2000);
			 actionutil.scrollDown();
			 Thread.sleep(2000);
	 actionutil.clickOnElement(modulenew, "modulename is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(tracemodule, "module name is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(orgdept, "orgdept is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(orgdeptselect, "orgdeptselect is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(nxtbutton, "nxtbutton is clicked");
	 Thread.sleep(8000);
	 actionutil.scrollToElement(nxtbutton1, "nxtbutton1 scrolled");
	 
	 Thread.sleep(2000);
	 actionutil.clickOnElement(nxtbutton1, "nxtbutton1 is clicked");
	 Thread.sleep(5000);
	// actionutil.typeText(countrycode, "+91", "countrycode is entered");
	 Thread.sleep(4000);
	 actionutil.scrollUp();
	 Thread.sleep(2000);
	/* actionutil.scrollUp();
	 Thread.sleep(2000);
	 actionutil.scrollUp();*/
	 Thread.sleep(7000);
	 actionutil.clickOnElement(update1, "update1 select is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(update2, "update2 is clicked");
	// Thread.sleep(2000);
	// actionutil.typeText(phnumber, randomphnumber, "phnumber is entered");
	 Thread.sleep(4000);
	 actionutil.clickOnElement(alert1, "alert1  is clicked");
	 Thread.sleep(2000);
	 actionutil.clickOnElement(alert2, "alert2  is clicked");
	 Thread.sleep(2000);
	 Thread.sleep(2000);
 actionutil.scrollToElement(submitbtn, "submitbtn scrolled");
	 
	 Thread.sleep(2000);
	 actionutil.clickOnElement(submitbtn, "submitbtn is clicked");
	 Thread.sleep(5000);
	
	 }

public String getEmailAddress() {
    return this.emailaddress;
}
}
