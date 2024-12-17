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


public class Tracedrivers {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	int randomNumber = new Random().nextInt(1000);
	String randomValue;
	String emailaddress = randomNumber + "@yopmail.com";
	String assetname = "Loading Vehicle" + actionutil.generateRandomAlphanumeric(2)+actionutil.generateRandomAlphanumeric(2);
    


	public Tracedrivers(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
}
	
	/* X-path for trace button */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/aside/div/ul/li[1]/div/span")
	private WebElement trace;
	
	/* X-path for Asset and Infrastructure */
	@FindBy(xpath = "//span[text()='Asset & Infrastructure Data']")
	private WebElement assetinfra;
	
	/* X-path for Asset */
	@FindBy(xpath = "//span[text()='Drivers']")
	private WebElement drivers;
	
	/* X-path for Add New Asset*/
	@FindBy(xpath = " //*[@id='ADD_DRIVER']")
	private WebElement addnew;
	
	/* X-path for type */
	@FindBy(xpath = "//input[@id='driverName']")
	private WebElement drivername;

	
	/* X-path for type */
	@FindBy(xpath = "//input[@id='countryCode']")
	private WebElement countrycode;
	
	
	/*X-path for type */
	@FindBy(xpath = "//li[@id='undefined_0']")
	private WebElement countrycodeselect;
	

	
	
	/* X-path for dropdown value */
	@FindBy(xpath = "//div[contains(text(),'Vehicle')]")
	private WebElement vehicle;

	/* X-path for vehicle name */
	@FindBy(xpath = "//input[@id='phoneNumber']")
	private WebElement phone;
	
	/* X-path for vehiclenumber */
	@FindBy(xpath = "//input[@id='workingHours']")
	private WebElement workinghours;
	
	/* X-path for make */
	@FindBy(xpath = " //button[@id='add_driver_btn']")
	private WebElement adddriver;

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
	////span[@class='ant-select-selection-item']
	private WebElement uom;
	
	/* X-path for kgs */
	@FindBy(xpath = "//div[contains(@class,'ant-select-item-option-content')][normalize-space()='kgs']")
	private WebElement dropdown;
	
	/* X-path for Add button */
	@FindBy(xpath = "//button[@id='org_invite_button']")
	private WebElement add;

	/*X-path for Tanker*/
	@FindBy(xpath = "(//div[contains(text(),'04')])[1]")
	private WebElement time1;
	
	/*X-path for Tanker*/
	@FindBy(xpath = "(//div[contains(text(),'04')])[2]")
	private WebElement time2;
	
	
	/*X-path for Tanker*/
	@FindBy(xpath = " //span[contains(text(), 'OK')]")
	private WebElement ok;
	

	
	public void adddriver() throws InterruptedException
	 {
		Thread.sleep(8000);
		actionutil.clickOnElement(trace, "click on trace");
		Thread.sleep(4000);
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", assetinfra);
		//actionutil.scrollDown();
		 Thread.sleep(2000);
		 actionutil.clickOnElement(assetinfra, "Asset & Infrastructure Data is clicked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(drivers, "drivers is clicked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(addnew, "Add new is clicked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(drivername, "drivername is clicked");
		 actionutil.typeText(drivername, "driver", "driver name is entered");
		 actionutil.clickOnElement(countrycode, "countrycode is selected");
		 actionutil.typeText(countrycode, "+91", "countrycode is entered");
		 Thread.sleep(2000);		 
		 actionutil.clickOnElement(countrycodeselect, "country code is selected");
		 Thread.sleep(2000);
		 String phonenumber = actionutil.generateRandomNumber(5)+actionutil.generateRandomNumber(5);
		 actionutil.clickOnElement(phone, "phone number is clicked");
		 actionutil.typeText(phone, phonenumber , "enter the Phone");
		 Thread.sleep(3000);
		 
		 actionutil.clickOnElement(workinghours, "Click on workinghours");
		 Thread.sleep(2000);
		 
		 actionutil.clickOnElement(time1, "click the time1");
		 actionutil.clickOnElement(time2, "click the time2");
		Thread.sleep(2000);
		 actionutil.clickOnElement(ok, "click the ok");
		 Thread.sleep(2000);
		 
		 actionutil.clickOnElement(adddriver, "Add driver button is clicked");
				 Thread.sleep(2000);	

	 }
	}

