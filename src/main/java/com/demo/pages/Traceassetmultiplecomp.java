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


public class Traceassetmultiplecomp {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	int randomNumber = new Random().nextInt(1000);
	String randomValue;
	String emailaddress = randomNumber + "@yopmail.com";
	String assetname = "Loading Vehicle" + actionutil.generateRandomAlphanumeric(2)+actionutil.generateRandomAlphanumeric(2);
    


	public Traceassetmultiplecomp(WebDriver driver, long eto, WebActionUtil actionutil) {
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
	////span[@class='ant-select-selection-item']
	private WebElement uom;
	
	/* X-path for kgs */
	@FindBy(xpath = "//div[contains(@class,'ant-select-item-option-content')][normalize-space()='kgs']")
	private WebElement dropdown;
	
	/* X-path for Add button */
	@FindBy(xpath = "//button[@id='org_invite_button']")
	private WebElement add;

	/*X-path for Tanker*/
	@FindBy(xpath = "//*[@id='add_asset_button']/div[1]/div[3]/div/div/div/input")
	private WebElement tankerdrop;
	
	
	
	/*X-path for Tanker*/
	@FindBy(xpath = " //div[contains(text(), 'Tanker')]")
	private WebElement tanker;
	
	/*X-path for Tanker*/
	@FindBy(xpath = " //div[contains(text(), 'Reefer Van')]")
	private WebElement van;
	
	
	/*X-path for Tanker*/
	@FindBy(xpath = "(//*[@id='compartment'])[1]")
	private WebElement comp;

	/*X-path for Tanker*/
	@FindBy(xpath = "(//*[@id='compartment_1'])")
	private WebElement compval;
	
	/*X-path for Tanker*/
	@FindBy(xpath = "//*[@id='compartmentName_0']")
	private WebElement compname1;

	/*X-path for Tanker*/
	@FindBy(xpath = "//*[@id='compartmentName_1']")
	private WebElement compname2;
	
	/*X-path for Tanker*/
	@FindBy(xpath = "//*[@id='length_0']")
	private WebElement len1;
	/*X-path for Tanker*/
	@FindBy(xpath = "//*[@id='length_1']")
	private WebElement len2;
	/*X-path for Tanker*/
	@FindBy(xpath = "//*[@id='breadth_0']")
	private WebElement breath1;
	/*X-path for Tanker*/
	@FindBy(xpath = "//*[@id='breadth_1']")
	private WebElement breath2;
	/*X-path for Tanker*/
	@FindBy(xpath = "//*[@id='height_0']")
	private WebElement height1;
	/*X-path for Tanker*/
	@FindBy(xpath = "//*[@id='height_1']")
	private WebElement height2;
	
	/*X-path for Tanker*/
	@FindBy(xpath = "//*[@id='maxWeightCapacity_0']")
	private WebElement maxwt1;
	/*X-path for Tanker*/
	@FindBy(xpath = "//*[@id='maxWeightCapacity_1']")
	private WebElement maxwt2;
	
	/*X-path for Tanker*/
	@FindBy(xpath = "//*[@id='unit_0']")
	private WebElement unit1;
	/*X-path for Tanker*/
	@FindBy(xpath = "//*[@id='unit_1']")
	private WebElement unit2;
	
	/*X-path for Tanker*/
	@FindBy(xpath = "//*[@id='unit_0_0']")
	private WebElement unitval1;
	/*X-path for Tanker*/
	@FindBy(xpath = "//*[@id='unit_1_0']")
	private WebElement unitval2;
	
	
	
	public void assetsmul() throws InterruptedException
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
		 actionutil.typeText(vehiclename,assetname , "enter the vehicle name");
		 actionutil.clickOnElement(vehicleno, "Click on Vehicle Number");
		 String randomValue = actionutil.generateRandomAlphanumeric(8);
		 actionutil.typeText(vehicleno, randomValue, "Enter the vehicle number");
		 actionutil.clickOnElement(tankerdrop, "click the dropdown of carrier");
		 actionutil.clickOnElement(van, "click the Refeer Van");
		 actionutil.clickOnElement(comp, "click the Compartment");
		 actionutil.clickOnElement(compval, "Select the value =2");
		 actionutil.clickOnElement(compname1, "clicked on comp name 1");
		 actionutil.typeText(compname1,"compname1", "enter the compname1");
		 actionutil.clickOnElement(len1, "clicked on length 1");
		 actionutil.typeText(len1,"10", "enter the len1");
		 actionutil.clickOnElement(breath1, "clicked on breath1");
		 actionutil.typeText(breath1,"10", "enter the breath1");
		 actionutil.clickOnElement(height1, "cliecked on height 1");
		 actionutil.typeText(height1,"10", "enter the height1");
		 actionutil.clickOnElement(maxwt1, "clicked on maxwt 1");
		 actionutil.typeText(maxwt1,"100", "enter the maxwt1");
		 actionutil.clickOnElement(unit1, "clicked on unit1");
		 actionutil.clickOnElement(unitval1, "clicked on unitval1");
		 actionutil.clickOnElement(compname2, "clicked on comany name2");
		 actionutil.typeText(compname2,"compname2", "enter the compname2");
		 actionutil.clickOnElement(len2, "clicked on length 2");
		 actionutil.typeText(len2,"10", "enter the len2");
		 actionutil.clickOnElement(breath2, "clicked on breadth2");
		 actionutil.typeText(breath2,"10", "enter the breath2");
		 actionutil.clickOnElement(height2, "clicked on height 2");
		 actionutil.typeText(height2,"10", "enter the height2");
		 actionutil.clickOnElement(maxwt2, "clicked on maxwt 2");
		 actionutil.typeText(maxwt2,"100", "enter the maxwt2");
		 actionutil.clickOnElement(unit2, "clicked on unit2");
		 actionutil.clickOnElement(unitval2, "clicked the value of unit2");
		 
		 
		 actionutil.scrollToElement(unit1, "scrolled down");
		 
		 actionutil.clickOnElement(make, "Click on Make");
		 actionutil.typeText(make,"Mahindra", "enter the make");
		 actionutil.clickOnElement(model, "Click on Model");
		 actionutil.typeText(model,"XUV", "enter the model");
		 actionutil.clickOnElement(model, "Click on Model");
		 actionutil.typeText(model,"XUV", "enter the model");
		 actionutil.clickOnElement(engineno, "Click on Vehicle Number");
		 String randomValue1 = actionutil.generateRandomAlphanumeric(8);
		 String randomValue2 = randomValue1 + "1";
		 actionutil.typeText(engineno, randomValue2, "Enter the engine number");
		 actionutil.clickOnElement(classgvwr, "Click on Class-GVWR");
		 actionutil.typeText(classgvwr,"C1-20", "enter the classgvwr");
		 actionutil.clickOnElement(weightcapacity, "Click on Weight Capacity");
		 actionutil.typeText(weightcapacity,"100", "enter the weight capacity");
		//actionutil.clickOnElement(uom, "UoM is clicked");
	//	 actionutil.clickOnElement(dropdown, "KGS is selected");
		 actionutil.scrollDowntoelement(add);
		 actionutil.scrollDown();
		 actionutil.clickOnElement(add, "Click on Add button");
		 Thread.sleep(1000);	

	 }
	}

