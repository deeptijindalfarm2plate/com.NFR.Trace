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


public class Traceinfra {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	int randomNumber = new Random().nextInt(1000);
	String randomValue;
	String emailaddress = randomNumber + "@yopmail.com";
    


	public Traceinfra(WebDriver driver, long eto, WebActionUtil actionutil) {
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
	
	/* X-path for Infrastructure */
	@FindBy(xpath = "//span[text()='Infrastructure']")
	private WebElement infra;
	
	/* X-path for Add New Infra*/
	@FindBy(xpath = "//h5[@id='ADD_NEW_LOCATION']")
	private WebElement addnew;
	
	/* X-path for Location Name*/
	@FindBy(xpath = "//input[@id='location_name_input']")
	private WebElement locationname;
	
	/* X-path for type */
	@FindBy(xpath = "//select[@id='location_type_input']")
	private WebElement locationtype;

	/* X-path for dropdown value */
	@FindBy(xpath = "//select[@id='location_type_input']//option[1]")
	private WebElement packagingtype;

	/* X-path for gln */
	@FindBy(xpath = "//input[@id='GLN_number']")
	private WebElement gln;
	
	/* X-path for address */
	@FindBy(xpath = "//input[@id='add_location_address_input']")
	private WebElement address;
	
	/* X-path for state */
	@FindBy(xpath = "//input[@id='add_location_province_input']")
	private WebElement state;

	/* X-path for city */
	@FindBy(xpath = "//input[@id='add_location_city_input']")
	private WebElement city;
	
	/* X-path for zipcode */
	@FindBy(xpath = "//input[@id='add_location_zipcode_input']")
	private WebElement zipcode;
	
	
	/* X-path for Add button */
	@FindBy(xpath = "//button[@id='add_facility_btn']")
	private WebElement addbutton;


	
	public void infra() throws InterruptedException
	 {
		
		 Thread.sleep(5000);
		 actionutil.clickOnElement(infra, "Infra is clicked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(addnew, "Add new is clicked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(locationname, "Click on Location Name");
		 actionutil.typeText(locationname,"Warehouse B", "enter the location name");
		 actionutil.clickOnElement(locationtype, "Asset type is clicked");
		 actionutil.clickOnElement(packagingtype, "vehicle is selected");
		 actionutil.clickOnElement(gln, "Click on GLN");
		 actionutil.typeText(gln,"9999978912345", "enter the GLN");
		 actionutil.clickOnElement(address, "Click on address");
		 actionutil.typeText(address,"Bangalore Palace, Palace Cross Road, Vasanth Nagar, Bengaluru, Karnataka, India", "enter the  address");
	   	 actionutil.clickOnElement(state, "Click on state");
		 actionutil.typeText(state, "KA", "Enetered the state");
		 actionutil.clickOnElement(city, "Click on city");
		 actionutil.typeText(city, "Bengaluru", "Enetered the city");
		 actionutil.clickOnElement(zipcode, "Click on zip");
		 actionutil.typeText(zipcode, "560052", "Enetred the Zip");
		 actionutil.scrollDown();
		 actionutil.clickOnElement(addbutton, "Click on Add button");
		 Thread.sleep(1000);	

	 }
	}
