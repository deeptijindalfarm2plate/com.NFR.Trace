package com.demo.pages;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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


public class Inventorycapacity {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	int randomNumber = new Random().nextInt(1000);
	int randomNumber1= new Random().nextInt(2);
	String randomNumber12 = actionutil.generateRandomNumber(2);
	int randomNumber2= new Random().nextInt(2);
	String randomNumber13 = actionutil.generateRandomNumber(1);
	String randomValue;
	String emailaddress = randomNumber + "@yopmail.com";
	String userDir = System.getProperty("user.dir");
	String imageaddress1 = userDir + "\\src\\test\\resources\\data\\data.xlsx";
	String filePath = userDir + "\\src\\test\\resources\\data\\NewProduct.txt";
	
    


	public Inventorycapacity(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
}
	
	/* X-path for Inventory Mgmt */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/aside/div/ul/li[4]/div/span")
	private WebElement inventorymgmt;
	
	/* X-path for Inventory Capacity */
	@FindBy(xpath = "//span[text()='Inventory Capacity Projection Location']")
	private WebElement inventorycapacity;
	
	
	/* X-path for Add New*/
	@FindBy(xpath = "//h5[@id='ADD_INVENTORY_CAPACITY_PROJECTION']")
	private WebElement addtab;
	
	/* X-path for Location */
	@FindBy(xpath = "//input[@id='location']")
	private WebElement location;

	/* X-path for location search */
	@FindBy(xpath = "//*[@id='root']/div[1]/div[6]/div[1]/form[1]/div[1]/div[1]/div[3]/ul[1]/li[1]")
	private WebElement locationsearch;
	
	
	/* X-path for Capacity type*/
	@FindBy(xpath = "//*[@id='root']/div[1]/div[6]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/span[2]")
	private WebElement capacitytype;
	
	/* X-path for non-slot */
	@FindBy(xpath = "//div[contains(text(),'Non Slot/Non Pallet Type')]")
	private WebElement nonslot;
	
	/* X-path for slot */
	@FindBy(xpath = "//div[contains(text(),'Slot Type')]")
	private WebElement slot;
	
	/* X-path for slot */
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]")
	private WebElement pallettype;
	
	
	/* X-path for capacity name */
	@FindBy(xpath = "//input[@name='capacityName']")
	private WebElement capacityname;
	
	/* X-path for Floor length */
	@FindBy(xpath = "//*[@id='root']/div[1]/div[6]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input")
	private WebElement floorlength;
	
	/* X-path for Lengthuom */
	@FindBy(xpath = "//div[1]//form[1]//div[2]//div[1]//div[1]//div[2]//select[1]")
	private WebElement lengthuom;
	
	/* X-path for KM */
	@FindBy(xpath = "//div[1]//form[1]//div[2]//div[1]//div[1]//div[2]//select[1]/option[2]")
	private WebElement lengthkm;
	
	/* X-path for Floor breadth */
	@FindBy(xpath = "//input[contains(@name,'floorBreadth')]")
	private WebElement floorbreadth;
	
	/* X-path for breadthuom */
	@FindBy(xpath = "//select[@id='floorBreadthSelect']")
	private WebElement breadthuom;
	
	/* X-path for km */
	@FindBy(xpath = "//select[@id='floorBreadthSelect']/option[2]")
	private WebElement breadthkm;
	
	/* X-path for inventorylevel */
	@FindBy(xpath = "//input[@name='inventoryLevel']")
	private WebElement inventorylevel;

	/* X-path for slot count */
	@FindBy(xpath = "//input[contains(@name,'slotCount')]")
	private WebElement slotcount;
	
	/* X-path for seqrange a */
	@FindBy(xpath = "//input[@name='sequenceRange']")
	private WebElement seqrangea;
	
	/* X-path for seqrange b */
	@FindBy(xpath = "//input[@name='sequenceRangeInput']")
	private WebElement seqrangeb;
	
	/* X-path for checkbox */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/form/div[3]/div/div[2]/div[1]/label[1]")
	private WebElement checkbox;
	
	/* X-path for Browse CTA */
	@FindBy(xpath = "//*[@id='root']/div[1]/div[6]/div[1]/form[1]/div[3]/div[2]/div[2]/span[1]/div[1]/span[1]/button[1]")
	private WebElement browse;
	
	/* X-path for PALLET length */
	@FindBy(xpath = "//input[@name='palletLength']")
	private WebElement palletlength;
	
	/* X-path for Length Uom */
	@FindBy(xpath = "//select[@id='palletLengthSelect']")
	private WebElement palletuom;
	
	/* X-path for km */
	@FindBy(xpath = "//select[@id='palletLengthSelect']/option[2]")
	private WebElement palletkm;
	
	/* X-path for pallet breadth */
	@FindBy(xpath = "//input[@name='palletBreadth']")
	private WebElement palletbreadth;
	
	/* X-path for pallet level */
	@FindBy(xpath = "//input[@name='palletLevel']")
	private WebElement palletlevel;
	
	
	/* X-path for add another CTA */
	@FindBy(xpath = "//span[text()='Add Another']")
	private WebElement addanother;
	
	/* X-path for Add button */
	@FindBy(xpath = "//button[text()='Add Inventory Capacity']")
	private WebElement addbutton;
	
	
	
	public void inventory() throws InterruptedException
	 {
		Thread.sleep(8000);
		actionutil.clickOnElement(inventorymgmt, "click on IM");
		Thread.sleep(4000);
		 actionutil.clickOnElement(inventorycapacity, "Inventory Capacity is clicked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(addtab, "Add tab is clicked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(location, "Location is clicked");
		 actionutil.typeText(location,"Surat", "enter the location name");
		 actionutil.clickOnElement(locationsearch, "location is selected");
		 actionutil.clickOnElement(capacitytype, "Click on Capacity Type");
		 actionutil.clickOnElement(nonslot, "Non Slot is selected");
		 actionutil.clickOnElement(capacityname, "Capacity Name is clicked");
		 String randomValue = actionutil.generateRandomAlphanumeric(4);
		 actionutil.typeText(capacityname, randomValue, "Enter the capacity number");
		 actionutil.clickOnElement(floorlength, "Click on length");
		 actionutil.typeText(floorlength,randomNumber12, "enter the length");
		 //actionutil.typeText(floorlength,"20", "Enter the length");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(lengthuom, "Click on Uom");
		 Thread.sleep(1000);
		 actionutil.clickOnElement(lengthkm, "Click on km");
		 actionutil.clickOnElement(floorbreadth, "Click on breadth");
		 actionutil.typeText(floorbreadth,randomNumber12, "enter the breadth");
		 //actionutil.typeText(floorbreadth,"20", "Enter the breadth");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(inventorylevel, "Click on Levels");
		 actionutil.typeText(inventorylevel,"2", "enter the Levels");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(addanother, "Click on Add Another");
		 Thread.sleep(2000);
		 
		 //code for selecting Slot Capacity with seq range.
		 
		 actionutil.clickOnElement(capacitytype, "Click on Capacity Type");
		 actionutil.clickOnElement(slot, "Slot is selected");
		 //actionutil.clickOnElement(capacitytype, "Click on Capacity Type");
		 //actionutil.clickOnElement(slot, "Slot is selected");
		 actionutil.clickOnElement(capacityname, "Capacity Name is clicked");
		 String randomValue1 = actionutil.generateRandomAlphanumeric(4);
		 actionutil.typeText(capacityname, randomValue1, "Enter the capacity number");
		 actionutil.clickOnElement(floorlength, "Click on length");
		 actionutil.typeText(floorlength,randomNumber12, "enter the length");
		 //actionutil.typeText(floorlength,"20", "Enter the length");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(lengthuom, "Click on Uom");
		 Thread.sleep(1000);
		 actionutil.clickOnElement(lengthkm, "Click on km");
		 actionutil.clickOnElement(floorbreadth, "Click on breadth");
		 actionutil.typeText(floorbreadth,randomNumber12, "enter the breadth");
		 //actionutil.typeText(floorbreadth,"20", "Enter the breadth");
		 actionutil.clickOnElement(slotcount, "Count of slot is clicked");
		 actionutil.typeText(slotcount,"21", "Enter the count slot");
		 actionutil.clickOnElement(seqrangea, "Seq Range is clicked");
		 actionutil.typeText(seqrangea,"1", "Enter the seq range");
		 actionutil.clickOnElement(seqrangeb, "Next Seq Range is clicked");
		 actionutil.typeText(seqrangeb,"21", "Enter the Next Seq Range");
		 Thread.sleep(2000); 
		 actionutil.clickOnElement(addanother,"Click on Add Another"); 
		 Thread.sleep(2000);
			 
		//code for selecting Slot Capacity with checkbox.
		 
		 //actionutil.clickOnElement(capacitytype, "Click on Capacity Type");
		 //actionutil.clickOnElement(slot, "Slot is selected");
		 actionutil.clickOnElement(capacityname, "Capacity Name is clicked");
		 String randomValue11 = actionutil.generateRandomAlphanumeric(4);
		 actionutil.typeText(capacityname, randomValue11, "Enter the capacity number");
		 actionutil.clickOnElement(floorlength, "Click on length");
		 actionutil.typeText(floorlength,randomNumber12, "enter the length");
		 //actionutil.typeText(floorlength,"20", "Enter the length");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(lengthuom, "Click on Uom");
		 Thread.sleep(1000);
		 actionutil.clickOnElement(lengthkm, "Click on km");
		 actionutil.clickOnElement(floorbreadth, "Click on breadth");
		 actionutil.typeText(floorbreadth,randomNumber12, "enter the breadth");
		 //actionutil.typeText(floorbreadth,"20", "Enter the breadth");
		 actionutil.clickOnElement(slotcount, "Count of slot is clicked");
		 actionutil.typeText(slotcount,"22", "Enter the count slot");
		 actionutil.clickOnElement(checkbox, "checkbox is clicked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(addanother, "Click on Add Another");
		 Thread.sleep(2000);
		 
		//code for selecting Slot Capacity with file upload.
		 
		 actionutil.clickOnElement(capacityname, "Capacity Name is clicked");
		 String randomValue111 = actionutil.generateRandomAlphanumeric(4);
		 actionutil.typeText(capacityname, randomValue111, "Enter the capacity number");
		 actionutil.clickOnElement(floorlength, "Click on length");
		 actionutil.typeText(floorlength,randomNumber12, "enter the length");
		 //actionutil.typeText(floorlength,"20", "Enter the length");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(lengthuom, "Click on Uom");
		 Thread.sleep(1000);
		 actionutil.clickOnElement(lengthkm, "Click on km");
		 actionutil.clickOnElement(floorbreadth, "Click on breadth");
		 actionutil.typeText(floorbreadth,randomNumber12, "enter the breadth");
		 //actionutil.typeText(floorbreadth,"20", "Enter the breadth");
		 actionutil.clickOnElement(slotcount, "Count of slot is clicked");
		 actionutil.typeText(slotcount,"19", "Enter the count slot");
		 actionutil.clickOnElement(browse, "Browse is clicked");
		 try {
	            Robot robot = new Robot();
	            // Type the file path (replace "file_path" with the actual path of the file)
	            StringSelection selection = new StringSelection(imageaddress1);
	            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
	            robot.keyPress(KeyEvent.VK_CONTROL);
	            robot.keyPress(KeyEvent.VK_V);
	            robot.keyRelease(KeyEvent.VK_V);
	            robot.keyRelease(KeyEvent.VK_CONTROL);
	            robot.keyPress(KeyEvent.VK_ENTER);
	            robot.keyRelease(KeyEvent.VK_ENTER);
	        } 
		   catch (Exception e) {
	            e.printStackTrace();
	        }
		 Thread.sleep(2000); 
		 actionutil.clickOnElement(addanother,"Click on Add Another"); 
		 Thread.sleep(2000);
			 
	
		 //code for pallet type
		 
		 actionutil.clickOnElement(capacitytype, "Click on Capacity Type");
		 actionutil.clickOnElement(pallettype, "Pallet Type is selected");
		 actionutil.clickOnElement(capacityname, "Capacity Name is clicked");
		 String randomValue1111 = actionutil.generateRandomAlphanumeric(4);
		 actionutil.typeText(capacityname, randomValue1111, "Enter the capacity number");
		 actionutil.clickOnElement(floorlength, "Click on length");
		 actionutil.typeText(floorlength,randomNumber12, "enter the length");
		 //actionutil.typeText(floorlength,"20", "Enter the length");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(lengthuom, "Click on Uom");
		 Thread.sleep(1000);
		 actionutil.clickOnElement(lengthkm, "Click on km");
		 actionutil.clickOnElement(floorbreadth, "Click on breadth");
		 actionutil.typeText(floorbreadth,randomNumber12, "enter the breadth");
		 
		 actionutil.clickOnElement(palletlength, "Click on pallet length");
		 actionutil.typeText(palletlength,"22", "Enter the pallet length");
		 //actionutil.typeText(palletlength,randomNumber13, "enter the pallet length");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(palletuom, "Click on Uom");
		 Thread.sleep(1000);
		 actionutil.clickOnElement(palletkm, "Click on km");
		 actionutil.clickOnElement(palletbreadth, "Click on pallet breadth");
		 actionutil.typeText(palletbreadth,"33", "Enter the pallet breadth");
		 //actionutil.typeText(palletbreadth,randomNumber13, "enter the pallet breadth");
		 actionutil.clickOnElement(palletlevel, "palletlevel is clicked");
		 actionutil.typeText(palletlevel,"22", "Enter the pallet level");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(addanother, "Click on Add Another");
		 Thread.sleep(2000);
		 
		 actionutil.scrollDownToBottom();
		 Thread.sleep(2000);	
		 actionutil.clickOnElement(addbutton, "Click on Add button");
		 Thread.sleep(4000);	

	 }
	}
