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
import java.util.Set;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demo.baseutil.Basetest;
import com.demo.util.WebActionUtil;

public class Tracetransactionsupplier {
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
	public static String filePath = userDir + "\\src\\test\\resources\\data\\NewProduct.txt";
	public static String filePath1 = userDir + "\\src\\test\\resources\\data\\sscc.txt";
	String imageaddress = "C:\\Users\\Deepti Jindal\\eclipse-workspace\\com.NFR.Trace\\src\\test\\resources\\data\\img.jpg";
	public static String line;
	// public static int lineNumber = 1; // Change this to the line number you want
	// to read
	public static long lineNumber = 0;
	public static int currentLine = 1;
	public static String savedValue = null;
	public static String datevalue = "03/31/2024";
	public static String lot;
	public static String copiedTextsscc;

	public Tracetransactionsupplier(WebDriver driver, long eto, WebActionUtil actionutil) {
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
	// @FindBy(xpath = "//*[@id='prod_id__add_transactions']")
	@FindBy(xpath = "(//input[@type= 'search' ])[2]")

	private WebElement productidtext;

	/* X-path for existing Product id */
	// @FindBy(xpath = "//*[@id='prod_id__add_transactions']")
	@FindBy(xpath = "//div[@class='ant-select-selection-overflow']")

	private WebElement productidtext1;

	/* X-path for product id search box */
	@FindBy(xpath = "//*[@id='productSearch_0']")
	private WebElement productidsearchbox;

	/* X-path for choose process */
	@FindBy(xpath = "(//input[@type='search'])[3]")
	private WebElement chooseprocess;
	// *[@id="root"]/div/div[5]/form/div[4]/div[1]/div/div[2]

	/* X-path for choose process */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[5]/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/ul")
	private WebElement chooseprocess1;
	// *[@id="root"]/div/div[5]/form/div[4]/div[1]/div/div[2]

	/* X-path for add new */
	@FindBy(xpath = "//*[@id='ADD_NEW_TRANSACTION']")
	private WebElement addnew;

	/* X-path for add new */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[5]/div[2]/div/form/div/div/div/div/div[1]/div/div")
	private WebElement CTE;
	// input[@class='ant-select-selection-search-input']

	/* X-path for add new */
	@FindBy(xpath = "//div[@class='ant-select-item-option-content' and text()='Commission']")
	private WebElement CTEcomm;

	/* X-path for add new */
	@FindBy(xpath = "(//div[contains(text(),'Aggregation')])[1]")
	private WebElement CTEagg;

	/* X-path for add new */
	@FindBy(xpath = "(//div[contains(text(),'Shipping')])[1]")
	private WebElement CTEship;

	/* X-path for add new */
	@FindBy(xpath = "//input[@id='vehicleSearch']")
	private WebElement clickveh;

	/* X-path for add new */
	@FindBy(xpath = "//div[@id='vehicleSearch_0']")
	private WebElement selectveh;

	// input[@id='vehicleSearch']

	/* X-path for add new */
	@FindBy(xpath = "(//div[contains(text(),'Observation')])[1]")
	private WebElement CTEobs;

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
	// @FindBy(xpath =
	// "//*[@id='root']/div/div[6]/div/div[5]/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/ul")
	@FindBy(xpath = "//*/body/div[4]/div/div/div[2]/div/div/div/div/div/div")
	/// html/body/div[4]/div/div/div[2]/div/div/div/div/div/div
	private WebElement processselectcomm;

	/* X-path for Add Transaction */
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;

	/* X-path for Add Transaction */
	@FindBy(xpath = "//button[@id='fileUpload_add_transactions']")
	private WebElement upload;

	/* X-path for Add Transaction */
	@FindBy(xpath = "//button[@id='add_transactions_add_button']")
	private WebElement addtran;

	/* X-path for activity */
	@FindBy(xpath = "//*[@id='add_transactions_why_input']")
	private WebElement activity;

	/* X-path for activity */
	@FindBy(xpath = "(//*[@id='add_transactions_who_gln_input'])[1]")
	private WebElement locfirst;

	/* X-path for activity */
	@FindBy(xpath = "//*[@id='add_transactions_who_gln_input_0']")
	private WebElement locfirstval;

	/* X-path for sscc */
	@FindBy(xpath = "//*[@id='add_transactions_observation_lgtin']")
	private WebElement sscc;

	/* X-path for sscc */
	@FindBy(xpath = "//input[@name='SSCC']")
	private WebElement sscc1;

	/* X-path for sscc arrow */
	@FindBy(xpath = "//*[@id='observation_sscc_arrow_button']")
	private WebElement ssccarrow;

	/* X-path for date */
	@FindBy(xpath = "//*[@id='add_transactions_who_gln_input']")
	private WebElement loc;

	/* X-path for date */
	@FindBy(xpath = "//*[@id='add_transactions_who_gln_input_0']")
	private WebElement locvalue;

	/* X-path for date */
	@FindBy(xpath = "//*[@class='ant-picker-input']")
	private WebElement date;

	/* X-path for date */
	@FindBy(xpath = "(//*[@class='ant-picker-input'])[1]")
	private WebElement date1;
	/* X-path for date */
	@FindBy(xpath = "(//*[@class='ant-picker-input'])[2]")
	private WebElement date2;

	/* X-path for packing type dropdown */
	// @FindBy(xpath = "//*[@id='PackagingType']")
	@FindBy(xpath = "//input[@id='PackagingType_add_transactions']")

	private WebElement packingtype;

	/* X-path for packing type dropdown value */
	@FindBy(xpath = "//*[@id='PackagingType_add_transactions_0']")
	// @FindBy(xpath = "//*[@id='undefined_0']")
	private WebElement packingtypeselect;

	/* X-path for packing type date next button */
	@FindBy(xpath = "//button[@class='ant-picker-header-next-btn']")
	private WebElement datenextbutton;

	/* X-path for packing type date next button */
	@FindBy(xpath = "(//button[@class='ant-picker-header-next-btn'])[2]")
	private WebElement datenextbuttondel;

	// button[@class='ant-picker-header-next-btn']
	// */div[5]/div/div/div/div/div[1]/div/div[1]/div[1]/button[3]

	/* X-path for packing type date next button */
	@FindBy(xpath = "(//button[@class='ant-picker-header-super-next-btn'])[2]")
	private WebElement datenextbuttonnew;

	/* X-path for packing type date next button */
	@FindBy(xpath = "//*/body/div[3]/div/div/div/div/div[1]/div/div[1]/div[1]/button[3]")
	private WebElement datenextbutton1;

	@FindBy(xpath = "//*/body/div[4]/div/div/div/div/div[1]/div/div[1]/div[1]/button[3]")
	private WebElement datenextbutton1new;

	/* X-path for packing type dropdown value */
	@FindBy(xpath = "//tr[3]/td[5]/div[@class='ant-picker-cell-inner']")
	private WebElement dateselect;

	/* X-path for packing type dropdown value */
	@FindBy(xpath = "(//tr[3]/td[5]/div[@class='ant-picker-cell-inner'])[2]")
	private WebElement dateselect1;

	/* X-path for ok button */
	@FindBy(xpath = "//button/span[contains(text(), 'OK')]")
	private WebElement okbutton;

	/* X-path for ok button */
	@FindBy(xpath = "(//button/span[contains(text(), 'OK')])[2]")
	private WebElement okbuttondel;

	/* X-path for ok button */
	@FindBy(xpath = "//*/div[3]/div/div/div/div/div[2]/ul/li/button")
	private WebElement okbuttonnew;

	/* X-path for ok button */
	@FindBy(xpath = "(//button/span[contains(text(),'OK')])[2]")
	private WebElement okbutton1;

	/* X-path for ok button */
	@FindBy(xpath = "//*/div[4]/div/div/div/div/div[2]/ul/li/button")
	private WebElement okbutton1new;
	/* X-path for lot number */
	@FindBy(xpath = "//*[@id='add_transactions_commission_LGTIN']")
	private WebElement lotnumber;

	/* X-path for existing productid */
	// @FindBy(xpath = "//*[@id='prod_id_undefined']")
	@FindBy(xpath = "//input[@class='ant-select-selection-search-input']")
	// input[@class='ant-select-selection-search-input']
	private WebElement existingproductid;

	/* X-path for existing product search */
	// @FindBy(xpath =
	// "//*[@id='root']/div/div[6]/div/div[5]/div[1]/div/div/div/div/div[2]/div/div/div[2]/ul")
	@FindBy(xpath = "//div[@class='product-label']")

	private WebElement existingproductsearch;

	/* X-path for existing search button */
	@FindBy(xpath = "//*[@id='transactions_search_button']")
	private WebElement searchbutton;

	/* X-path for lot value */
	@FindBy(xpath = "//table/tbody/tr[1]/th[2]")
	private WebElement lotelement;

	/* X-path for organisation */
	// @FindBy(xpath = "//*[@id='myForm']/div[1]/div[2]/div/div/div/div/input")
	@FindBy(xpath = "//input[@id='organizationSearch']")
	private WebElement org;

	/* X-path for organisation select */
	@FindBy(xpath = "//*[@class='organization-label']")
	// @FindBy(xpath = "//*[@id='myForm']/div[1]/div[2]/div/div/div[2]/ul/li")
	private WebElement orgselect;

	/* X-path for location */
	@FindBy(xpath = "//*[@id='myForm']/div[1]/div[3]/div/div/div[1]/div/input")
	private WebElement location;

	/* X-path for packing location */
	@FindBy(xpath = "//input[contains(@name, 'TLC_PackingLocation')]")
	private WebElement packloc;

	/* X-path for Remarks */
	@FindBy(xpath = "//input[contains(@name, 'Remarks')]")
	private WebElement remarks;

	/* X-path for TLC loc */
	@FindBy(xpath = "//input[contains(@name, 'TLC_SourceReference')]")
	private WebElement tlcloc;

	/* X-path for TLC loc */
	@FindBy(xpath = "//input[@id='add_transactions_shipping_tlcNo']")
	private WebElement tlcnumber;

	/* X-path for TLC loc */
	@FindBy(xpath = "//*[@id='add_transactions_shipping_BatchLotLGTIN']")
	private WebElement lotno;

	/* X-path for TLC loc */
	@FindBy(xpath = "//*[@id='add_transactions_shipping_BatchLotLGTIN_0']")
	private WebElement lotnoselect;

	/* X-path for TLC loc */
	@FindBy(xpath = "//input[@id='add_transactions_shipping_deliveryDate']")
	private WebElement deldate;

	/* X-path for TLC loc */
	@FindBy(xpath = "//input[@id='add_transactions_shipping_productionLotNo']")
	private WebElement prodlotno;

	/* X-path for TLC loc */
	@FindBy(xpath = "//*[@id='add_transactions_shipping_organization']")
	private WebElement orgnew;

	/* X-path for TLC loc */
	@FindBy(xpath = "//*[@id='add_transactions_shipping_organization_0']")
	private WebElement orgnewselect;

	/* X-path for TLC loc */
	@FindBy(xpath = "//input[@id='add_transactions_shipping_gln']")
	private WebElement gln;

	/* X-path for TLC loc */
	@FindBy(xpath = "//ul[contains(@class, 'CustomSelectInput_customSelectInputOptionsList')]")
	private WebElement glnselect;

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
	@FindBy(xpath = "//*[@id='ShippingDate&Time_add_transactions']")
	private WebElement shippingdate;

	/* X-path for deliverydate */
	@FindBy(xpath = "//*[@id='DeliveryDateTime_add_transactions']")
	private WebElement deliverydate;

	/* X-path for container */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[7]/div/div/div/input")
	private WebElement container;

	/* X-path for container */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[7]/div/div[2]/ul")
	private WebElement containerselect;

	/* X-path for purchase */
	@FindBy(xpath = "//input[@name='purchaseOrderNo']")
	private WebElement purchase;

	/* X-path for bill */
	@FindBy(xpath = "//input[@name='billOfLadingNo']")
	private WebElement bill;

	/* X-path for lot arrow */
	@FindBy(xpath = "//*[@id='aggregation_lgtin_arrow_button0']")
	private WebElement lotarrow;

	/* X-path for lot invoice */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[8]/div[2]/input")
	private WebElement invoice;

	/* X-path for lot invoice */
	@FindBy(xpath = "//input[contains(@name, 'CommodityVarietyOfTheProduct')]")
	private WebElement comm;

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

	/* X-path for tlc */
	@FindBy(xpath = "//input[@id='add_transactions_commission_TLC_Number']")
	private WebElement tlc;

	/* X-path for Location */
	@FindBy(xpath = "//input[@id='add_transactions_commission_LocationOfImmediateEvent']")
	private WebElement Location;

	/* X-path for commodity */
	@FindBy(xpath = "//input[@name='CommodityVarietyOfTheProduct']")
	private WebElement commodity;

	/* X-path for field */
	@FindBy(xpath = "//input[@name='FieldOrFoodGrowingAreaName']")
	private WebElement field;

	/* X-path for container */
	// @FindBy(xpath =
	// "//*[@id='myForm']/div[4]/div/div/div[19]/div/div[1]/div/input")
	// @FindBy(xpath =
	// "(//input[@id='add_transactions_aggregation_containerId'])[1]")
	@FindBy(xpath = "//input[@id='containerName_add_transactions']")
	private WebElement Container;

	/* X-path for containervalue */
	@FindBy(xpath = "//*[@id='containerName_add_transactions_0']")
	private WebElement Containervalue;

	/* X-path for document */
	@FindBy(xpath = "//input[@name='DocumentReferenceNo']")
	private WebElement document;

	/* X-path for document */
	@FindBy(xpath = "(//input[@id='add_transactions_shipping_driver'])[1]")
	private WebElement drivername;

	/* X-path for document */
	@FindBy(xpath = "//li[@id='add_transactions_shipping_driver_0']")
	private WebElement drivernameselect;

	/* X-path for document */
	@FindBy(xpath = "(//input[@id='add_transactions_shipping_productId'])[1]")
	private WebElement prodidselect;

	/* X-path for document */
	@FindBy(xpath = "(//li[@id='add_transactions_shipping_productId_0'])[1]")
	private WebElement prodidselectvalue;

	/* X-path for document */
	@FindBy(xpath = "//textarea[@id='remarks']")
	private WebElement textarea;

	/* X-path for document */
	@FindBy(xpath = "//button[@id='e_signature_btn']")
	private WebElement addsign;

	/* X-path for document */
	@FindBy(xpath = "//div[@id='rc-tabs-0-tab-2']")
	private WebElement addtype;

	/* X-path for document */
	@FindBy(xpath = "//input[@id='basic_sign']")
	private WebElement addsigntext;

	/* X-path for document */
	@FindBy(xpath = "(//button[contains(text(),'Submit')])[3]")
	private WebElement addsignsubmit;

	/* X-path for document */
	@FindBy(xpath = "//input[@name='documentReferenceNo']")
	private WebElement document1;

	/* X-path for itemsgtin */
	@FindBy(xpath = "(//input[@id='UoMSGTIN_add_transactions'])[1]")
	private WebElement itemsgtin;

	/* X-path for itemsgtin */
	@FindBy(xpath = "//div[contains(text() ,'kgs')]")
	private WebElement itemsgtinvalue;

	/* X-path for itemsgtin */
	@FindBy(xpath = "(//input[@id='add_transactions_commission_DIMENSIONS'])[1]")
	private WebElement dim;

	/* X-path for weightsgtin */
	@FindBy(xpath = "//input[@name='WeightPerSGTIN']")
	private WebElement weightsgtin;

	/* X-path for countsgtin */
	@FindBy(xpath = "//input[@name='CountOfSGTIN']")
	private WebElement countsgtin;

	public static String copyvalue() throws FileNotFoundException {
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

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

	public static String copyvaluesscc() throws FileNotFoundException {
		FileReader fileReader = new FileReader(filePath1);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader(filePath1))) {
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
		Thread.sleep(2000);

		Thread.sleep(8000);
		Traceassetcontainer textnew = new Traceassetcontainer(driver, eto, actionutil);
		textnew.assets();
		// actionutil.clickOnElement(trace, "click on trace");
		Thread.sleep(3000);
		actionutil.scrollToElement(transaction, "transaction");
		actionutil.clickOnElement(transaction, "transaction is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(addnew, "add new is clicked");
		driver.navigate().refresh();
		// js.executeScript("localStorage.setItem('businessinfo', arguments[0]);",
		// businessInfo);
		// driver.navigate().refresh();
		Thread.sleep(5000);
		actionutil.clickOnElement(CTE, "clicked on CTE");
		Thread.sleep(4000);
		actionutil.clickOnElement(CTEcomm, "clicked on CTE comm");
		Thread.sleep(2000);
		actionutil.clickOnElement(productidtext, "Product id is clicked");
		Thread.sleep(5000);
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
		// actionutil.clickOnElement(chooseprocess, "chooseprocess id is clicked");
		// Thread.sleep(3000);
		// actionutil.scrollDown();
		actionutil.clickOnElement(processselectcomm, "Process commision is selected");
		Thread.sleep(2000);
		actionutil.clickOnElement(submit, "click on submit button");
		Thread.sleep(2000);
		// driver.navigate().refresh();
		actionutil.scrollDown();
		Thread.sleep(2000);
		// actionutil.clickOnElement(loc, "loc is selected");
		// actionutil.typeText(loc, "9650541994", "loc Value is entered");
		// Thread.sleep(2000);
		// actionutil.clickOnElement(locvalue, "locvalue is selected");
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
		// actionutil.scrollDowntoelement(packingtype);
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
		String text = textnew.getconatiner();
		actionutil.typeText(Container, text, "filed is entered");
		Thread.sleep(4000);
		actionutil.clickOnElement(Containervalue, "Selected the container");
		Thread.sleep(1000);
		actionutil.clickOnElement(countsgtin, "count sgtin is clicked");
		actionutil.typeText(countsgtin, "123", "countsgtin is entered");
		actionutil.clickOnElement(weightsgtin, "weightsgtin sgtin is clicked");
		actionutil.typeText(weightsgtin, "1234567", "weightsgtin is entered");
		//// actionutil.clickOnElement(dim, "dim is clicked");
		// actionutil.typeText(dim, "1234567", "dim is entered");
		actionutil.clickOnElement(itemsgtin, "itemsgtin sgtin is clicked");
		actionutil.clickOnElement(itemsgtinvalue, "itemgtin is entered");
		actionutil.clickOnElement(document, "document is clicked");
		actionutil.typeText(document, "1234567", "document is entered");
		actionutil.scrollDownToBottom();
		actionutil.scrollDowntoelement(document);
		actionutil.clickOnElement(addtran, "Add Transaction is selected");
		System.out.println("commision is passed::");
		Thread.sleep(8000);

	}

	public void transactionagg() throws InterruptedException, IOException {

		/***
		 * code to work single
		 */

		Thread.sleep(8000);
		actionutil.clickOnElement(trace, "click on trace");
		 Thread.sleep(4000);
		 Traceassetcontainer textnew1 = new Traceassetcontainer(driver, eto, actionutil);
		textnew1.assets();
		Thread.sleep(6000);

		// actionutil.clickOnElement(trace, "click on trace"); Thread.sleep(4000);

		actionutil.scrollDowntoelement(transaction);
		Thread.sleep(2000);
		actionutil.clickOnElement(transaction, "transaction is clicked");
		Thread.sleep(5000);

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
		Thread.sleep(4000);
		actionutil.clickOnElement(transaction, "transaction is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(addnew, "add new is clicked");
		Thread.sleep(5000);

		actionutil.clickOnElement(CTE, "clicked on CTE");
		Thread.sleep(4000);
		actionutil.clickOnElement(CTEagg, "clicked on CTEagg comm");
		Thread.sleep(2000);
		actionutil.clickOnElement(productidtext, "Product id is clicked");
		Thread.sleep(2000);
		String copyvalue2 = copyvalue();
		actionutil.typeText(productidtext, copyvalue2, "Saved Value is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(productidtext, "Product id is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(productidsearchbox, "Product id is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(chooseprocess, "chooseprocess id is clicked");
		Thread.sleep(2000);
		actionutil.typeText(chooseprocess, "Packing", "Harvestiong/commission is entered");
		Thread.sleep(2000);
		// actionutil.clickOnElement(chooseprocess, "chooseprocess id is clicked");
		// Thread.sleep(3000);
		// actionutil.scrollDown();
		actionutil.clickOnElement(processselectcomm, "Process commision is selected");
		Thread.sleep(2000);
		actionutil.clickOnElement(submit, "click on submit button");
		Thread.sleep(2000);

		actionutil.scrollDown();
		// actionutil.clickOnElement(org, "org is selected");
		// Thread.sleep(2000);
		actionutil.typeText(org, "178", "org value is entered");
		Thread.sleep(10000);
		actionutil.clickOnElement(orgselect, "org is selected");
		Thread.sleep(3000);
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
		actionutil.scrollToElement(lot1, "scrolles to lot");
		actionutil.clickOnElement(ssccimg, "sscc number is copied");
		Thread.sleep(2000);
		copiedTextsscc = actionutil.getClipboardContents();
		Thread.sleep(2000);
		System.out.println("Print the value of sscc: " + " " + copiedTextsscc);
		String savedinfile = " sscc sup id:   " + copiedTextsscc;
		System.out.println(" Print the value of saved" + "  " + copiedTextsscc);

		// String filePath = "/path/to/your/file.txt";

		// Initialize FileWriter in append mode
		FileWriter writer = new FileWriter(filePath1, true);
		writer.write(savedinfile + "\n"); // Write the first value
		writer.write(copiedTextsscc + "\n"); // Write the first value
		writer.close();

		Thread.sleep(5000);
		actionutil.scrollUptoelement(activity1, "The lot is displayed after scroll up");
		Thread.sleep(3000);
		actionutil.clickOnElement(lot1, "lot1 is clicked");
		Thread.sleep(2000);
		actionutil.typeText(lot1, lotvalue, "lotvalue is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(lotarrow, "lot arrow is clicked");
		Thread.sleep(2000);
		actionutil.scrollToElement(packloc, "scrolled to packloc");
		Thread.sleep(5000);
		actionutil.scrollUptoelement(comm, "The packloc is displayed after scroll up");
		Thread.sleep(5000);
		actionutil.clickOnElement(packloc, "packloc is clicked");
		Thread.sleep(2000);
		actionutil.typeText(packloc, "test", "packing lot is entered");
		Thread.sleep(4000);
		actionutil.clickOnElement(remarks, "remarks is clicked");
		Thread.sleep(2000);
		actionutil.typeText(remarks, "test", "remarks is entered");
		Thread.sleep(4000);
		actionutil.clickOnElement(tlcloc, "tlcloc is clicked");
		Thread.sleep(2000);
		actionutil.typeText(tlcloc, "test", "tlcloc is entered");
		Thread.sleep(4000);
		actionutil.scrollToElement(asset, "asset is scroll down");
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
		actionutil.clickOnElement(datenextbuttonnew, "datenext button is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(datenextbuttonnew, "datenext button is clicked");
		Thread.sleep(3000);
		actionutil.clickOnElement(dateselect1, "date is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(okbutton1, "date is selected");
		actionutil.scrollDown();
		String text1 = textnew1.getconatiner();
		actionutil.clickOnElement(container, "container is clicked");
	actionutil.typeText(container, text1, "container value is entered");
		Thread.sleep(5000);
		actionutil.clickOnElement(containerselect, "container select is clicked");
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		actionutil.clickOnElement(document1, "document is clicked");
		actionutil.typeText(document1, "12345", "document is entered");
		Thread.sleep(2000);
		actionutil.scrollDownToBottom();
		// actionutil.scrollDowntoelement(addnew);

		actionutil.clickOnElement(addtran, "Add Transaction is selected");
		Thread.sleep(10000);
	}

	public void transactionobssscc() throws InterruptedException, IOException {
		/***
		 * code to work single
		 */
		Thread.sleep(8000);
		// actionutil.clickOnElement(trace,"click on trace"); Thread.sleep(4000);
		actionutil.scrollDowntoelement(transaction);
		Thread.sleep(2000);

		// Thread.sleep(5000);
		// actionutil.scrollToElement(transaction, "scrolled to transaction");
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
		Thread.sleep(5000);
		actionutil.clickOnElement(productidsearchbox, "Product id is clicked");
		Thread.sleep(2000);

		actionutil.clickOnElement(chooseprocess, "chooseprocess id is clicked");
		Thread.sleep(5000);
		actionutil.typeText(chooseprocess, "Observation", "Observation is entered");
		Thread.sleep(6000);
		actionutil.clickOnElement(chooseprocess1, "chooseprocess id is clicked");
		Thread.sleep(6000);
		// actionutil.clickOnElement(processselectobs,"Process obs is selected");
		// Thread.sleep(2000);
		actionutil.clickOnElement(activity1, "activity is clicked");
		Thread.sleep(2000);
		actionutil.typeText(activity1, "activity", "activity is entered");
		Thread.sleep(3000);
		// actionutil.scrollDownToBottom();
		actionutil.scrollToElement(addtran, "sscc is scrolled down");
		Thread.sleep(3000);
		actionutil.clickOnElement(sscc1, "sscc is clicked");
		Thread.sleep(2000);
		String ssccvalue = copyvaluesscc();
		// actionutil.typeText(sscc1, copiedTextsscc, "sscc is entered");
		actionutil.typeText(sscc1, ssccvalue, "sscc is entered");
		Thread.sleep(3000);
		actionutil.clickOnElement(ssccarrow, "sscc arrow is clicked");
		Thread.sleep(2000);

		// actionutil.scrollToElement(purchase, "pruchase is scrolled");
		// actionutil.clickOnElement(purchase,"purchase is clicked");
		// actionutil.typeText(purchase, "123", "purchase is entered");
		// actionutil.clickOnElement(bill, "bill is clicked");
		// actionutil.typeText(bill, "12345", "purchase is entered");
		// actionutil.scrollDownToBottom(); // actionutil.scrollDowntoelement(addnew);
		actionutil.scrollToElement(addtran, "addd transaction button scrolled");
		actionutil.clickOnElement(addtran, "Add Transaction is selected");
		Thread.sleep(10000);
	}

	public void transactionshipping() throws InterruptedException, IOException {

		/***
		 * code to work single
		 */
		Thread.sleep(8000);
		actionutil.clickOnElement(trace, "click on trace");
		Thread.sleep(5000);
		Tracedrivers textnew = new Tracedrivers(driver, eto, actionutil);
		textnew.adddriver();

		Thread.sleep(8000);
		actionutil.scrollDowntoelement(transaction);
		Thread.sleep(2000);
		actionutil.clickOnElement(transaction, "transaction is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(addnew, "add new is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(CTE, "clicked on CTE");
		Thread.sleep(4000);
		actionutil.clickOnElement(CTEship, "clicked on CTEagg comm");
		Thread.sleep(2000);
		actionutil.clickOnElement(clickveh, "clicked the vehicle");
		Thread.sleep(2000);
		actionutil.clickOnElement(selectveh, "select the vehicle");
		Thread.sleep(2000);
		actionutil.clickOnElement(productidtext1, "Product id is clicked");
		Thread.sleep(12000);
		// actionutil.typeText(productidtext1, "F2PG10002704", "Enetered the
		// productid");
		// Thread.sleep(2000);
		Actions actions = new Actions(driver);

		String copyvalue2 = copyvalue();
		actions.click(productidtext1).sendKeys(copyvalue2).perform();
		// actionutil.typeText(productidtext1, copyvalue2, "Saved Value is entered");
		Thread.sleep(5000);
		// actionutil.clickOnElement(productidtext1, "Product id is clicked");
		// Thread.sleep(2000);
		actionutil.clickOnElement(productidsearchbox, "Product id is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(submit, "click on submit button");
		Thread.sleep(4000);
		actionutil.scrollDown();
		actionutil.clickOnElement(locfirst, "clicked on location");
		actionutil.typeText(locfirst, "test", "entered the location");
		Thread.sleep(2000);
		actionutil.clickOnElement(locfirstval, "clicked on location value");
		actionutil.clickOnElement(activity, "click on activity");
		actionutil.typeText(activity, "abcd", "entered the activity");
		Thread.sleep(2000);
		actionutil.scrollDown();
		actionutil.scrollDown();

		actionutil.clickOnElement(date1, "click on date1");
		Thread.sleep(2000);
		actionutil.clickOnElement(datenextbutton, "click on datenextbutton");
		Thread.sleep(2000);
		actionutil.clickOnElement(dateselect, "click on dateselect");
		Thread.sleep(2000);
		actionutil.clickOnElement(okbutton, "click on Ok Button");
		Thread.sleep(2000);
		actionutil.scrollDown();
		actionutil.clickOnElement(upload, "upload is selected");
		Thread.sleep(2000);
		StringSelection ss = new StringSelection(imageaddress1);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		try {
			Robot robot = new Robot();

			// Pressing Enter key to focus on Window
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			// Pressing CTRL+V keys to paste the copied file path
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			// Pressing Enter key to upload the file
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// upload.sendKeys(imageaddress);
		actionutil.scrollToElement(upload, "scrolled to upload");
		Thread.sleep(2000);
		actionutil.clickOnElement(drivername, "drivername is clicked");
		Thread.sleep(2000);
		actionutil.typeText(drivername, "driver", "driver name is entered");
		Thread.sleep(4000);
		// String text = textnew.getconatiner();
		// actionutil.typeText(Container, text, "filed is entered");
		actionutil.clickOnElement(drivernameselect, "drivernameselect is selected");
		Thread.sleep(2000);
		actionutil.clickOnElement(prodidselect, "click on prodidselect");
		Thread.sleep(3000);
		// actionutil.typeText(prodidselect, "F2PG10002704", "prod id is entered");
		// Thread.sleep(2000);
		actionutil.clickOnElement(prodidselectvalue, "click on prodidselectvalue");
		Thread.sleep(3000);
		actionutil.clickOnElement(tlcnumber, "click on tlcnumber");
		Thread.sleep(3000);
		actionutil.typeText(tlcnumber, "1234", "Entered the tlcnumber");
		Thread.sleep(3000);

		actionutil.clickOnElement(prodlotno, "clicked on production lot no");
		Thread.sleep(3000);
		actionutil.typeText(prodlotno, "12343234345", "Entered the production lotno");
		Thread.sleep(3000);

		actionutil.clickOnElement(lotno, "clicked on lot no");
		Thread.sleep(3000);
		// actionutil.typeText(lotno, "1691004122410000002", "Entered the lotno");
		// Thread.sleep(3000);
		actionutil.clickOnElement(lotnoselect, copiedTextsscc);
		Thread.sleep(2000);
		actionutil.scrollUptoelement(deldate, "scrolled to up");
		Thread.sleep(2000);
		actionutil.clickOnElement(deldate, "deldate is clicked:");
		actionutil.clickOnElement(datenextbuttondel, "datenextbuttondel is clicked");
		actionutil.clickOnElement(datenextbuttondel, "datenextbuttondel is clicked");
		actionutil.clickOnElement(dateselect1, "dateselect1 is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(okbuttondel, "clicked on okbutton");
		Thread.sleep(2000);
		actionutil.clickOnElement(orgnew, "clicked on orgnew");
		Thread.sleep(3000);
		actionutil.typeText(orgnew, "178", "Entered the orgnew");
		Thread.sleep(3000);
		actionutil.clickOnElement(orgnewselect, "clicked on orgnew select");
		Thread.sleep(3000);
		actionutil.scrollToElement(orgnew, "scrolled to orgnew");
		Thread.sleep(2000);

		actionutil.clickOnElement(gln, "clicked on gln");
		Thread.sleep(3000);
		actionutil.typeText(gln, "test", "Entered the gln");
		Thread.sleep(3000);
		actionutil.clickOnElement(glnselect, "clicked on gln select");
		Thread.sleep(3000);
		actionutil.scrollToElement(gln, "scrolled to textarea");
		Thread.sleep(2000);
		actionutil.clickOnElement(textarea, "clicked on text area");
		actionutil.typeText(textarea, "test", "Entered the text area");
		Thread.sleep(2000);
		actionutil.clickOnElement(addsign, "clicked on addsign");
		Thread.sleep(2000);
		actionutil.clickOnElement(addtype, "clicked on addtype");
		Thread.sleep(2000);
		actionutil.clickOnElement(addsigntext, "clicked on addsigntext");
		Thread.sleep(2000);
		actionutil.typeText(addsigntext, "test", "Entered the addsigntext");
		Thread.sleep(2000);
		actionutil.clickOnElement(addsignsubmit, "clicked on addsignsubmit");
		Thread.sleep(2000);

		actionutil.clickOnElement(addtran, "add transaction is clickec");
		Thread.sleep(18000);
		System.out.println("Process shipping is done.....");
		Thread.sleep(2000);
	}

}