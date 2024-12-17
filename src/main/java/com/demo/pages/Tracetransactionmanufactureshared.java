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

public class Tracetransactionmanufactureshared {
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
	public static String filePath = userDir + "\\src\\test\\resources\\data\\sscc.txt";
	public static String filePath1 = userDir + "\\src\\test\\resources\\data\\NewProduct.txt";
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
	
	public Tracetransactionmanufactureshared(WebDriver driver, long eto, WebActionUtil actionutil) {
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
//	@FindBy(xpath = "//*[@id='prod_id__add_transactions']")
	@FindBy(xpath = "(//input[@type= 'search' ])[2]")
	private WebElement productidtext;
	
	/* X-path for add new */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[5]/div[2]/div/form/div/div/div/div/div[1]/div/div")
	private WebElement CTE;
	//input[@class='ant-select-selection-search-input']
	
	/* X-path for add new */
	@FindBy(xpath = "//div[@class='ant-select-item-option-content' and text()='Commission']")
	private WebElement CTEcomm;
	
	/* X-path for add new */
	@FindBy(xpath = "(//div[contains(text(),'Aggregation')])[1]")
	private WebElement CTEagg;
	
	/* X-path for add new */
	@FindBy(xpath = "(//div[contains(text(),'Disaggregation')])[1]")
	private WebElement CTEdisagg;
	
	/* X-path for add new */
	@FindBy(xpath = "(//div[contains(text(),'Observation')])[1]")
	private WebElement CTEobs;
	
	
	
	
	/* X-path for new Product select*/
	@FindBy(xpath = "//*[@id='productSearch_0']")
	//(//span[contains(@class ,'Searchbar_idText')])[1] 
	private WebElement productselect;


	/* X-path for product id search box */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[5]/div[2]/div/div/div[1]/div[2]/form/div/div[1]/div[1]/div/div[2]/ul/li/p")
	private WebElement productidsearchbox;

	/* X-path for choose process */
	@FindBy(xpath = "(//input[@type='search'])[3]")
	private WebElement chooseprocess;
	// *[@id="root"]/div/div[5]/form/div[4]/div[1]/div/div[2]
	
	
	/* X-path for choose process */
	@FindBy(xpath = "//*/body/div[4]/div/div/div[2]/div/div/div/div/div/div")
	private WebElement chooseprocessselect;
	

	/* X-path for Add Transaction */
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;

	
	/* X-path for choose process */
	@FindBy(xpath = "//*[@id='myForm']/div[1]/div[1]/div/div/div[1]/div/input")
	private WebElement locf;
	
	/* X-path for choose process */
	@FindBy(xpath = "//*[@id='myForm']/div[1]/div[1]/div/div/div[2]/ul/li")
	private WebElement locfval;
	
	
	
	/* X-path for choose process */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[5]/div[2]/div/div/div[2]/div[2]/div/div/div/div[2]/ul")
	private WebElement chooseprocess1;
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
	
	/* X-path for product description */
	@FindBy(xpath = "//input[@name='ProductDescription']")
	private WebElement productdesc;
	

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

	/* X-path for sscc */
	@FindBy(xpath = "//input[@name='SSCC']")
	private WebElement sscc1;

	/* X-path for sscc arrow */
	@FindBy(xpath = "//*[@id='disaggregation_sscc_arrow_button']")
	private WebElement ssccarrow;

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
	@FindBy(xpath = "//*/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/button[3]")
	private WebElement datenextbutton;

	/* X-path for packing type date next button */
	@FindBy(xpath = "//*/div[3]/div/div/div/div/div[1]/div/div[1]/div[1]/button[3]")
	private WebElement datenextbuttonnew;
	/* X-path for packing type date next button */
	@FindBy(xpath = "//*/body/div[3]/div/div/div/div/div[1]/div/div[1]/div[1]/button[3]")
	private WebElement datenextbutton1;

	@FindBy(xpath = "//*/body/div[4]/div/div/div/div/div[1]/div/div[1]/div[1]/button[3]")
	private WebElement datenextbutton1new;

	/* X-path for packing type dropdown value */
	// @FindBy(xpath = "//td[@title='2024-03-30']")
	@FindBy(xpath = "//tr[3]/td[5]/div[@class='ant-picker-cell-inner']")
	private WebElement dateselect;

	/* X-path for packing type dropdown value */
	// @FindBy(xpath = "//td[@title='2024-03-30']")
	@FindBy(xpath = "//html//body//div[3]//div/div/div/div/div[1]/div/div[1]/div[2]/table/tbody/tr[3]/td[5]/div[@class='ant-picker-cell-inner']")
	private WebElement dateselect1;

	/* X-path for ok button */
	@FindBy(xpath = "//*/div[2]/div/div/div/div/div[2]/ul/li/button")
	private WebElement okbutton;

	/* X-path for ok button */
	@FindBy(xpath = "//*/div[3]/div/div/div/div/div[2]/ul/li/button")
	private WebElement okbuttonnew;

	/* X-path for ok button */
	@FindBy(xpath = "//*/div[3]/div/div/div/div/div[2]/ul/li/button")
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
	
	/* X-path for existing shared btach */
		@FindBy(xpath = "(//input[contains(@class, 'form-control CustomSelectInput_customSelectInputField')])[2]")
	
	private WebElement sharedbatch;
	
		/* X-path for existing shared btach */
		@FindBy(xpath = "//div[contains(text(),'Shared Batch/Lot/LGTIN')]")
	// input[@class='ant-select-selection-search-input']
	private WebElement sharedbatchvalue;

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
	@FindBy(xpath = "//*[@id='myForm']/div[1]/div[2]/div/div/div/div/input")
	// @FindBy(xpath = "//*[@id='new_transaction_select_organization']")
	private WebElement org;

	/* X-path for organisation select */
	@FindBy(xpath = "//*[@id='myForm']/div[1]/div[2]/div/div/div[2]/ul/li")
	private WebElement orgselect;

	/* X-path for location */
	@FindBy(xpath = "//*[@id='myForm']/div[1]/div[3]/div/div/div[1]/div/input")
	private WebElement location;
	
	/* X-path for packing location */
	//@FindBy(xpath = "//input[@name='TLC_PackingLocation_1691015072410000015']")
	@FindBy(xpath = "//input[contains(@name, 'TLC_PackingLocation')]")
	
	//input[contains(@name, 'TLC_PackingLocation')]

	private WebElement packloc;
	
	
	
	/* X-path for Remarks */
	//@FindBy(xpath = "//input[@name='Remarks_1691015072410000015']")
	@FindBy(xpath = "//input[contains(@name, 'Remarks')]")
	private WebElement remarks;
	
	
	/* X-path for packing type dropdown value */
	@FindBy(xpath = "(//div/input)[23]")
	private WebElement batchscroll;

/* X-path for tlc */
	@FindBy(xpath = "//input[@id='add_transaction_transformation_input_TLC_Number']")
	private WebElement tlctrans;
	
/* X-path for itemsgtin */
	@FindBy(xpath = "(//input[@name='LGTIN'])[2]")
	private WebElement newlgtin;
	

	/* X-path for itemsgtin */
	@FindBy(xpath = "//*[@id='Icon_material-arrow-forward']")
	private WebElement newlgtinarrow;
	

	/* X-path for itemsgtin */
	@FindBy(xpath = "//*[@id='transformation_lgtin_arrow_button0']")
	private WebElement newlgtinarrow1;
	
	/* X-path for itemsgtin */
	@FindBy(xpath = "(//*[@name='WeightPerSGTIN'])[2]")
	private WebElement weightscroll;
	
	/* X-path for itemsgtin */
	@FindBy(xpath = "//*[@name='quantityConsumed']")
	private WebElement qtyconsumed;
	
	/* X-path for packing type date next button */
	@FindBy(xpath = "(//input[@name='CountOfSGTIN'])[3]")
	private WebElement newcountsgtin;
	
	/* X-path for packing type date next button */
	@FindBy(xpath = "(//input[@name='WeightPerSGTIN'])[3]")
	private WebElement newwtsgtin;
	
	
	/* X-path for packing type date next button */
	@FindBy(xpath = "(//input[@name='UoMSGTIN'])[3]")
	private WebElement newuomsgtin;

	/* X-path for add signature */
	@FindBy(xpath = "//button/span[contains(text(), 'Add')]")
private WebElement addsign;

/* X-path for add signature */
	@FindBy(xpath = "(//div[@class='ant-tabs-tab-btn'])[2]")
private WebElement typesign;
/* X-path for add signature */
	@FindBy(xpath = "//input[@placeholder='Enter here' and @name ='sign']")
private WebElement placesign;

/* X-path for add signature submit */
	@FindBy(xpath = "(//button[contains(text(), 'Submit')])[3]")
private WebElement signsubmit;
	/* X-path for Remarks */
	//@FindBy(xpath = "//input[@name='Remarks_1691015072410000015']")
	@FindBy(xpath = "//textarea[@name='remarks']")
	private WebElement remarksarea;
	
	/* X-path for TLC loc */
	@FindBy(xpath = "//input[contains(@name, 'TLC_SourceReference')]")
	//@FindBy(xpath = "//input[@name='TLC_SourceReference_1691015072410000015']")
	private WebElement tlcloc;
	
	
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
	@FindBy(xpath = "//input[@name='BillOfLadingNo']")
	private WebElement bill;

	/* X-path for lot arrow */
	// @FindBy(xpath = "//*[@id='Icon_material-arrow-forward']")
	@FindBy(xpath = "//*[@id='aggregation_lgtin_arrow_button0']")
	private WebElement lotarrow;

	/* X-path for lot invoice */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div[3]/div[8]/div[2]/input")
	private WebElement invoice;

	/* X-path for lot invoice */	
	//@FindBy(xpath = "	//input[@name='CommodityVarietyOfTheProduct_31009072410000005']")
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


	/* X-path for new Product id */
	@FindBy(xpath = "//label/span[contains(text(), 'Shared Product')]")
	private WebElement sharedproduct;
	
	/* X-path for commodity */
	@FindBy(xpath = "//input[@name='CommodityVarietyOfTheProduct']")
	private WebElement commodity;

	/* X-path for field */
	@FindBy(xpath = "//input[@name='FieldOrFoodGrowingAreaName']")
	private WebElement field;

	/* X-path for container */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div/div/div[19]/div/div[1]/div/input")
	private WebElement Container;

	
	/* X-path for containervalue */
	@FindBy(xpath = "//*[@id='myForm']/div[4]/div/div/div[19]/div/div[2]/ul")
	private WebElement Containervalue;

	/* X-path for document */
	@FindBy(xpath = "//input[@name='DocumentReferenceNo']")
	private WebElement document;
	
	/* X-path for document */
	@FindBy(xpath = "//input[@name='documentReferenceNo']")	
	private WebElement document1;


/* X-path for add signature */
		@FindBy(xpath = "//input[@name='Height']")
	private WebElement height;
		
	/* X-path for itemsgtin */
	@FindBy(xpath = "(//input[contains(@class,'CustomSelectInput_customSelectInputField')])[7]")
	////*[@id="myForm"]/div[4]/div/div/div[17]/div/div/div/input
	private WebElement itemsgtin;

	/* X-path for itemsgtin */
	@FindBy(xpath = "//div[contains(text() ,'kgs')]")
	private WebElement itemsgtinvalue;

	/* X-path for weightsgtin */
	@FindBy(xpath = "//input[@name='WeightPerSGTIN']")
	private WebElement weightsgtin;

	/* X-path for countsgtin */
	@FindBy(xpath = "//input[@name='CountOfSGTIN']")
	private WebElement countsgtin;
	
	/* X-path for packing type date next button */
	@FindBy(xpath = "(//div[@class='ant-picker-input'])[1]")
	private WebElement mfgdate;
	
	/* X-path for packing type date next button */
	@FindBy(xpath = "//button[@class='ant-picker-header-prev-btn']")
	private WebElement mgfdateprevbutton;
	
	
	/* X-path for packing type date next button */
	@FindBy(xpath = "//div[@class='ant-picker-cell-inner' and contains(text(),'13')]")
	private WebElement mgfdateselect;
	
	/* X-path for packing type date next button */
	@FindBy(xpath = "(//div[@class='ant-picker-input'])[2]")
	private WebElement expdate;
	
	/* X-path for packing type date next button */
	@FindBy(xpath = "(//button[@class='ant-picker-header-next-btn'])[2]")
	private WebElement expdatenextbutton;
	
	
	/* X-path for packing type date next button */
	@FindBy(xpath = "(//div[@class='ant-picker-cell-inner' and contains(text(),'13')])[2]")
	private WebElement expdateselect;
	
	/* X-path for ok button */
	@FindBy(xpath = "(//button/span[contains(text(),'OK')])[2]")
	private WebElement expokbutton;
	

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

	public static String copyvalueprodid() throws FileNotFoundException {
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

	
	public void transactiondis() throws InterruptedException, IOException {
		Thread.sleep(8000);
		//Traceassetcontainer textnew = new Traceassetcontainer(driver, eto, actionutil);
	//	textnew.assets();
		//Thread.sleep(2000);
		actionutil.clickOnElement(trace, "click on trace");
		Thread.sleep(5000);
		actionutil.scrollToElement(transaction, "transaction is scrolled");
		actionutil.clickOnElement(transaction, "transaction is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(addnew, "add new is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(sharedproduct, "sharedproduct is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(CTE, "clicked on CTE");
		Thread.sleep(4000);
		actionutil.clickOnElement(CTEdisagg, "clicked on CTEdisagg comm");
		Thread.sleep(2000);
		actionutil.clickOnElement(productidtext, "Product id is clicked");
		Thread.sleep(2000);
		
	//	actionutil.clickOnElement(productidtext, "Product id is clicked");
		//Thread.sleep(2000);
		String prodid= copyvalueprodid();
		/**Extra line-----463**/
		Actions actions = new Actions(driver);
        actions.sendKeys(productidtext, prodid).perform();
		//actionutil.typeText(productidtext,prodid , "Saved Value of Prod id is entered");
		actionutil.clickOnElement(productselect, "Productselect is clicked");
		Thread.sleep(2000);
	//	actionutil.clickOnElement(productidtext, "Product id is clicked");
	//	Thread.sleep(2000);
	//	actionutil.clickOnElement(productidsearchbox, "Product id is clicked");
	//	Thread.sleep(2000);
		actionutil.clickOnElement(chooseprocess, "chooseprocess id is clicked");
		Thread.sleep(2000);
		actionutil.typeText(chooseprocess, "processdisagg", "Harvestiong/commission is entered");
		Thread.sleep(5000);
		actionutil.clickOnElement(chooseprocessselect, "process is selected");
		Thread.sleep(6000);
		Thread.sleep(2000);
		actionutil.clickOnElement(submit, "click on submit button");
		Thread.sleep(2000);
				actionutil.clickOnElement(locf, "locf is clicked");
	Thread.sleep(2000);
	actionutil.typeText(locf, "9650541994111", "locf Value is entered");
	Thread.sleep(5000);
		actionutil.clickOnElement(locfval, "locfvalue is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(activity, "activity is selected");
		actionutil.typeText(activity, "abcd", "activity Value is entered");
		actionutil.scrollToElement(sscc1, "scrolled to sscc1");
		actionutil.clickOnElement(sscc1, "sscc1 is selected");
		String copyvalue1= copyvalue();
		actionutil.typeText(sscc1, copyvalue1, "sscc Value is entered");
		actionutil.clickOnElement(ssccarrow, "sscc arrow is selected");
		Thread.sleep(6000);
		actionutil.scrollToElement(height, "scrolled to document");
		Thread.sleep(3000);
		actionutil.clickOnElement(document, "document is clicked");
		actionutil.typeText(document, "1234567", "document is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(bill, "bill is clicked");
		actionutil.typeText(bill, "12345", "purchase is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(productdesc, "product descriptiom is clicked");
		actionutil.typeText(productdesc, "abcd", "Product desc is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(remarks, "remarks is clicked");
		Thread.sleep(2000);
		actionutil.typeText(remarks, "test", "remarks is entered");
		Thread.sleep(4000);
		actionutil.scrollToElement(remarksarea, "remarks area is scroll");
		actionutil.clickOnElement(remarksarea, "remarks is clicked");
		Thread.sleep(2000);
		actionutil.typeText(remarksarea, "test", "remarks is entered");
		Thread.sleep(4000);
		actionutil.clickOnElement(addsign, "addsign is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(typesign, "typesign is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(placesign, "pacesign is clicked");
		Thread.sleep(2000);
		actionutil.typeText(placesign, "deep", "placesign is entered");
		Thread.sleep(4000);
		actionutil.clickOnElement(signsubmit, "signsubmit is clicked");
		Thread.sleep(2000);
		actionutil.scrollToElement(addtran, "add trans is scrolled");
		actionutil.clickOnElement(addtran, "Add Transaction is selected");
		System.out.println("dis transaction is completed...");
		Thread.sleep(8000);

		
	}
	
	public void transactiontrans() throws InterruptedException, IOException{
		Thread.sleep(8000);
	//	actionutil.clickOnElement(trace, "clicked on trace");
	//	Thread.sleep(5000);
		actionutil.scrollToElement(transaction, "Transaction is scrolled");
		actionutil.clickOnElement(transaction, "transaction is clicked");
		Thread.sleep(5000);

		actionutil.clickOnElement(existingproductid, "productid is selected");
		actionutil.clickOnElement(sharedproduct, "shared product is clicked");
		String copyvalue1 = copyvalueprodid();
		actionutil.typeText(existingproductid, copyvalue1, "enter the productid");
		actionutil.clickOnElement(existingproductid, "productid is selected");
		actionutil.clickOnElement(existingproductsearch, "search is selected");
		Thread.sleep(2000);
		
		actionutil.clickOnElement(sharedbatch, "shared batch is clicked");
		actionutil.clickOnElement(sharedbatchvalue, "shared batch value is clicked");
		actionutil.clickOnElement(searchbutton, "search button is clicked");
		Thread.sleep(4000);

		//Thread.sleep(2000);
		String lotvalue = lotelement.getText();
		System.out.println("Print the value :" + " " + lotvalue);
		actionutil.scrollUp();
		Thread.sleep(2000);
		actionutil.scrollUp();
		Thread.sleep(4000);
		actionutil.clickOnElement(transaction, "transaction is clicked");
		Thread.sleep(5000);


		actionutil.scrollToElement(transaction, "Transaction is scrolled");
		actionutil.clickOnElement(transaction, "transaction is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(addnew, "add new is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(sharedproduct, "sharedproduct is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(productidtext, "Product id is clicked");
		Thread.sleep(2000);
		
		/**Extra line-----463**/
		actionutil.typeText(productidtext,copyvalue1 , "Saved Value is entered");
		actionutil.clickOnElement(productselect, "Productselect is clicked");
		Thread.sleep(2000);
	
					actionutil.clickOnElement(chooseprocess, "chooseprocess id is clicked");
				Thread.sleep(2000);
				actionutil.typeText(chooseprocess, "tran", "Transformation is entered");
				Thread.sleep(2000);
				actionutil.clickOnElement(chooseprocess, "chooseprocess id is clicked");
				Thread.sleep(3000);
				// actionutil.scrollDown();
				actionutil.clickOnElement(processselectcomm, "Process Transformation is selected");
				Thread.sleep(5000);
			//	actionutil.scrollDown();
				actionutil.clickOnElement(mfgdate, "date is selected");
				Thread.sleep(1000);
				actionutil.clickOnElement(mgfdateprevbutton, "date prev button");
				actionutil.clickOnElement(mgfdateselect, "date is entered");
				Thread.sleep(2000);
				actionutil.clickOnElement(okbutton, "date is selected");
				Thread.sleep(2000);
				actionutil.clickOnElement(expdate, "date is selected");
				Thread.sleep(1000);
				actionutil.clickOnElement(expdatenextbutton, "date next button");
				actionutil.clickOnElement(expdateselect, "date is entered");
				Thread.sleep(2000);
				actionutil.clickOnElement(expokbutton, "date is selected");
				Thread.sleep(2000);
				
				actionutil.scrollDowntoelement(activity);
				actionutil.clickOnElement(activity, "activity is selected");
				actionutil.typeText(activity, "abcd", "activity Value is entered");
				Thread.sleep(2000);
				actionutil.clickOnElement(packingtype, "packingtype is selected");
				Thread.sleep(2000);
				actionutil.clickOnElement(packingtypeselect, "packingtypeselect is selected");
				Thread.sleep(2000);
				actionutil.scrollToElement(batchscroll, "batch scrolled");
				Thread.sleep(2000);
				actionutil.clickOnElement(remarks, "remarks is selected");
				actionutil.typeText(remarks, "test", "remarks Value is entered");
				actionutil.clickOnElement(document, "document is selected");
				actionutil.typeText(document, "12345", "document Value is entered");
				actionutil.clickOnElement(tlctrans, "tlc is selected");
				actionutil.typeText(tlctrans, "12345", "tlc Value is entered");
				actionutil.clickOnElement(countsgtin, "count sgtin is clicked");
				actionutil.typeText(countsgtin, "123", "countsgtin is entered");
				actionutil.clickOnElement(itemsgtin, "itemsgtin is selected");
				actionutil.clickOnElement(itemsgtinvalue, "itemsgtinvalue is selected");
				actionutil.clickOnElement(newlgtin, "newlgtin is clicked");
				actionutil.typeText(newlgtin, lotvalue, "lotvalue is entered");
				actionutil.clickOnElement(newlgtinarrow1, "newlgtinarrow is clicked");
				actionutil.scrollToElement(weightscroll, "weight is scrolled");
				
				actionutil.clickOnElement(qtyconsumed, "qtyconsumed is clicked");
				actionutil.typeText(qtyconsumed, "1", "qtyconsumeda is entered");
				
			//	actionutil.clickOnElement(newcountsgtin, "newcountsgtin is clicked");
			//	actionutil.typeText(newcountsgtin, "123", "newcountsgtin is entered");
				
			//	actionutil.clickOnElement(newwtsgtin, "newwtsgtin is clicked");
			//	actionutil.typeText(newwtsgtin, "1234", "newwtsgtin is entered");
				
			//	actionutil.clickOnElement(newuomsgtin, "newuomsgtin is clicked");
			//	actionutil.typeText(newuomsgtin, "123", "newuomsgtin is entered");
				
				actionutil.scrollToElement(addtran, "scrolled to trans");
				Thread.sleep(2000);
				actionutil.clickOnElement(addtran, "Add Transaction is selected");
				Thread.sleep(10000);
				System.out.println("transaction transformation is completed..");
				
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
		actionutil.scrollToElement(lot1, "scrolles to lot");
		actionutil.clickOnElement(ssccimg, "sscc number is copied");
		Thread.sleep(2000);
		copiedTextsscc = actionutil.getClipboardContents();
		Thread.sleep(2000);
		System.out.println("Print the value of sscc: " + " " + copiedTextsscc);
		Thread.sleep(5000);
		String savedinfile = " sscc man id:   " + copiedTextsscc;
		System.out.println(" Print the value of saved" + "  " + copiedTextsscc);

		// String filePath = "/path/to/your/file.txt";

		// Initialize FileWriter in append mode
		FileWriter writer = new FileWriter(filePath1, true);
		writer.write(savedinfile + "\n"); // Write the first value
		writer.write(copiedTextsscc + "\n"); // Write the first value
		writer.close();

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
		actionutil.scrollUptoelement(comm , "The packloc is displayed after scroll up");
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
		actionutil.clickOnElement(datenextbutton1, "datenext button is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(datenextbutton1, "datenext button is clicked");
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
		Thread.sleep(9000);
		System.out.println(" the process is ended");
	}

	public void transactionobssscc() throws InterruptedException, IOException {
		/***
		 * code to work single
		 */

		/**/
		/*8
		
		actionutil.clickOnElement(trace,"click on trace");
		Thread.sleep(4000);
		actionutil.scrollDowntoelement(transaction);
		Thread.sleep(2000);	
		
			**/
		
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
/**
actionutil.clickOnElement(chooseprocess, "chooseprocess id is clicked");
		Thread.sleep(2000);
		actionutil.typeText(chooseprocess, "Packing", "Packing/aggregation is entered");
		Thread.sleep(2000);
		actionutil.clickOnElement(chooseprocess1, "chooseprocess id is clicked");
		Thread.sleep(6000);

		actionutil.scrollToElement(lot1, "scrolldown to sscc");
		Thread.sleep(4000);
		actionutil.clickOnElement(ssccimg, "sscc number is copied");
		Thread.sleep(2000);
		String copiedTextsscc = actionutil.getClipboardContents();
		Thread.sleep(2000);
		System.out.println("Print the value of sscc: " + " " + copiedTextsscc);
		Thread.sleep(8000);

	
		actionutil.clickOnElement(transaction, "transaction is clicked");
		Thread.sleep(5000);
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
		**/
		actionutil.clickOnElement(chooseprocess, "chooseprocess id is clicked");
		Thread.sleep(2000);
		actionutil.typeText(chooseprocess, "Observation", "Observation is entered");
		actionutil.clickOnElement(chooseprocess1, "chooseprocess id is clicked");
		Thread.sleep(3000);
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
		String copiedTextsscc = copyvalue();
		actionutil.typeText(sscc1, copiedTextsscc, "sscc is entered");
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
		Thread.sleep(5000);
	}

}