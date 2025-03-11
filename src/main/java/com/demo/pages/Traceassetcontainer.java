package com.demo.pages;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.util.WebActionUtil;

public class Traceassetcontainer {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	int randomNumber = new Random().nextInt(1000);
	String randomValue;
	String emailaddress = randomNumber + "@yopmail.com";
	String containertext = "containerrr" + randomNumber + "abc" + randomNumber + "abc";
	public Traceassetcontainer(WebDriver driver, long eto, WebActionUtil actionutil) {
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

	/* X-path for Add New Asset */
	@FindBy(xpath = "//h5[@id='ADD_ASSET']")
	private WebElement addnew;

	/* X-path for type */
	@FindBy(xpath = "//input[@placeholder='Select here']")
	private WebElement assettype;

	/* X-path for dropdown value */
	@FindBy(xpath = "//div[contains(text(),'Vehicle')]")
	private WebElement vehicle;

	/* X-path for dropdown value */
	@FindBy(xpath = "//div[contains(text(),'Container')]")
	private WebElement container;

	/* X-path for vehicle name */
	@FindBy(xpath = "//input[@id='vehicle_name_input']")
	private WebElement vehiclename;

	/* X-path for vehiclenumber */
	@FindBy(xpath = "//input[@id='vehicle_number_input']")
	private WebElement vehicleno;

	/* X-path for conatinername */
	//@FindBy(xpath = "//*[@id='root']/div/div[6]/div[6]/div[1]/div[1]/div/div[2]/div[1]/input")
	@FindBy(xpath = "( //input[contains(@class, 'ContainerInputTable')])[1]")
	
	private WebElement containername;

	/* X-path for length */
	//@FindBy(xpath = "//*[@id='root']/div/div[6]/div[6]/div[1]/div[1]/div/div[2]/div[2]/input")
	@FindBy(xpath = "( //input[contains(@class, 'ContainerInputTable')])[2]")
	private WebElement length;

	/* X-path for breath */
	//@FindBy(xpath = "//*[@id='root']/div/div[6]/div[6]/div[1]/div[1]/div/div[2]/div[3]/input")
	@FindBy(xpath = "( //input[contains(@class, 'ContainerInputTable')])[3]")
	private WebElement breath;

	/* X-path for height */
	//@FindBy(xpath = "//*[@id='root']/div/div[6]/div[6]/div[1]/div[1]/div/div[2]/div[4]/input")
	@FindBy(xpath = "( //input[contains(@class, 'ContainerInputTable')])[4]")
	private WebElement height;

	/* X-path for uom */
	//@FindBy(xpath = "//*[@id='root']/div/div[6]/div[6]/div[1]/div[1]/div/div[2]/div[5]")
	@FindBy(xpath = "(//input[@type='text'])[4]")	
	private WebElement duom;

	/* X-path for uom */
	@FindBy(xpath = "//div[contains(text(), 'ft')]")
	private WebElement ft;

	/* X-path for weight */
	//@FindBy(xpath = "//*[@id='root']/div/div[6]/div[6]/div[1]/div[1]/div/div[2]/div[6]/input")
	@FindBy(xpath = "( //input[contains(@class, 'ContainerInputTable')])[5]")
	private WebElement wt;

	/* X-path for weight */
	//@FindBy(xpath = "//*[@id='root']/div/div[6]/div[6]/div[1]/div[1]/div/div[2]/div[7]")
	@FindBy(xpath = "(//input[@type='text'])[6]")	
	private WebElement wtcap;

	/* X-path for uom */
	@FindBy(xpath = "//div[contains(text(), 'tons')]")
	private WebElement tons;

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
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement add;

	public void assets() throws InterruptedException {
		Thread.sleep(8000);
	actionutil.clickOnElement(trace, "click on trace");
	Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", assetinfra);
		// actionutil.scrollDown();
		Thread.sleep(2000);
		actionutil.clickOnElement(assetinfra, "Asset & Infrastructure Data is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(asset, "Assets is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(addnew, "Add new is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(assettype, "Asset type is clicked");
		actionutil.clickOnElement(container, "Click on Vehicle Name");
		Thread.sleep(2000);
		actionutil.clickOnElement(containername, "container name is clicked");
		actionutil.typeText(containername, containertext, "enter the container name");
			System.out.println("print the value of Container  " + " " + containertext);
		Thread.sleep(2000);
		actionutil.clickOnElement(length, "length is clicked");
		Thread.sleep(2000);
		actionutil.typeText(length, "10", "enter the length");
		actionutil.clickOnElement(breath, "breadth is clicked");
		actionutil.typeText(breath, "10", "breath entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(height, "height is clicked");
		Thread.sleep(2000);
		actionutil.typeText(height, "20", "height entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(duom, "dom is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(ft, "ft is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(wt, "wt is clicked");
		Thread.sleep(2000);
		actionutil.typeText(wt, "1000", "weight entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(wtcap, "wtcap is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(tons, "tons is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(add, "Click on Add button");

		Thread.sleep(6000);

	}

	public String getconatiner() {
		return containertext;

	}
	
	public void abc() {
		String qbc = getconatiner();
		System.out.println("value of ----" + qbc );

	}
}
