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


public class Traceprocess {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	int randomNumber = new Random().nextInt(1000);
	int randomNumber1= new Random().nextInt(13);
	String randomNumber12 = actionutil.generateRandomNumber(13);
	String randomValue;
	String emailaddress = randomNumber + "@yopmail.com";
	String proname = "wheat" + randomNumber;
 	public static String userDir = System.getProperty("user.dir");
	String imageaddress1 = userDir + "\\src\\test\\resources\\data\\img.jpg";
	public static String filePath = userDir +  "\\src\\test\\resources\\data\\file.txt";
	String imageaddress= "C:\\Users\\Deepti Jindal\\eclipse-workspace\\com.NFR.Trace\\src\\test\\resources\\data\\img.jpg";
	public static String line;
    public static int lineNumber = 1; // Change this to the line number you want to read
    public static int currentLine = 1;
    public static String savedValue = null;
    
	

	public Traceprocess(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
}
	
	/* X-path for trace button */
	@FindBy(xpath = "//*[@id='root']/div/div[4]/aside/div/ul/li[1]/div/span")
	private WebElement trace;
	
	/* X-path for Process */
	@FindBy(xpath = "//span[text()='Processes']")
	private WebElement process;
	
	/* X-path for  existing Product id */
	@FindBy(xpath = "//input[@id='prod_id_existing_processes']")
	private WebElement productidtext;
	
	/* X-path for product id search box*/
	@FindBy(xpath = "//div[@class = 'position-relative undefined']/ul")
	private WebElement productidsearchbox;
	
	/* X-path for Product category*/
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[4]/div[1]/div/div[1]")
	private WebElement productcategory;
	//*[@id="root"]/div/div[5]/form/div[4]/div[1]/div/div[2]
	
	/* X-path for product based food */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[4]/div[1]/div/div[2]/ul/li[1]")
	private WebElement productbasedfood;

	/* X-path for productname */
	@FindBy(xpath = "//input[@id='add_product_productName']")
	private WebElement productname;

	/* X-path for productid */
	@FindBy(xpath = "//input[@id='add_product_gtin_input']")
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
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[5]/div[2]/div[1]/div[2]/button")
	private WebElement upload;
	
	
	//span[text()='Upload Photo/Video']
	//button[@class='FileUpload_uploadButton__9mScn undefined']
	
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
	
	/* X-path for Add type packing*/
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[10]/div/div/div[1]/div/div[2]/div[1]/input")
	private WebElement typepacking;
	
	/* X-path for Length*/
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[10]/div/div/div[1]/div/div[2]/div[3]/input")
	private WebElement length;
	//*[@id="root"]/div/div[5]/form/div[4]/div[1]/div/div[2]
	
	/* X-path for breath */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[10]/div/div/div[1]/div/div[2]/div[4]/input")
	private WebElement breath;

	/* X-path for height */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/form/div[10]/div/div/div[1]/div/div[2]/div[5]/input")
	private WebElement height;

	/* X-path for checkbox1 */
	@FindBy(xpath = "//*[@id='defaultProcessCheckbox']")
	private WebElement checkbox1;
	
	/* X-path for register product*/
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

	/* X-path for autosearch*/
	@FindBy(xpath = "//*[@id='myId']/div[1]/div/div[2]/div[3]/div/div/div[2]/ul")
	private WebElement autosearch;
	
	/* X-path for autosearch*/
	@FindBy(xpath = "//*[@id='myId']/div[1]/div/div[3]/div[3]/div/div/div[2]/ul")
	private WebElement autosearch1;
	
	/* X-path for autosearch*/
	@FindBy(xpath = "//*[@id='myId']/div[1]/div/div[4]/div[3]/div/div/div[2]/ul")
	private WebElement autosearch2;
	
	/* X-path for prodcut id*/
	@FindBy(xpath = "//tr[1]/th[2]")
	private WebElement productidsaved;
	
	/* X-path for table*/
	@FindBy(xpath = "//*[@id='myId']/div[1]")
	private WebElement table;

	
	public static String copyvalue() throws FileNotFoundException
	{
		FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
		try
		{
			
	         
	         while ((line = bufferedReader.readLine()) != null) {
	             if (currentLine == lineNumber) {
	                 savedValue = line;
	                 break;
	             }
	             currentLine++;
	         }
	         bufferedReader.close();
	         
	         System.out.println(" print the value of saved :" + " " + savedValue);

		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return savedValue;
		
		}
	
	
	public void process() throws InterruptedException, IOException
	 {
		Thread.sleep(8000);
		
		actionutil.clickOnElement(trace, "click on trace");
		Thread.sleep(4000);
		actionutil.scrollDowntoelement(process);
		Thread.sleep(2000);
		 actionutil.clickOnElement(process, "Process is clicked");
		 Thread.sleep(5000);
		 actionutil.clickOnElement(productidtext, "Product id is clicked");
		 Thread.sleep(2000);
		 String copyvalue1= copyvalue();
		 actionutil.typeText(productidtext, copyvalue1, "Saved Value is entered");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(productidtext, "Product id is clicked");
		 Thread.sleep(2000);
		 actionutil.clickOnElement(productidsearchbox, "Product id is clicked");
		 Thread.sleep(2000);
		

	
	 }
}