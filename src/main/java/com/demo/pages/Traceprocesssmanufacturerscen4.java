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

public class Traceprocesssmanufacturerscen4 {
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
	//public static int lineNumber = 1; // Change this to the line number you want to read
	public static long lineNumber=0;
	public static int currentLine = 1;
	public static String savedValue = null;

	public Traceprocesssmanufacturerscen4(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
	}

	/* X-path for trace button */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/aside/div/ul/li[1]/div/span")
	private WebElement trace;

	/* X-path for Process */
	@FindBy(xpath = "//span[text()='Processes']")
	private WebElement process;

	/* X-path for existing Product id */
	//@FindBy(xpath = "//input[@id='prod_id_existing_processes']")
	@FindBy(xpath = "//input[@class='ant-select-selection-search-input']")	
	private WebElement productidtext;
	//ant-select-selection-search-input
	
	/* X-path for new Product id */
	@FindBy(xpath = "//div[@class='ant-select-selector']")
	private WebElement productidtextnew;


/* X-path for new Product id */
	@FindBy(xpath = "(//div[contains(@class,'ProductTypeSelector_radioInputParent')])[1]")
	private WebElement sharedproduct;



/* X-path for existing Product id */

@FindBy(xpath = "(//div[@class='product-label'])[1]")	
private WebElement productselect;

	
	
	

	/* X-path for product id search box */
	//@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[4]/div/div[2]/div/div/div/div[2]/form/div/div[1]/div[1]/div/div[4]/ul/li")
@FindBy(xpath = "//div[@class='product-label']")
	//div[@class='product-label']
	private WebElement productidsearchbox;
	
	/* X-path for existing product search */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[4]/div/div[2]/div/div/div/div[2]/form/div/div[1]/div[1]/div/div[2]/ul")
	private WebElement productidsearchbox1;

	/* X-path for Product category */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/form/div[4]/div[1]/div/div[1]")
	private WebElement productcategory;
	// *[@id="root"]/div/div[5]/form/div[4]/div[1]/div/div[2]

	/* X-path for product based food */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/form/div[4]/div[1]/div/div[2]/ul/li[1]")
	private WebElement productbasedfood;

	/* X-path for productname */
	@FindBy(xpath = "//input[@id='add_product_productName']")
	private WebElement productname;

	/* X-path for productid */
	@FindBy(xpath = "//input[@id='add_product_gtin_input']")
	//@FindBy(xpath = "//div[@class='ant-select-selector']")
	//@FindBy(xpath = "//input[@class='ant-select-selection-search-input']")
	
	//ant-select-selection-overflow
	
	
	 
	private WebElement productid;

	/* X-path for checkbox */
	@FindBy(xpath = "//input[@id='gtin-checkbox']")
	private WebElement checkbox;

	/* X-path for Autogenerate */
	@FindBy(xpath = "//button[@id='add_product_autogenerate_button']")
	private WebElement autogenerate;

	/* X-path for product description */
	@FindBy(xpath = "//textarea[@id='add_product_description_input']")
	private WebElement productdesc;

	/* X-path for upload */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/form/div[5]/div[2]/div[1]/div[2]/button")
	private WebElement upload;

	// span[text()='Upload Photo/Video']
	// button[@class='FileUpload_uploadButton__9mScn undefined']

	/* X-path for Ingredient name */
	@FindBy(xpath = "//input[@id='add_product_ingredients_input']")
	private WebElement ingredientname;

	/* X-path for Ingredient add */
	@FindBy(xpath = "//button[@id='add_product_ingredients_add_button']")
	private WebElement ingredientadd;

	/* X-path for Consumption */
	@FindBy(xpath = "//textarea[@id='add_product_guidelines_input']")
	private WebElement consumption;

	/* X-path for UOM */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[4]/div[1]/div/div[2]/ul/li[1]")
	private WebElement uom;

	/* X-path for Nutrition quanity */
	@FindBy(xpath = "//input[@id='add_product_nutrition_quantity_input']")
	private WebElement nutritionqty;

	/* X-path for Nutrition fact */
	@FindBy(xpath = "//input[@id='add_product_nutrition_name_input']")
	private WebElement nuritionfact;

	/* X-path for Nutrition drop */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[8]/div[2]/div/div[1]/div/div[2]/div[3]/div/div/div")
	private WebElement nuritiondrop;

	/* X-path for Nutrition value */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[8]/div[2]/div/div[1]/div/div[2]/div[3]/div/div/div[2]/ul/li[1]/div/div/div[1]")
	private WebElement nuritionvalue;

	/* X-path for Unit of Measurement */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[9]/div[1]/div/div/div/input")
	private WebElement unitofmeasue;

	/* X-path for unit of measurement dropdown */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[9]/div[1]/div/div[2]/ul/li[1]/div/div/div")
	private WebElement dropdown;

	/* X-path for price */
	@FindBy(xpath = "//input[@name='price']")
	private WebElement price;

	/* X-path for currency */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[9]/div[2]/div[2]/span/div/div/div[1]/div/input")
	private WebElement currency;

	/* X-path for currency value */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[9]/div[2]/div[2]/span/div/div/div[2]/ul/li[1]/div/div/div/div/span")
	private WebElement currencyvalue;

	/* X-path for Add type packing */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[10]/div/div/div[1]/div/div[2]/div[1]/input")
	private WebElement typepacking;

	/* X-path for Length */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[10]/div/div/div[1]/div/div[2]/div[3]/input")
	private WebElement length;
	// *[@id="root"]/div/div[5]/form/div[4]/div[1]/div/div[2]

	/* X-path for breath */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[10]/div/div/div[1]/div/div[2]/div[4]/input")
	private WebElement breath;

	/* X-path for height */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[10]/div/div/div[1]/div/div[2]/div[5]/input")
	private WebElement height;

	/* X-path for checkbox1 */
	@FindBy(xpath = "//*[@id='defaultProcessCheckbox']")
	private WebElement checkbox1;

	/* X-path for register product */
	@FindBy(xpath = "//*[@id='add-product-register-btn']")
	private WebElement registerproduct;

	/* X-path for GLN number */
	@FindBy(xpath = "//*[@id='myId']/div[1]/div/div[2]/div[3]/div/div/div/div/input")
	private WebElement gln1;

	/* X-path for GLN number */
	@FindBy(xpath = "//*[@id='myId']/div[1]/div/div[3]/div[3]/div/div/div/div/input")
	private WebElement gln2;

	/* X-path for GLN number */
	@FindBy(xpath = "//*[@id='myId']/div[1]/div/div[4]/div[3]/div/div/div/div/input")
	private WebElement gln3;

	/* X-path for autosearch */
	@FindBy(xpath = "//*[@id='myId']/div[1]/div/div[2]/div[3]/div/div/div[2]/ul")
	private WebElement autosearch;

	/* X-path for autosearch */
	@FindBy(xpath = "//*[@id='myId']/div[1]/div/div[3]/div[3]/div/div/div[2]/ul")
	private WebElement autosearch1;

	/* X-path for autosearch */
	@FindBy(xpath = "//*[@id='myId']/div[1]/div/div[4]/div[3]/div/div/div[2]/ul")
	private WebElement autosearch2;

	/* X-path for prodcut id */
	@FindBy(xpath = "//tr[1]/th[2]")
	private WebElement productidsaved;

	/* X-path for table */
	@FindBy(xpath = "//*[@id='myId']/div[1]")
	private WebElement table;

	/* X-path for process add */
	@FindBy(xpath = "//*[@id='ADD_NEW_PROCESSES']")
	private WebElement processadd;

	/* X-path for outside */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[5]")
	private WebElement outside;

	/* X-path for processname */
	@FindBy(xpath = "//*[@id='processName_input_id']")
	private WebElement processname;

	/* X-path for process location */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[6]/div/form/div[1]/div[2]/div/div/div/input")
	private WebElement processloc;

	/* X-path for process location search */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[6]/div/form/div[1]/div[2]/div/div[2]/ul/li[1]")
	private WebElement processlocsearch;

	/* X-path for process type */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[6]/div/form/div[1]/div[3]/div/div/div/input")
	private WebElement processtype;

	/* X-path for process type search */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[6]/div/form/div[1]/div[3]/div/div[2]/ul/li[1]")
	private WebElement processcom;

	/* X-path for process type search */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[6]/div/form/div[1]/div[3]/div/div[2]/ul/li[2]")
	private WebElement processobsold;

	/* X-path for process type search */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[6]/div/form/div[1]/div[3]/div/div[2]/ul/li[3]")
	private WebElement processaggold;

	/* X-path for process type search */
	@FindBy(xpath = "//div[ contains(text(), 'Commission')]")
	private WebElement processdiscomm;
	
	/* X-path for process type search */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[6]/div/form/div[1]/div[3]/div/div[2]/ul/li[5]")
	private WebElement processdisagg;
	
	/* X-path for process type search */
	@FindBy(xpath = "//div[ contains(text(), 'Cooling')]")
	private WebElement processcooling;
	
	/* X-path for process type search */
	@FindBy(xpath = "//div[ contains(text(), 'Observation')]")
	private WebElement processobs;
	
	/* X-path for process type search */
	@FindBy(xpath = "//div[contains(text(),'SSCC')]")
	private WebElement kdesscc;

	
	/* X-path for process type search */
	@FindBy(xpath = "//div[ contains(text(), 'Aggregation')]")
	private WebElement processagg;
	
	/* X-path for process type search */
	@FindBy(xpath = "//div[ contains(text(), 'Transformation')]")
	private WebElement processtrans;

	/* X-path for process add */
	@FindBy(xpath = "//*[@id='add_process_button']")
	private WebElement processadd1;
	
	/* X-path for process add */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[6]/div/form/div[1]/div[3]/div/div[2]/ul")
	private WebElement processtypeall;
	

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

	

	public void processaddobsnokde() throws InterruptedException, IOException {
	
		
		//Thread.sleep(8000);
		Thread.sleep(4000);

		//actionutil.clickOnElement(trace, "click on trace");
		//Thread.sleep(4000);
		
		actionutil.scrollToElement(process, "scrolled to process");
		Thread.sleep(2000);
		actionutil.clickOnElement(process, "Process is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(processadd, "Process add is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(productidtextnew, "Product id is clicked");
		Thread.sleep(2000);	
		actionutil.clickOnElement(productselect, "Product id is selected");
		Thread.sleep(2000);
		actionutil.clickOnElement(processname, "process name is clicked");
		Thread.sleep(2000);
					actionutil.typeText(processname, "processobsnokde", "process name Value is entered");
					Thread.sleep(2000);
					actionutil.clickOnElement(processloc, "process loc is clicked");
					Thread.sleep(2000);
					actionutil.typeText(processloc, "9650541994111", "process name Value is entered");
					Thread.sleep(8000);					
					actionutil.clickOnElement(processlocsearch, "process loc is clicked");
					Thread.sleep(5000);
					actionutil.clickOnElement(processtype, "process type is clicked");
					Thread.sleep(2000);
					actionutil.scrollDown();
					actionutil.clickOnElement(processobs, "process obs is clicked");
					Thread.sleep(2000);					
					actionutil.scrollToElement(processadd1, "process add is scrolled");
					actionutil.clickOnElement(kdesscc, "kdesscc  is clicked");
					Thread.sleep(2000);
					//actionutil.scrollDownToBottom();
					actionutil.clickOnElement(processadd1, "process add button is clicked");
					Thread.sleep(5000);
					
					
							}
public void processaddobs() throws InterruptedException, IOException {
	
		
		//Thread.sleep(8000);
		Thread.sleep(4000);

		//actionutil.clickOnElement(trace, "click on trace");
		//Thread.sleep(4000);
		
		actionutil.scrollToElement(process, "scrolled to process");
		Thread.sleep(2000);
		actionutil.clickOnElement(process, "Process is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(processadd, "Process add is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(productidtextnew, "Product id is clicked");
		Thread.sleep(2000);	
		actionutil.clickOnElement(productselect, "Product id is selected");
		Thread.sleep(2000);
		actionutil.clickOnElement(processname, "process name is clicked");
		Thread.sleep(2000);
					actionutil.typeText(processname, "processobs", "process name Value is entered");
					Thread.sleep(2000);
					actionutil.clickOnElement(processloc, "process loc is clicked");
					Thread.sleep(2000);
					actionutil.typeText(processloc, "9650541994111", "process name Value is entered");
					Thread.sleep(8000);					
					actionutil.clickOnElement(processlocsearch, "process loc is clicked");
					Thread.sleep(5000);
					actionutil.clickOnElement(processtype, "process type is clicked");
					Thread.sleep(2000);
					actionutil.scrollDown();
					actionutil.clickOnElement(processobs, "process obs is clicked");
					Thread.sleep(2000);					
					actionutil.scrollToElement(processadd1, "process add is scrolled");
					//actionutil.clickOnElement(kdesscc, "kdesscc  is clicked");
					Thread.sleep(2000);
					//actionutil.scrollDownToBottom();
					actionutil.clickOnElement(processadd1, "process add button is clicked");
					Thread.sleep(5000);
					
					
							}
}