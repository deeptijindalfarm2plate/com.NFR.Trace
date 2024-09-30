package com.demo.pages;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.demo.baseutil.Basetest;
import com.demo.util.WebActionUtil;

public class Tracenetworkmgmtmanufacturer {
	public WebDriver driver;
	public WebActionUtil actionutil;
	public long eto = 30;
	Tracesignuppage oldemailaddress = new Tracesignuppage(driver, eto, actionutil);
	String oldemail = oldemailaddress.getEmailAddress();
	String randomString = new Random().toString();
	String randomValue = actionutil.generateRandomAlphanumeric(8);
	int randomNumber = new Random().nextInt(1000);
	String emailaddress = randomValue + randomNumber + "@yopmail.com";	
	public static String ssccnum1;
	String emailsupp1;
	static String userDir = System.getProperty("user.dir");
	static String filePath = userDir +  "\\src\\test\\resources\\data\\file1.txt";
	static String filePath1 = userDir +  "\\src\\test\\resources\\data\\file2.txt";
	public static String savedValue1 = null;
	
	
	public Tracenetworkmgmtmanufacturer(WebDriver driver, long eto, WebActionUtil actionutil) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actionutil = actionutil;
		this.eto = eto;
	}

	/* X-path for email */
	@FindBy(xpath = "//input[@id = 'username_login_input']")
	private WebElement email;

	/* X-path for password */
	@FindBy(xpath = "//input[@id = 'password_login_input']")
	private WebElement pass;

	/* X-path for Signin button */
	@FindBy(xpath = "//button[@id = 'login_submit_button']")
	private WebElement signin;

	/* X-path for trace button */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/aside/div/ul/li[1]/div/span")
	private WebElement trace;

		
	/* X-path for trace button */
	@FindBy(xpath = "//*/li[1]/span")
	private WebElement dashboard;

	/* X-path for SoilScans button */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/div[2]/div[2]/div/div[4]/div/div/div[1]/div")
	private WebElement soilscans;

	/* X-path for lots button */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/div[2]/div[2]/div/div[3]/div/div/div[1]/div")
	private WebElement lots;

	/* X-path for product registered button */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/div[2]/div[2]/div/div[2]/div/div/div[1]/div")
	private WebElement productreg;

	/* X-path for organization Network */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/div[2]/div[2]/div/div[1]/div/div/div[1]/div")
	private WebElement orgnw;
	
	/* X-path for Network Management */
	@FindBy(xpath = "//*/li[2]/span")
	private WebElement networkmgmt;
	
	/* X-path for Supplier button */
	@FindBy(xpath = "//div/div/div[2]/div[2]/div/div[5]/button/div")
	private WebElement profile;

	/* X-path for button logout */
	@FindBy(xpath = "//*[@id='Logout_header_select']/span")
	private WebElement logout;

	@FindBy(xpath = "//div[@class='dropdown ImageDropdown_dropdown__1lqWL Navbar_profileDropdown__2ZJmL']//span[contains(text(),\"Logout\")]")
	private WebElement logout1;
	
	/* X-path for button logout */
	@FindBy(xpath = "//div[contains(@class, 'nameSection Navbar')]")
	private WebElement profile1;
	

	
	/* X-path for Add New */
	@FindBy(xpath = "//h5[@id='ADD_NEW_ORGANIZATION']")
	private WebElement addnew;
	
	/* X-path for Organisation Name */
	@FindBy(xpath = "//input[@id='org_name_input']")
	private WebElement orgname;
	
	/* X-path for Organisation Type */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[2]/div/div[1]/div/input")
	private WebElement orgtype;
	
	/* X-path for Organisation Upstream */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[2]/div/div[2]/ul/li[1]/div/div/div")
	private WebElement upstream;
	
	/* X-path for Organisation Role */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[3]/div/div[1]")
	private WebElement orgrole;
	
	/* X-path for Role */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[3]/div/div[2]/ul/li[2]/div/div/div")
	private WebElement rolesupplier;
	
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[3]/div/div[2]/ul/li[1]/div/div/div")
	private WebElement rolemanufacture;
	
	
	
	
	/* X-path for Module Name */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[4]/div/div[1]/div/input")
	private WebElement module;
	
	
	/* X-path for Trace */
	//@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[4]/div/div[2]/ul/li/div/div[2]/div[contains(text(), 'Trace')]")
	@FindBy(xpath = "//span[contains(text(), 'Trace')]")	
	private WebElement trace1;
	
	/* X-path for Process */
	@FindBy(xpath = "//span[text()='Processes']")
	private WebElement process;
	
	/* X-path for process add */
	@FindBy(xpath = "//*[@id='ADD_NEW_PROCESSES']")
	private WebElement processadd;


	/* X-path for existing Product id */
	//@FindBy(xpath = "//input[@id='prod_id_existing_processes']")
	@FindBy(xpath = "//input[@class='ant-select-selection-search-input']")	
	private WebElement productidtext;
	
	/* X-path for new Product id */
	@FindBy(xpath = "//div[@class='ant-select-selector']")
	private WebElement productidtextnew;
	
	/* X-path for new Product select*/
	@FindBy(xpath = "	(//div[@class='product-label'])[1]")
	private WebElement productselect;

	
	/* X-path for new Product id */
	@FindBy(xpath = "//label/span[contains(text(), 'Shared Product')]")
	private WebElement sharedproduct;
	
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
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[6]/div/form/div[1]/div[3]/div/div[2]/ul/li[5]")
	private WebElement processdisagg;
	
	
	/* X-path for process type search */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[6]/div/form/div[1]/div[3]/div/div[2]/ul/li[2]")
	private WebElement processobs;
	
	/* X-path for process type search */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[6]/div/form/div[1]/div[3]/div/div[2]/ul/li[1]")
	private WebElement processtra;
	
	
	/* X-path for process type search */
	@FindBy(xpath = "//*[@id='root']/div/div[6]/div/div[6]/div/form/div[1]/div[3]/div/div[2]/ul/li[6]")
	private WebElement processtrans;

	/* X-path for process add */
	@FindBy(xpath = "//*[@id='add_process_button']")
	private WebElement processadd1;
	


	

	
	/* X-path for EmailId */
	@FindBy(xpath = "//*[@id='org_email_input']")
	private WebElement email11;
	
	/* X-path for EmailId after password reset */
	@FindBy(xpath = "//*[@id='username_login_input']")
	private WebElement email1;
	
	/* X-path for password */
	@FindBy(xpath = "//input[@id = 'password_login_input']")
	private WebElement pass1;

	/* X-path for Signin button */
	@FindBy(xpath = "//button[@id = 'login_submit_button']")
	private WebElement signin1;
	/* X-path for Database Type */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[7]/div/div[1]/div/input")
	private WebElement dbtype;
	
	/* X-path for fabric */
	@FindBy(xpath = "//*[@id='orgForm']/div[1]/div[7]/div/div[2]/ul/li[1]/div/div/div")
	private WebElement fabric;

	/* X-path for sendinvte */
	@FindBy(xpath = "//button[@id='org_invite_button']")
	private WebElement sendinvite;

	/* X-path for submit */
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement submit;
	
	/* X-path for input email address */
	@FindBy(xpath = "//input[@placeholder='Enter your inbox here']")
	private WebElement inputemailaddress;
	
	/* X-path for arrow key */
	@FindBy(xpath = "//*[@id='refreshbut']/button/i")
	private WebElement arrow;
	
	/* X-path for first email */
	@FindBy(xpath = "(//button[@class='lm'])[1]")
	private WebElement firstemail;
	
	/* X-path for email subject */
	@FindBy(xpath = "/html/body/header/div[3]/div[1]")
	private WebElement emailsubject;
	
	/* X-path for email link */
	@FindBy(xpath = "//*[@id='mail']/div/div/div[1]/section/a")
	private WebElement link;
	
	/* X-path for enter password */
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passenter;

	/* X-path for enter confirm password */
	@FindBy(xpath = "//input[@name='confirmPassword']")
	private WebElement confirmpass;
	
	/* X-path for button */
	@FindBy(xpath = "//*[@id='root']/div/div[1]/div[2]/form/button")
	private WebElement button;
	

	/* X-path for modal window button */
	@FindBy(xpath = "//button[@class='btn btn-light SolidButton_solidButton__3mY_r  undefined']")
	private WebElement modalbutton;
	
	

	/* X-path for checkbox modal window */
	@FindBy(xpath = "//input[@class='MyAccount_checkbox__2UV1r']")
	private WebElement checkbox;
	
	/* X-path for outer modal window */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/div[2]/div")
		private WebElement outermodal;
	

	/* X-path for outer modal window */
	@FindBy(xpath = "//*[@id='root']/div/div[5]/div[2]/div/div/div[2]")	
	private WebElement outermodal1;
	
	/* X-path for my profile first name */
	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement myprofilefirstname;
	
	/* X-path for my profile last name */
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement myprofilelasttname;
	
	/* X-path for my profile  destination*/
	@FindBy(xpath = "//input[@name='designation']")
	private WebElement myprofiledest;
	
	/* X-path for submit */
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement myprofilesubmit;

	/* X-path for profile */
	@FindBy(xpath = "//*[@id='Admin Profile']")
	private WebElement myprofile;
	
	/* X-path for business */
	@FindBy(xpath = "//*[@id='Admin Profile']")
	private WebElement mybusiness;
	
	/* X-path for business company*/
	@FindBy(xpath = "//input[@id='business_profile_company_name']")
	private WebElement cmpname;
	
	/* X-path for business address*/
	@FindBy(xpath = " //input[@id='business_profile_address_input']")
	private WebElement cmpadd;
	
	/* X-path for business state*/
	@FindBy(xpath = "//input[@id='business_profile_province_input']")
	private WebElement cmpstate;
	
	/* X-path for business city*/
	@FindBy(xpath = "//input[@id='business_profile_city_input']")
	private WebElement cmpcity;
	
	/* X-path for business zipcode*/
	@FindBy(xpath = "//input[@id='business_profile_zipcode_input']")
	private WebElement cmpzip;
	
	
	
	/* X-path for business company*/
	@FindBy(xpath = " //button[@id='business_profile_save_changes']")
	private WebElement cmpsubmit;
	
	/* X-path for last cross*/
	@FindBy(xpath = " //*[@id='___reactour']/div[4]/div/button")
	private WebElement closebutton;

	
	/* X-path for Asset and Infrastructure */
	@FindBy(xpath = "//span[text()='Asset & Infrastructure Data']")
	private WebElement assetinfra;
	
	/* X-path for Asset */
	@FindBy(xpath = "//span[text()='Assets']")
	private WebElement asset;
	
	/* X-path for Add New Asset*/
	@FindBy(xpath = "//h5[@id='ADD_ASSET']")
	private WebElement addnew1;
	
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
	private WebElement uom;
	
	/* X-path for kgs */
	@FindBy(xpath = "//div[contains(@class,'ant-select-item-option-content')][normalize-space()='kgs']")
	private WebElement dropdown;
	
	/* X-path for Add button */
	@FindBy(xpath = "//button[@id='org_invite_button']")
	private WebElement add;


	/* X-path for Add button */
	@FindBy(xpath = "//tr[1]/th[6]")
	private WebElement emailsupp;


	/* X-path for Add button */
	@FindBy(xpath = "//tr[1]/th[2]")
	private WebElement orgname1;

	/* X-path for Process */
	@FindBy(xpath = "//span[text()='Transactions']")
	private WebElement transaction;
	

	/* X-path for existing productid */
	// @FindBy(xpath = "//*[@id='prod_id_undefined']")
	@FindBy(xpath = "//input[@class='ant-select-selection-search-input']")
	// input[@class='ant-select-selection-search-input']
	private WebElement existingproductid;
	
	
	

	/* X-path for existing productid */
	// @FindBy(xpath = "//*[@id='prod_id_undefined']")
	@FindBy(xpath = "(//div[@class='product-label'])[1]")
	// input[@class='ant-select-selection-search-input']
	private WebElement searchbutton;

	

	/* X-path for existing search button */
	@FindBy(xpath = "//*[@id='transactions_search_button']")
	private WebElement search;
	
	

	/* X-path for existing search button */
	//@FindBy(xpath = "(//*[contains(@id, 'Path')])[7])")
	@FindBy(xpath = "//*[@id='Table_0_actionview']/button")
	
	private WebElement eye1;
	

	/* X-path for existing search button */
	@FindBy(xpath = "//tr[2]/th[3]")
	private WebElement eye2;
	

	/* X-path for existing search button */
	@FindBy(xpath = "(//div[contains(@class ,'TransactionDetail_transactiondiscription')])[9]")
	private WebElement ssccnum;


	
	public void tracemudulenetworkmgmt() throws InterruptedException, IOException {
		Thread.sleep(8000);
		//actionutil.clickOnElement(trace, "click on trace");
		Thread.sleep(2000);			
		 actionutil.clickOnElement(networkmgmt, "Network Management is clicked");
		 Thread.sleep(5000);
		 emailsupp1= emailsupp.getText();
		 System.out.println("Print the value of Organisation email" + "  " + emailsupp1);
			String savedinfile = " email id:   " + emailsupp1;
			FileWriter writer = new FileWriter(filePath, true);
	         writer.write(savedinfile + "\n"); // Write the first value
	         writer.write(emailsupp1 + "\n"); // Write the first value
         writer.close();
         
       
	 String orgname2= orgname1.getText();
		 System.out.println("Print the value of Organisation email" + "  " + orgname1);
		 
		// actionutil.scrollDowntoelement(transaction);
		//	Thread.sleep(2000);
			//actionutil.clickOnElement(transaction, "transaction is clicked");
		//	Thread.sleep(5000);
		//	actionutil.clickOnElement(existingproductid, "productid is selected");
		//	actionutil.clickOnElement(searchbutton, "search button is clicked");
			
		 
			actionutil.clickOnElement(profile, "Click on profile account");
			actionutil.clickOnElement(logout1, "Logout the Farm2Plate account");
			actionutil.info("user is on function call");
			actionutil.clickOnElement(email, "email address field is clicked");
			actionutil.typeText(email,emailsupp1 , "Email Id Entered");
			actionutil.clickOnElement(pass, "Enter the password");
			actionutil.typeText(pass, "Admin@1234", "Password Id Entered");
			actionutil.scrollDowntoelement(signin);
			actionutil.clickOnElement(signin, "Press the signin button");
			Thread.sleep(5000);
			Tracesignuppage profile12 = new Tracesignuppage(driver, eto,actionutil);
			profile12.myprofile();
			
			Thread.sleep(2000);			
	        actionutil.clickOnElement(profile1, "Click on profile account");
			actionutil.clickOnElement(logout1, "Logout the Farm2Plate account");
						
			/*
			actionutil.info("user is on function call");
			actionutil.clickOnElement(email, "email address field is clicked");
			actionutil.typeText(email,emailsupp1 , "Email Id Entered");
			actionutil.clickOnElement(pass, "Enter the password");
			actionutil.typeText(pass, "Admin@1234", "Password Id Entered");
			actionutil.scrollDowntoelement(signin);
			actionutil.clickOnElement(signin, "Press the signin button");
			Thread.sleep(2000);		
		 	*/
		 	}
	
	
	public static String copyvalue1() throws FileNotFoundException {
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
			
		try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Start reading from the end of the file
            long lineNumber = 0;
            while ((line = bufferedReader1.readLine()) != null) {
                lineNumber++;
                savedValue1 = line; // Save the current line a1s the last line
                System.out.println("Last line: " + savedValue1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return savedValue1;

       
    }

	
	
	
	public String tracemanusscc() throws InterruptedException, IOException {
		//Tracetransactionsupplier ssccnumber= new Tracetransactionsupplier(driver, eto, actionutil);
		//String sscc = ssccnumber.copiedTextsscc;
		//System.out.println("Print the value of sscc :" + sscc );
		//actionutil.clickOnElement(trace1, "click on trace");
		Thread.sleep(4000);
		 actionutil.scrollDowntoelement(transaction);
			Thread.sleep(2000);
			actionutil.clickOnElement(transaction, "transaction is clicked");
			Thread.sleep(5000);
			actionutil.clickOnElement(existingproductid, "productid is selected");
			actionutil.clickOnElement(searchbutton, "search button is clicked");
			actionutil.clickOnElement(search, "search button is clicked");
			actionutil.clickOnElement(eye1, "search button is clicked");
			actionutil.clickOnElement(eye2, "search button is clicked");
			ssccnum1 = ssccnum.getText();
			System.out.println("Print the value of sscc :" + ssccnum1 );
			
			 System.out.println("Print the value of Organisation email" + "  " + emailsupp1);
				String savedinfile = " ssccnum1 id:   " + emailsupp1;
				FileWriter writer = new FileWriter(filePath1, true);
		         writer.write(savedinfile + "\n"); // Write the first value
		         writer.write(ssccnum1 + "\n"); // Write the first value
	         writer.close();	        
			Thread.sleep(2000);
			actionutil.clickOnElement(profile1, "profile is clicked");
			actionutil.clickOnElement(logout1, "Logout the Farm2Plate account");
			//actionutil.info("user is on function call");
			return ssccnum1;
			
		
	}
	
	public String getemail() {
		return emailsupp1;

	}
	
	
	public void tracemanussccprocess() throws InterruptedException, FileNotFoundException {

			String eamilsupp2 = copyvalue1();
		actionutil.clickOnElement(email, "email address field is clicked");
	//	actionutil.typeText(email,eamilsupp2 , "Email Id Entered");
		actionutil.typeText(email,"ldekkenq362@yopmail.com" , "Email Id Entered");
		actionutil.clickOnElement(pass, "Enter the password");
		actionutil.typeText(pass, "Admin@1234", "Password Id Entered");
		actionutil.scrollDowntoelement(signin);
		actionutil.clickOnElement(signin, "Press the signin button");
		Thread.sleep(4000);		
	 	/** line is extra after network management**/
		//actionutil.clickOnElement(trace1, "click on trace");
		
		
		//Traceasset asset = new Traceasset(driver, eto, actionutil);
		//asset.assets();
	//	Thread.sleep(2000);
		//actionutil.clickOnElement(trace1, "click on trace");
		//Thread.sleep(2000);
		//Traceinfra infra = new Traceinfra(driver, eto, actionutil);
		//infra.infra();
		
		
		
		
	//	Thread.sleep(4000);
		//actionutil.scrollDowntoelement(process);
		actionutil.scrollToElement(process, "scrolled to process");
	Thread.sleep(6000);
	actionutil.clickOnElement(process, "Process is clicked");
	Thread.sleep(5000);
	
	
	actionutil.clickOnElement(processadd, "Process add is clicked");
	Thread.sleep(1000);
	actionutil.clickOnElement(sharedproduct, "sharedproduct is clicked");
	Thread.sleep(1000);
	actionutil.clickOnElement(productidtextnew, "Product id is clicked");
	Thread.sleep(2000);
	actionutil.clickOnElement(productselect, "Productselect is clicked");
	actionutil.clickOnElement(processname, "process name is clicked");
	Thread.sleep(2000);
	actionutil.typeText(processname, "disagg", "process name Value is entered");
	Thread.sleep(2000);
	Thread.sleep(2000);
	actionutil.clickOnElement(processloc, "process loc is clicked");
	Thread.sleep(2000);
	actionutil.typeText(processloc, "test", "process name Value is entered");
	Thread.sleep(8000);	
	actionutil.clickOnElement(processlocsearch, "process loc is clicked");
	Thread.sleep(5000);
	actionutil.clickOnElement(processtype, "process type is clicked");
	Thread.sleep(2000);
	actionutil.scrollDown();
	actionutil.clickOnElement(processdisagg, "process discomm is clicked");
	Thread.sleep(2000);
	actionutil.scrollDowntoelement(processadd1);
	//actionutil.scrollDownToBottom();
	actionutil.clickOnElement(processadd1, "process add button is clicked");
	Thread.sleep(8000);
	
	
	
	
		actionutil.clickOnElement(processadd, "Process add is clicked");
	Thread.sleep(1000);
	actionutil.clickOnElement(sharedproduct, "sharedproduct is clicked");
	Thread.sleep(1000);
	actionutil.clickOnElement(productidtextnew, "Product id is clicked");
	Thread.sleep(2000);
	actionutil.clickOnElement(productselect, "Productselect is clicked");
	actionutil.clickOnElement(processname, "process name is clicked");
	Thread.sleep(2000);
		actionutil.typeText(processname, "obs", "process name Value is entered");
		actionutil.clickOnElement(processloc, "process loc is clicked");
		Thread.sleep(2000);
		actionutil.typeText(processloc, "test", "process name Value is entered");
		Thread.sleep(8000);	
		actionutil.clickOnElement(processlocsearch, "process loc is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(processtype, "process type is clicked");
		Thread.sleep(2000);
		actionutil.scrollDown();
		actionutil.clickOnElement(processobs, "process observation is clicked");
		Thread.sleep(2000);
		actionutil.scrollDowntoelement(processadd1);
		//actionutil.scrollDownToBottom();
		actionutil.clickOnElement(processadd1, "process add button is clicked");
		
		
		Thread.sleep(8000);
		//actionutil.clickOnElement(process, "Process is clicked");
		Thread.sleep(5000);
		actionutil.clickOnElement(processadd, "Process add is clicked");
		Thread.sleep(1000);
		actionutil.clickOnElement(sharedproduct, "sharedproduct is clicked");
		Thread.sleep(1000);
		actionutil.clickOnElement(productidtextnew, "Product id is clicked");
		Thread.sleep(2000);
		actionutil.clickOnElement(productselect, "Productselect is clicked");
		actionutil.clickOnElement(processname, "process name is clicked");
		Thread.sleep(2000);
			actionutil.typeText(processname, "tran", "process name Value is entered");
			actionutil.clickOnElement(processloc, "process loc is clicked");
			Thread.sleep(2000);
			actionutil.typeText(processloc, "test", "process name Value is entered");
			Thread.sleep(8000);	
			actionutil.clickOnElement(processlocsearch, "process loc is clicked");
			Thread.sleep(5000);
			actionutil.clickOnElement(processtype, "process type is clicked");
			Thread.sleep(2000);
			actionutil.scrollDown();
			actionutil.clickOnElement(processtra, "process transformation is clicked");
			Thread.sleep(2000);
			actionutil.scrollDowntoelement(processadd1);
			//actionutil.scrollDownToBottom();
			actionutil.clickOnElement(processadd1, "process add button is clicked");
			Thread.sleep(8000);

	}


   
    
    }
