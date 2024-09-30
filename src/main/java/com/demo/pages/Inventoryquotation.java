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


public class Inventoryquotation {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	int randomNumber = new Random().nextInt(1000);
	String randomValue;
	String emailaddress = randomNumber + "@yopmail.com";
    


	public Inventoryquotation(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
}
	
	/* X-path for Inventory Mgmt */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/aside/div/ul/li[4]/div/span")
	private WebElement inventorymgmt;
	
	/* X-path for Inventory Capacity */
	@FindBy(xpath = "//span[text()='Inventory Lot Capacity Quotation']")
	private WebElement inventoryquot;
	
	
	/* X-path for Location */
	@FindBy(xpath = "//input[@id='location']")
	private WebElement location;

	/* X-path for location search */
	@FindBy(xpath = "//*[@id='root']/div[1]/div[6]/form[1]/div[1]/div[1]/div[3]/ul[1]/li[1]/p[1]/p[1]")
	private WebElement locationsearch;
	
	
	/* X-path for Capacity type*/
	@FindBy(xpath = "//*[@id='root']/div[1]/div[6]/form[1]/div[1]/div[2]/div[2]/div[1]/span[2]")
	private WebElement capacitytype;
	
	/* X-path for Capacity type*/
	@FindBy(xpath = "//div[contains(text(),'Non Slot/Non Pallet Type')]")
	private WebElement nonslot;
	
	
	/* X-path for slot */
	@FindBy(xpath = "//div[contains(text(),'Slot Type')]")
	private WebElement slot;
	
	/* X-path for pallet */
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]")
	private WebElement pallettype;
	
	
	/* X-path for capacity name */
	@FindBy(xpath = "//*[@id='root']/div[1]/div[6]/form[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]")
	private WebElement capacityname;
	
	/* X-path for Bay 1 */
	@FindBy(xpath = "//*[@id='root']/div[1]/div[6]/form[1]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[1]/div[1]")
	private WebElement nonslotcap;
	
	/* X-path for Bay 2 */
	@FindBy(xpath = "//*[@id='root']/div[1]/div[6]/form[1]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[1]/div[1]")
	private WebElement slotcap;
	
	/* X-path for Bay 5 */
	@FindBy(xpath = "//*[@id='root']/div[1]/div[6]/form[1]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[1]/div[1]")
	private WebElement palletcap;
	
	/* X-path for ProductID */
	@FindBy(xpath = "//input[@id='prod_id_ ']")
	private WebElement productida;
	
	/* X-path for ProductID */
	@FindBy(xpath = "//*[@id='root']/div[1]/div[6]/div[4]/div[3]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[1]/input[1]")
	private WebElement productidb;
	
	/* X-path for Product Search */
	@FindBy(xpath = "//*[@id='root']/div[1]/div[6]/div[4]/div[3]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/p[1]/span[1]")
	private WebElement productsearcha;
	
	/* X-path for Product Search */
	@FindBy(xpath = "//*[@id='root']/div[1]/div[6]/div[4]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/p[1]/span[2]")
	private WebElement productsearchb;
	
	/* X-path for Top */
	@FindBy(xpath = "//span[contains(text(),'Select')]")
	private WebElement typeofpack;
	
	/* X-path for packing search dropdown */
	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
	private WebElement packsearcha;

	/* X-path for packing search dropdown */
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
	private WebElement packsearchb;
	
	/* X-path for Product Search */
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[6]/div[4]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[2]/ul[1]/li[1]")
	private WebElement productslot;
	
	/* X-path for Product Search */
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
	private WebElement topslot;
	
	/* X-path for Product Search */
	@FindBy(xpath = "//*[@id='root']/div[1]/div[6]/div[4]/div[4]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[2]/ul[1]/li[1]")
	private WebElement productpallet;
	
	/* X-path for lotsperpallet */
	@FindBy(xpath = "//input[@name='lotsPerPallet']")
	private WebElement lotsperpallet;
	
	/* X-path for Product Search 
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
	private WebElement toppallet;*/
	
	/* X-path for add another cta */
	@FindBy(xpath = "//span[contains(text(),'Add another field')]")
	private WebElement addanotherf;
	
	/* X-path for calculate button */
	@FindBy(xpath = "//button[text()='Calculate']")
	private WebElement calcbutton;
	
	/* X-path for delete icon */
	@FindBy(xpath = "//*[@id='root']/div[1]/div[6]/div[4]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[7]/span[1]/button[1]/*[name()='svg'][1]")
	private WebElement deleteicon;
	
	/* X-path for delete yes */
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement yescta;
	
	/* X-path for Download pdf */
	@FindBy(xpath = "//button[text()='Download PDF']")
	private WebElement downloadcta;
	
	
	public void quotation() throws InterruptedException
	 {
		Thread.sleep(8000);
		actionutil.clickOnElement(inventorymgmt, "click on IM");
		Thread.sleep(4000);
		 actionutil.clickOnElement(inventoryquot, "Inventory Quotation is clicked");
		 Thread.sleep(2000);
		 String tab1Handle = driver.getWindowHandle();
		 actionutil.clickOnElement(location, "Location is clicked");
		 actionutil.typeText(location,"Surat", "enter the location name");
		 actionutil.clickOnElement(locationsearch, "location is selected");
		 
		 
		 //code for slot type 
		 
		 actionutil.clickOnElement(capacitytype, "Capacity Name is clicked");
		 actionutil.clickOnElement(slot, "Slot type is selected");
		 actionutil.clickOnElement(capacityname, "Capacity Name is clicked");
		 actionutil.typeText(capacityname,"Bay", "Enter the cap name");
		 Thread.sleep(5000);
		 actionutil.clickOnElement(slotcap, "Click on Non Slot cap");
		 Thread.sleep(4000);
		 //actionutil.typeText(capacityname, randomValue, "Enter the capacity number");
		 actionutil.clickOnElement(productida, "Click on ProductID");
		 actionutil.typeText(productida,"F2P", "Enter the product name");
		 Thread.sleep(5000);
		 actionutil.clickOnElement(productslot, "Click on Product");
		 Thread.sleep(4000);
		 actionutil.clickOnElement(typeofpack, "Click on Type of pack");
		 Thread.sleep(4000);
		 actionutil.clickOnElement(topslot, "Click on Type of pack dropdown");
		 Thread.sleep(4000);
		 actionutil.clickOnElement(calcbutton, "Click on calculate");
		 Thread.sleep(2000);
		 
		 //code for non slot type
		 
		     actionutil.clickOnElement(capacitytype, "Capacity Name is clicked");
		     actionutil.clickOnElement(nonslot, "Non Slot type is selected");
			 actionutil.clickOnElement(capacityname, "Capacity Name is clicked");
			 actionutil.typeText(capacityname,"Bay", "Enter the cap name");
			 Thread.sleep(3000);
			 actionutil.clickOnElement(nonslotcap, "Click on Non Slot cap");
			 Thread.sleep(2000);
			 //actionutil.typeText(capacityname, randomValue, "Enter the capacity number");
			 actionutil.clickOnElement(productida, "Click on ProductID");
			 actionutil.typeText(productida,"F2P", "Enter the product name");
			 Thread.sleep(2000);
			 actionutil.clickOnElement(productsearchb, "Click on Product B");
			 actionutil.clickOnElement(typeofpack, "Click on Type of pack");
			 Thread.sleep(4000);
			 actionutil.clickOnElement(packsearchb, "Click on Type of pack dropdown");
			 Thread.sleep(4000);
			
			 actionutil.clickOnElement(addanotherf, "Click on add another");
			 actionutil.clickOnElement(productidb, "Click on ProductID");
			 actionutil.typeText(productidb,"F2P", "Enter the product name");
			 Thread.sleep(2000);
			 actionutil.clickOnElement(productsearcha, "Click on Product B");
			 actionutil.clickOnElement(typeofpack, "Click on Type of pack");
			 Thread.sleep(2000);
			 actionutil.clickOnElement(packsearcha, "Click on Type of pack dropdown");
			 actionutil.clickOnElement(calcbutton, "Click on calculate");
			 Thread.sleep(2000);
			 actionutil.clickOnElement(deleteicon, "Click on delete icon");
			 Thread.sleep(1000);
			 actionutil.clickOnElement(yescta, "Click on yes");
			 Thread.sleep(2000);
		 
 //code for pallet type
		 
		 actionutil.clickOnElement(capacitytype, "Capacity Name is clicked");
		 actionutil.clickOnElement(pallettype, "pallet type is selected");
		 actionutil.clickOnElement(capacityname, "Capacity Name is clicked");
		 actionutil.typeText(capacityname,"Bay", "Enter the cap name");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(palletcap, "Click on pallet cap");
		 Thread.sleep(2000);
		 //actionutil.typeText(capacityname, randomValue, "Enter the capacity number");
		 actionutil.clickOnElement(productida, "Click on ProductID");
		 actionutil.typeText(productida,"F2P", "Enter the product name");
		 Thread.sleep(5000);
		 actionutil.clickOnElement(productpallet, "Click on Product");
		 Thread.sleep(4000);
		 actionutil.clickOnElement(typeofpack, "Click on Type of pack");
		 Thread.sleep(4000);
		 actionutil.clickOnElement(topslot, "Click on Type of pack dropdown");
		 Thread.sleep(4000);
		 actionutil.clickOnElement(lotsperpallet, "Click on lots per pallet");
		 actionutil.typeText(lotsperpallet,"10", "Enter the lots per pallet");
		 Thread.sleep(4000);
		 actionutil.clickOnElement(calcbutton, "Click on calculate");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(downloadcta, "Click on download");
		 Thread.sleep(7000);
		 actionutil.switchToOriginalTab(tab1Handle);
			Thread.sleep(4000);
		 
	 }
	}
