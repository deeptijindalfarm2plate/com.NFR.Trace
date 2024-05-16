package com.demo.pages;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
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

public class Tracetransaction {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	int randomNumber = new Random().nextInt(1000);
	int randomNumber1 = new Random().nextInt(13);
	String randomNumber12 = actionutil.generateRandomNumber(13);
	String randomValue;
	String emailaddress = randomNumber + "@yopmail.com";
	String proname = "wheat" + randomNumber;
	public static String userDir = System.getProperty("user.dir");
	String imageaddress1 = userDir + "\\src\\test\\resources\\data\\img.jpg";
	public static String filePath = userDir + "\\src\\test\\resources\\data\\file.txt";
	String imageaddress = "C:\\Users\\Deepti Jindal\\eclipse-workspace\\com.NFR.Trace\\src\\test\\resources\\data\\img.jpg";
	public static String line;
	// public static int lineNumber = 1; // Change this to the line number you want
	// to read
	public static long lineNumber = 0;
	public static int currentLine = 1;
	public static String savedValue = null;
	public static String datevalue = "03/31/2024";
	public static String lot;

	public Tracetransaction(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
	}

	/* X-path for trace button */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/aside/div/ul/li[1]/div/span")
	private WebElement trace;

	/* X-path for Process */
	@FindBy(xpath = "//span[text()='Transactions']")
	private WebElement transaction;

	/* X-path for existing Product id */
	@FindBy(xpath = "//*[@id='prod_id__add_transactions']")
	private WebElement productidtext;

	/* X-path for product id search box */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[5]/div[2]/div/div/div[1]/div[2]/form/div/div[1]/div[1]/div/div[2]/ul/li/p")
	private WebElement productidsearchbox;

	/* X-path for choose process */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[5]/div[2]/div/div/div[2]/div[2]/div/div/div/div[1]/div/input")
	private WebElement chooseprocess;
	// *[@id="root"]/div/div[5]/form/div[4]/div[1]/div/div[2]

	/* X-path for add new */
	@FindBy(xpath = "//*[@id='ADD_NEW_TRANSACTION']")
	private WebElement addnew;

	/* X-path for productname */
	@FindBy(xpath = "//input[@id='add_product_productName']")
	private WebElement productname;

	/* X-path for productid */
	@FindBy(xpath = "//input[@id='add_product_gtin_input']")
	private WebElement productid;

	/* X-path for checkbox */
	@FindBy(xpath = "//input[@id='gtin-checkbox']")
	private WebElement checkbox;

	/* X-path for Process select */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[5]/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/ul/li[3]/div/div/div")
	private WebElement processselectobs;

	/* X-path for Process select */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[5]/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/ul/li[1]/div/div/div")
	private WebElement processselecttrans;

	/* X-path for Process select */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[5]/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/ul/li[2]/div/div/div")
	private WebElement processselectdisagg;

	/* X-path for Process select */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[5]/div[2]/div/div/div[2]/div[2]/div/div/div/div[3]/ul/li[4]/div/div/div")
	private WebElement processselectagg;

	/* X-path for Process harvesting commission */
	// @FindBy(xpath =
	// "//*[@id='root']/div/div[5]/div/div[5]/div[2]/div/div/div[2]/div[2]/div/div/div/div[3]/ul/li[5]/div/div/div")
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[5]/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/ul")
	/// li/div/div/div
	private WebElement processselectcomm;

	/* X-path for Add Transaction */
	@FindBy(xpath = "//button[@id='add_transactions_add_button']")
	private WebElement addtran;

	/* X-path for activity */
	@FindBy(xpath = "//*[@id='add_transactions_why_input']")
	private WebElement activity;

	/* X-path for sscc */
	@FindBy(xpath = "//*[@id='add_transactions_observation_lgtin']")
	private WebElement sscc;

	/* X-path for date */
	@FindBy(xpath = "//*[@class='ant-picker-input']")
	private WebElement date;

	/* X-path for packing type dropdown */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div/div/div[2]/div/div[1]/div/input")
	private WebElement packingtype;

	/* X-path for packing type dropdown value */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div/div/div[2]/div/div[2]/ul/li[1]")
	private WebElement packingtypeselect;
	
	/* X-path for packing type date next button */
	@FindBy(xpath = "//*/div[3]/div/div/div/div/div[1]/div/div[1]/div[1]/button[3]")
	private WebElement datenextbutton;

	/* X-path for packing type date next button */
	@FindBy(xpath = "//*/body/div[4]/div/div/div/div/div[1]/div/div[1]/div[1]/button[3]")
	private WebElement datenextbutton1;

	/* X-path for packing type dropdown value */
	// @FindBy(xpath = "//td[@title='2024-03-30']")
	@FindBy(xpath = "//tr[3]/td[5]/div[@class='ant-picker-cell-inner']")
	private WebElement dateselect;

	/* X-path for packing type dropdown value */
	// @FindBy(xpath = "//td[@title='2024-03-30']")
	@FindBy(xpath = "//*/div[4]/div/div/div/div/div[1]/div/div[1]/div[2]/table/tbody/tr[3]/td[5]/div")
	private WebElement dateselect1;

	/* X-path for ok button */
	@FindBy(xpath = "//*/div[3]/div/div/div/div/div[2]/ul/li/button")
	private WebElement okbutton;

	/* X-path for ok button */
	@FindBy(xpath = "//*/div[4]/div/div/div/div/div[2]/ul/li/button")
	private WebElement okbutton1;

	/* X-path for lot number */
	@FindBy(xpath = "//*[@id='add_transactions_commission_LGTIN']")
	private WebElement lotnumber;

	/* X-path for existing productid */
	@FindBy(xpath = "//*[@id='prod_id_undefined']")
	private WebElement existingproductid;

	/* X-path for existing product search */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[5]/div[1]/div/div/div/div/div[2]/div/div/div[2]/ul")
	private WebElement existingproductsearch;

	/* X-path for existing search button */
	@FindBy(xpath = "//*[@id='transactions_search_button']")
	private WebElement searchbutton;

	/* X-path for lot value */
	@FindBy(xpath = "//table/tbody/tr[1]/th[2]")
	private WebElement lotelement;

	/* X-path for organisation */
	@FindBy(xpath = "//*[@id='myForm']/div[1]/div[2]/div/div/div/div/input")
	// @FindBy(xpath = "//*[@id='new_transaction_select_organization']")
	private WebElement org;

	/* X-path for organisation select */
	@FindBy(xpath = "//*[@id='myForm']/div[1]/div[2]/div/div/div[2]/ul/li")
	private WebElement orgselect;

	/* X-path for location */
	@FindBy(xpath = "//*[@id='myForm']/div[1]/div[3]/div/div/div[1]/div/input")
	private WebElement location;

	/* X-path for location */
	@FindBy(xpath = "//*[@id='myForm']/div[1]/div[3]/div/div/div[2]/ul/li")
	private WebElement locationselect;

	/* X-path for activity1 */
	@FindBy(xpath = "//*[@id='add_transactions_why_input']")
	private WebElement activity1;

	/* X-path for activity1 */
	@FindBy(xpath = "//*[@id='LGTIN_0']")
	private WebElement lot1;

	/* X-path for asset */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[4]/div/div/div/input")
	private WebElement asset;

	/* X-path for asset select */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[4]/div/div[2]/ul/li")
	private WebElement assetselect;

	/* X-path for shippiing date */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[5]/div[2]")
	private WebElement shippingdate;

	/* X-path for deliverydate */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[6]/div[2]")
	private WebElement deliverydate;

	/* X-path for container */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[7]/div/div/div/input")
	private WebElement container;

	/* X-path for container */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[7]/div/div[2]/ul")
	private WebElement containerselect;

	/* X-path for purchase */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[14]/div[2]/input")
	private WebElement purchase;

	/* X-path for bill */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[15]/div[2]/input")
	private WebElement bill;

	/* X-path for lot arrow */
	// @FindBy(xpath = "//*[@id='Icon_material-arrow-forward']")
	@FindBy(xpath = "//*[@id='aggregation_lgtin_arrow_button0']")

	private WebElement lotarrow;

	/* X-path for lot invoice */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[8]/div[2]/input")
	private WebElement invoice;

	/* X-path for seal */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[9]/div[2]/input")
	private WebElement seal;

	/* X-path for lorry number */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[10]/div[2]/input")
	private WebElement lorry;

	/* X-path for ASN */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[11]/div[2]/input")
	private WebElement asn;

	/* X-path for SSCC */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[1]/div[1]/label/img")
	private WebElement ssccimg;
	

/* X-path for  tlc */
	@FindBy(xpath = "//input[@id='add_transactions_commission_TLC_Number']")
	private WebElement tlc;

/* X-path for  Location */
	@FindBy(xpath = "//input[@id='add_transactions_commission_LocationOfImmediateEvent']")
	private WebElement Location;

/* X-path for  commodity */
	@FindBy(xpath = "//input[@name='CommodityVarietyOfTheProduct']")
	private WebElement commodity;

/* X-path for  field */
	@FindBy(xpath = "//input[@name='FieldOrFoodGrowingAreaName']")
	private WebElement field;

/* X-path for  container */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div/div/div[14]/div/div[1]/div/input")
	private WebElement Container;

/* X-path for document */
	@FindBy(xpath = "//input[@name='DocumentReferenceNo']")
	private WebElement document;

/* X-path for itemsgtin */
	@FindBy(xpath = "//input[@name='UoMSGTIN']")
	private WebElement itemsgtin;

/* X-path for weightsgtin */
	@FindBy(xpath = "//input[@name='WeightPerSGTIN']")
	private WebElement weightsgtin;

/* X-path for  countsgtin */
	@FindBy(xpath = "//input[@name='CountOfSGTIN']")
	private WebElement countsgtin;


	public static String copyvalue() throws FileNotFoundException {
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		/*
		 * try {
		 * 
		 * while ((line = bufferedReader.readLine()) != null) { if (currentLine ==
		 * lineNumber) { lineNumber++; savedValue = line; break; } currentLine++; }
		 * bufferedReader.close();
		 * 
		 * System.out.println(" print the value of saved :" + " " + savedValue);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } return savedValue;
		 * 
		 * }
		 */

		try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader(filePath))) {
			String line;
			// Start reading from the end of the file
			long lineNumber = 0;
			while ((line = bufferedReader1.readLine()) != null) {
				lineNumber++;
				savedValue = line; // Save the current line as the last line
				System.out.println("Last line: " + savedValue);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return savedValue;

	}

	public void transactioncomm() throws InterruptedException, IOException {
		Thread.sleep(8000);
		actionutil.clickOnElement(trace, "click on trace");
		Thread.sleep(4000);
		actionutil.scrollDowntoelement(transaction);
		Thread.sleep(2000);
		actionutil.clickOnElement(transaction, "transaction is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(addnew, "add new is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(productidtext, "Product id is clicked");
		Thread.sleep(2000);
		String copyvalue1 = copyvalue();
		actionutil.typeText(productidtext, copyvalue1, "Saved Value is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(productidtext, "Product id is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(productidsearchbox, "Product id is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(chooseprocess, "chooseprocess id is clicked");
		Thread.sleep(2000);
		actionutil.typeText(chooseprocess, "Harvesting", "Harvestiong/commission is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(chooseprocess, "chooseprocess id is clicked");
		Thread.sleep(3000);
		// actionutil.scrollDown();
		actionutil.clickOnElement(processselectcomm, "Process commision is selected");
		Thread.sleep(2000);
		actionutil.scrollDown();
		actionutil.clickOnElement(date, "date is selected");
		Thread.sleep(1000);
		actionutil.clickOnElement(datenextbutton, "date netx button");
		actionutil.clickOnElement(dateselect, "date is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(okbutton, "date is selected");
		Thread.sleep(2000);
		actionutil.scrollDowntoelement(activity);
		actionutil.clickOnElement(activity, "activity is selected");
		actionutil.typeText(activity, "abcd", "activity Value is entered");
		Thread.sleep(2000);
		//actionutil.scrollDowntoelement(packingtype);
		actionutil.clickOnElement(packingtype, "packing type dropdown is selected");
		actionutil.clickOnElement(packingtypeselect, "packing type dropdown is selected");
		Thread.sleep(2000);
		actionutil.scrollDowntoelement(packingtype);
		actionutil.clickOnElement(tlc, "tlc is clicked");
		actionutil.typeText(tlc, "1234567890", "Tlc no is entered");
		actionutil.clickOnElement(Location, "location is clicked");
		actionutil.typeText(Location, "location", "location no is entered");
		actionutil.clickOnElement(commodity, "commodity is clicked");
		actionutil.typeText(commodity, "commodity", "commodity is entered");
		actionutil.scrollDowntoelement(tlc);
		actionutil.clickOnElement(field, "filed is clicked");
		actionutil.typeText(field, "filed", "filed is entered");
		actionutil.clickOnElement(Container, "container is clicked");
		actionutil.typeText(Container, "container", "filed is entered");
		actionutil.clickOnElement(countsgtin, "count sgtin is clicked");
		actionutil.typeText(countsgtin, "123", "countsgtin is entered");
		actionutil.clickOnElement(weightsgtin, "weightsgtin sgtin is clicked");
		actionutil.typeText(weightsgtin, "1234567", "weightsgtin is entered");
		actionutil.clickOnElement(itemsgtin, "itemsgtin sgtin is clicked");
		actionutil.typeText(itemsgtin, "1234567", "itemsgtin is entered");
		actionutil.clickOnElement(document, "document is clicked");
		actionutil.typeText(document, "1234567", "document is entered");
		
		
		
		// actionutil.clickOnElement(lotnumber, "lot number is selected");
		// lot= lotnumber.getText();
		// System.out.println("print the value of lot :" + " " + lot);

		// actionutil.clickOnElement(sscc, "sscc is selected");
		// actionutil.typeText(sscc, "001234560000000018", "sscc Value is entered");
		actionutil.scrollDownToBottom();
		actionutil.scrollDowntoelement(document);
		// actionutil.scrollDowntoelement(addnew);
		actionutil.clickOnElement(addtran, "Add Transaction is selected");

	}

	public void transactionagg() throws InterruptedException, IOException {

		/***
		 * code to work single
		 */

		Thread.sleep(8000);
		/*
		 actionutil.clickOnElement(trace, "click on trace"); Thread.sleep(4000);
		  actionutil.scrollDowntoelement(transaction); Thread.sleep(2000);
		 actionutil.clickOnElement(transaction, "transaction is clicked");
		 Thread.sleep(5000);
		 */

		Thread.sleep(2000);
		actionutil.clickOnElement(existingproductid, "productid is selected");
		String copyvalue1 = copyvalue();
		actionutil.typeText(existingproductid, copyvalue1, "enter the productid");
		actionutil.clickOnElement(existingproductid, "productid is selected");
		actionutil.clickOnElement(existingproductsearch, "search is selected");
		actionutil.clickOnElement(searchbutton, "search button is clicked");
		Thread.sleep(2000);
		String lotvalue = lotelement.getText();
		System.out.println("Print the value :" + " " + lotvalue);
		actionutil.scrollUp();
		Thread.sleep(2000);
		actionutil.scrollUp();
		actionutil.clickOnElement(addnew, "add new is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(productidtext, "Product id is clicked");
		Thread.sleep(2000);
		actionutil.typeText(productidtext, copyvalue1, "Saved Value is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(productidtext, "Product id is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(productidsearchbox, "Product id is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(chooseprocess, "chooseprocess id is clicked");
		Thread.sleep(2000);
		actionutil.typeText(chooseprocess, "Packing", "Packing/aggregation is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(chooseprocess, "chooseprocess id is clicked");
		Thread.sleep(4000);
		actionutil.clickOnElement(processselectcomm, "Process aggre is selected");
		Thread.sleep(2000);
		actionutil.scrollDown();
		actionutil.clickOnElement(org, "org is selected");
		Thread.sleep(2000);
		actionutil.typeText(org, "178", "org value is entered");
		Thread.sleep(5000);
		actionutil.clickOnElement(orgselect, "org is selected");
		Thread.sleep(2000);
		actionutil.clickOnElement(location, "location is selected");
		actionutil.typeText(location, "test", "location value is entered");
		Thread.sleep(5000);
		actionutil.clickOnElement(locationselect, "location is selected");
		actionutil.scrollDown();
		// actionutil.scrollDowntoelement(activity1);
		actionutil.clickOnElement(activity1, "activity is clicked");
		Thread.sleep(2000);
		actionutil.typeText(activity1, "activity", "activity is entered");
		Thread.sleep(3000);
		actionutil.scrollDown();
		Thread.sleep(3000);
		actionutil.scrollDown();
		// actionutil.scrollDowntoelement(lot1);
		actionutil.clickOnElement(lot1, "lot1 is clicked");
		Thread.sleep(2000);
		actionutil.typeText(lot1, lotvalue, "lotvalue is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(lotarrow, "lot arrow is clicked");
		Thread.sleep(2000);
		// actionutil.scrollToElementnew(asset, "asset is clicked");
		actionutil.scrollDown();
		Thread.sleep(3000);
		actionutil.scrollDown();
		Thread.sleep(2000);
		actionutil.scrollDown();
		Thread.sleep(4000);
		actionutil.scrollDown();
		Thread.sleep(2000);
		actionutil.scrollDown();
		Thread.sleep(2000);
		actionutil.clickOnElement(asset, "asset is clicked");
		Thread.sleep(2000);
		actionutil.typeText(asset, "vehicle", "vehicle is entered");
		Thread.sleep(4000);
		actionutil.clickOnElement(assetselect, "assetsearch is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(shippingdate, "shippingdate is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(datenextbutton, "datenext button is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(dateselect, "date is entered");
		Thread.sleep(3000);
		actionutil.clickOnElement(okbutton, "date is selected");
		Thread.sleep(3000);
		actionutil.clickOnElement(deliverydate, "deliverydate is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(datenextbutton1, "datenext button is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(datenextbutton1, "datenext button is clicked");
		Thread.sleep(3000);
		actionutil.clickOnElement(dateselect1, "date is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(okbutton1, "date is selected");
		// actionutil.scrollDowntoelement(container);
		actionutil.scrollDown();
		actionutil.clickOnElement(container, "container is clicked");
		actionutil.typeText(container, "test", "container value is entered");
		Thread.sleep(5000);
		actionutil.clickOnElement(containerselect, "container select is clicked");
		Thread.sleep(2000);
		// actionutil.scrollToElement1(invoice, "asset is clicked");
		actionutil.clickOnElement(invoice, "invoice select is clicked");
		actionutil.typeText(invoice, "123", " invoice value is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(seal, "seal select is clicked");
		actionutil.typeText(seal, "123", "seal value is entered");
		Thread.sleep(2000);
		actionutil.scrollDown();
		Thread.sleep(2000);
		actionutil.clickOnElement(asn, "asn select is clicked");
		actionutil.typeText(asn, randomNumber12, "asn value is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(lorry, "lorry select is clicked");
		actionutil.typeText(lorry, "123", "lorry value is entered");
		Thread.sleep(2000);
		actionutil.scrollDownToBottom();
		// actionutil.scrollToElement(purchase, "pruchase is scrolled");
		actionutil.clickOnElement(purchase, "purchase is clicked");
		actionutil.typeText(purchase, "123", "purchase is entered");
		actionutil.clickOnElement(bill, "bill is clicked");
		actionutil.typeText(bill, "12345", "purchase is entered");
		actionutil.scrollDownToBottom();
		// actionutil.scrollDowntoelement(addnew);
		actionutil.clickOnElement(addtran, "Add Transaction is selected");
	}

	public void transactionobssscc() throws InterruptedException, IOException {
		/***
		 * code to work single
		 */

		
		
		  actionutil.clickOnElement(trace, "click on trace"); Thread.sleep(4000);
		  actionutil.scrollDowntoelement(transaction); Thread.sleep(2000);
		  actionutil.clickOnElement(transaction, "transaction is clicked");
		  Thread.sleep(5000);
		 

		Thread.sleep(8000);
		actionutil.clickOnElement(existingproductid, "productid is selected");
		String copyvalue1 = copyvalue();
		actionutil.typeText(existingproductid, copyvalue1, "enter the productid");
		actionutil.clickOnElement(existingproductid, "productid is selected");
		actionutil.clickOnElement(existingproductsearch, "search is selected");
		actionutil.clickOnElement(searchbutton, "search button is clicked");
		Thread.sleep(2000);
		String lotvalue = lotelement.getText();
		System.out.println("Print the value :" + " " + lotvalue);
		actionutil.scrollUp();
		Thread.sleep(2000);
		actionutil.scrollUp();
		actionutil.clickOnElement(addnew, "add new is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(productidtext, "Product id is clicked");
		Thread.sleep(2000);
		actionutil.typeText(productidtext, copyvalue1, "Saved Value is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(productidtext, "Product id is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(productidsearchbox, "Product id is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(chooseprocess, "chooseprocess id is clicked");
		Thread.sleep(2000);
		actionutil.typeText(chooseprocess, "Packing", "Packing/aggregation is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(chooseprocess, "chooseprocess id is clicked");
		Thread.sleep(4000);
		actionutil.clickOnElement(processselectcomm, "Process aggre is selected");
		Thread.sleep(2000);
		actionutil.scrollDown();
		actionutil.clickOnElement(org, "org is selected");
		Thread.sleep(2000);
		actionutil.typeText(org, "178", "org value is entered");
		Thread.sleep(5000);
		actionutil.clickOnElement(orgselect, "org is selected");
		Thread.sleep(2000);
		actionutil.clickOnElement(location, "location is selected");
		actionutil.typeText(location, "test", "location value is entered");
		Thread.sleep(5000);
		actionutil.clickOnElement(locationselect, "location is selected");
		actionutil.scrollDown();
		// actionutil.scrollDowntoelement(activity1);
		actionutil.clickOnElement(activity1, "activity is clicked");
		Thread.sleep(2000);
		actionutil.typeText(activity1, "activity", "activity is entered");
		Thread.sleep(3000);
		actionutil.scrollDown();
		Thread.sleep(3000);
		actionutil.scrollDown();
		// actionutil.scrollDowntoelement(lot1);
		actionutil.clickOnElement(lot1, "lot1 is clicked");
		Thread.sleep(2000);
		actionutil.typeText(lot1, lotvalue, "lotvalue is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(lotarrow, "lot arrow is clicked");
		Thread.sleep(2000);
		actionutil.scrollDown();
		Thread.sleep(2000);
		actionutil.scrollDown();
		Thread.sleep(2000);
		actionutil.scrollDown();
		Thread.sleep(2000);
		actionutil.clickOnElement(ssccimg, "sscc number is copied");
		Thread.sleep(2000);
		String copiedTextsscc = actionutil.getClipboardContents();
		Thread.sleep(2000);
		System.out.println("Print the value of sscc: " + " " + copiedTextsscc);
		Thread.sleep(8000);

		/*
		 * actionutil.typeText(chooseprocess, "Observation", "Observation is entered");
		 * Thread.sleep(2000); actionutil.clickOnElement(processselectobs,
		 * "Process obs is selected"); Thread.sleep(2000); actionutil.scrollDown();
		 * actionutil.clickOnElement(org, "org is selected"); Thread.sleep(2000);
		 * actionutil.typeText(org, "178", "org value is entered"); Thread.sleep(5000);
		 * actionutil.clickOnElement(orgselect, "org is selected"); Thread.sleep(2000);
		 * actionutil.clickOnElement(location, "location is selected");
		 * actionutil.typeText(location, "test", "location value is entered");
		 * Thread.sleep(5000); actionutil.clickOnElement(locationselect,
		 * "location is selected"); actionutil.scrollDown(); //
		 * actionutil.scrollDowntoelement(activity1);
		 * actionutil.clickOnElement(activity1, "activity is clicked");
		 * Thread.sleep(2000); actionutil.typeText(activity1, "activity",
		 * "activity is entered"); Thread.sleep(3000); actionutil.scrollDown();
		 * Thread.sleep(3000); actionutil.scrollDown();
		 * //actionutil.scrollDowntoelement(lot1); actionutil.clickOnElement(lot1,
		 * "lot1 is clicked"); Thread.sleep(2000); // actionutil.typeText(lot1,
		 * lotvalue, "lotvalue is entered"); Thread.sleep(2000);
		 * actionutil.clickOnElement(lotarrow, "lot arrow is clicked");
		 * Thread.sleep(8000); // actionutil.scrollDown(); //Thread.sleep(3000); //
		 * actionutil.scrollDown(); actionutil.scrollToElement1(invoice,
		 * "asset is clicked"); // actionutil.scrollDowntoelement(asset);
		 * actionutil.clickOnElement(asset, "asset is clicked"); Thread.sleep(2000);
		 * actionutil.typeText(asset, "vehicle", "vehicle is entered");
		 * Thread.sleep(4000); actionutil.clickOnElement(assetselect,
		 * "assetsearch is clicked"); Thread.sleep(2000);
		 * actionutil.clickOnElement(shippingdate, "shippingdate is clicked");
		 * Thread.sleep(2000); actionutil.clickOnElement(datenextbutton,
		 * "datenext button is clicked"); Thread.sleep(2000);
		 * actionutil.clickOnElement(dateselect, "date is entered"); Thread.sleep(3000);
		 * actionutil.clickOnElement(okbutton, "date is selected"); Thread.sleep(3000);
		 * actionutil.clickOnElement(deliverydate, "deliverydate is clicked");
		 * Thread.sleep(2000); actionutil.clickOnElement(datenextbutton1,
		 * "datenext button is clicked"); Thread.sleep(2000);
		 * actionutil.clickOnElement(datenextbutton1, "datenext button is clicked");
		 * Thread.sleep(3000); actionutil.clickOnElement(dateselect1,
		 * "date is entered"); Thread.sleep(2000); actionutil.clickOnElement(okbutton1,
		 * "date is selected"); //actionutil.scrollDowntoelement(container);
		 * actionutil.scrollDown(); actionutil.clickOnElement(container,
		 * "container is clicked"); actionutil.typeText(container, "test",
		 * "container value is entered"); Thread.sleep(5000);
		 * actionutil.clickOnElement(containerselect, "container select is clicked");
		 * Thread.sleep(2000); actionutil.clickOnElement(invoice,
		 * "invoice select is clicked"); actionutil.typeText(invoice, "123",
		 * " invoice value is entered"); Thread.sleep(2000);
		 * actionutil.clickOnElement(seal, "seal select is clicked");
		 * actionutil.typeText(seal, "123", "seal value is entered");
		 * Thread.sleep(2000); actionutil.scrollDown(); actionutil.clickOnElement(asn,
		 * "asn select is clicked"); actionutil.typeText(asn, "123",
		 * "asn value is entered"); Thread.sleep(2000); actionutil.clickOnElement(lorry,
		 * "lorry select is clicked"); actionutil.typeText(lorry, "123",
		 * "lorry value is entered"); Thread.sleep(2000);
		 * actionutil.scrollDownToBottom(); //actionutil.scrollToElement(purchase,
		 * "pruchase is scrolled"); actionutil.clickOnElement(purchase,
		 * "purchase is clicked"); actionutil.typeText(purchase, "123",
		 * "purchase is entered"); actionutil.clickOnElement(bill, "bill is clicked");
		 * actionutil.typeText(bill, "12345", "purchase is entered");
		 * actionutil.scrollDownToBottom(); // actionutil.scrollDowntoelement(addnew);
		 * actionutil.clickOnElement(addtran, "Add Transaction is selected");
		 */
	}
}