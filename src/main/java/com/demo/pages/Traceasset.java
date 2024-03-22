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


public class Traceasset {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	int randomNumber = new Random().nextInt(1000);
	String randomValue;
	String emailaddress = randomNumber + "@yopmail.com";
    


	public Traceasset(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
}
	
	/* X-path for trace button */
	@FindBy(xpath = "//*[@id='root']/div/div[4]/aside/div/ul/li[1]/div/span")
	private WebElement trace;
	
	/* X-path for Asset and Infrastructure */
	@FindBy(xpath = "//span[text()='Asset & Infrastructure Data']")
	private WebElement assetinfra;
	
	/* X-path for Asset */
	@FindBy(xpath = "//span[text()='Assets']")
	private WebElement asset;
	
	/* X-path for Add New Asset*/
	@FindBy(xpath = "//h5[@id='ADD_ASSET']")
	private WebElement addnew;
	
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


	
	public void assets() throws InterruptedException
	 {
		Thread.sleep(8000);
		actionutil.clickOnElement(trace, "click on trace");
		Thread.sleep(4000);
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", assetinfra);
		//actionutil.scrollDown();
		 Thread.sleep(2000);
		 actionutil.clickOnElement(assetinfra, "Asset & Infrastructure Data is clicked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(asset, "Assets is clicked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(addnew, "Add new is clicked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(assettype, "Asset type is clicked");
		 actionutil.clickOnElement(vehicle, "vehicle is selected");
		 actionutil.clickOnElement(vehiclename, "Click on Vehicle Name");
		 actionutil.typeText(vehiclename,"Loading Vehicle", "enter the vehicle name");
		 actionutil.clickOnElement(vehicleno, "Click on Vehicle Number");
		 String randomValue = actionutil.generateRandomAlphanumeric(8);
		 actionutil.typeText(vehicleno, randomValue, "Enter the vehicle number");
		 actionutil.clickOnElement(make, "Click on Make");
		 actionutil.typeText(make,"Mahindra", "enter the make");
		 actionutil.clickOnElement(model, "Click on Model");
		 actionutil.typeText(model,"XUV", "enter the model");
		 actionutil.clickOnElement(model, "Click on Model");
		 actionutil.typeText(model,"XUV", "enter the model");
		 actionutil.clickOnElement(engineno, "Click on Vehicle Number");
		 String randomValue1 = actionutil.generateRandomAlphanumeric(8);
		 actionutil.typeText(engineno, randomValue1, "Enter the engine number");
		 actionutil.clickOnElement(classgvwr, "Click on Class-GVWR");
		 actionutil.typeText(classgvwr,"Class I", "enter the classgvwr");
		 actionutil.clickOnElement(weightcapacity, "Click on Weight Capacity");
		 actionutil.typeText(weightcapacity,"100", "enter the weight capacity");
		 actionutil.clickOnElement(uom, "UoM is clicked");
		 actionutil.clickOnElement(dropdown, "KGS is selected");
		 actionutil.scrollDown();
		 actionutil.clickOnElement(add, "Click on Add button");
		 Thread.sleep(1000);	

	 }
	}

