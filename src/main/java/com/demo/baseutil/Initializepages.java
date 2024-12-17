package com.demo.baseutil;

import org.openqa.selenium.WebDriver;

import com.demo.pages.Tracelogin;
import com.demo.pages.Tracelogin2;
import com.demo.pages.Tracesigninpage;
import com.demo.pages.Tracesignuppage;
import com.demo.pages.Tracetransactiondisscen5;
import com.demo.pages.Tracetransactiondistsharedscen5;
import com.demo.pages.Tracetransactionmanufacturernew;
import com.demo.pages.Tracetransactionmanufactureshared;
import com.demo.pages.Tracetransactionmanufacturesharedscen4;
import com.demo.pages.Tracetransactionsupplier;
import com.demo.pages.Tracetransactionsupplier;
import com.demo.pages.Traceusers;
import com.demo.pages.Tracelogout;
import com.demo.pages.Tracenetworkmgmt;
import com.demo.pages.Tracenetworkmgmtmanufacturer;
import com.demo.pages.Traceprocessdistributorshared;
import com.demo.pages.Traceprocesssmanufacturernew;
import com.demo.pages.Traceprocesssmanufacturerscen4;
import com.demo.pages.Traceprocesssmanufacturershared;
import com.demo.pages.Traceprocesssupplier;
import com.demo.pages.Traceproduct;
import com.demo.pages.Traceproductmanufacturer;
import com.demo.pages.Traceproductshare;
import com.demo.pages.Tracequestionbank;
import com.demo.pages.Traceroles;
import com.demo.pages.Inventorycapacity;
import com.demo.pages.Inventoryquotation;
import com.demo.pages.Traceassetcontainer;
import com.demo.pages.Traceasset;
import com.demo.pages.Tracedashboard;
import com.demo.pages.Tracedrivers;
import com.demo.pages.Traceinfra;
import com.demo.util.WebActionUtil;
import com.demo.mail.Gmail;

/**
 * Description: Initializes all pages with driver instance ,Explicit Time out,
 * WebAactionUtility using variables driver,ETO,WebactionUtil
 *
 * @author : Deepti jindal
 */
public class Initializepages extends Basetest2 {

	public Tracesigninpage signinpage;
	public Tracelogin loginpage;
	public Tracelogout logout;
	public Tracelogin2 loginpage2;
	public Tracesignuppage signup;
	public Tracedashboard modules;
	public Tracenetworkmgmt nwmgmt;
	public Traceasset assetpage;
	public Traceinfra infrapage;
	public Traceproduct products;
	public Traceprocesssupplier process;
	public Tracetransactionsupplier transaction;
	public Traceusers users;
	public Traceroles roles;
	public Inventorycapacity inventory;
	public Inventoryquotation quotationpage;
	public Traceassetcontainer container;	
	public Tracenetworkmgmtmanufacturer nwsupp;
	public Traceproductshare productshare;
	public Traceproductmanufacturer productmanu;
	public Tracetransactionmanufactureshared transmanu;
	public Traceprocesssmanufacturernew processmanu;
	public Tracetransactionmanufacturernew transactionnew;
	public Tracetransactionmanufacturesharedscen4 transactionscen4;
	public Traceprocesssmanufacturershared processshared;
	public Traceprocesssmanufacturerscen4 processmanuscen4;
	public Tracetransactiondisscen5 trandisscen5;
	public Traceprocessdistributorshared processdisshared;
	public Tracetransactiondistsharedscen5 trandissharedscen5;
	public Tracequestionbank quesbank;
	public Tracedrivers drivers;
	
	
	public Initializepages(WebDriver driver, long eto, WebActionUtil actionutil) {

		signinpage = new Tracesigninpage(driver, eto, actionutil);
		loginpage = new Tracelogin(driver, eto, actionutil);
		loginpage2 = new Tracelogin2(driver, eto, actionutil);
		logout = new Tracelogout(driver, eto, actionutil);
		signup= new Tracesignuppage(driver, eto,actionutil);
		modules= new Tracedashboard(driver, eto, actionutil);
		nwmgmt = new Tracenetworkmgmt(driver, eto, actionutil);
		assetpage= new Traceasset(driver, eto,actionutil);
		infrapage= new Traceinfra(driver, eto,actionutil);
		products = new Traceproduct(driver, eto,actionutil);
		process = new Traceprocesssupplier(driver, eto,actionutil);
		transaction = new Tracetransactionsupplier(driver, eto,actionutil);
		users = new Traceusers(driver,eto, actionutil);
		roles = new Traceroles(driver,eto, actionutil);
		inventory = new Inventorycapacity(driver,eto, actionutil);
		quotationpage = new Inventoryquotation(driver,eto, actionutil);
		container = new Traceassetcontainer(driver,eto,actionutil);
		nwsupp = new Tracenetworkmgmtmanufacturer(driver, eto, actionutil);
		productshare = new Traceproductshare(driver, eto, actionutil);
		productmanu = new Traceproductmanufacturer(driver, eto, actionutil);
		transmanu = new Tracetransactionmanufactureshared(driver, eto, actionutil);
		processmanu = new Traceprocesssmanufacturernew(driver, eto, actionutil);
		transactionnew= new Tracetransactionmanufacturernew(driver,eto, actionutil);
		transactionscen4 = new Tracetransactionmanufacturesharedscen4(driver,eto, actionutil);
		processshared= new Traceprocesssmanufacturershared(driver,eto, actionutil);
		processmanuscen4 = new Traceprocesssmanufacturerscen4(driver, eto, actionutil);
		trandisscen5= new Tracetransactiondisscen5(driver, eto, actionutil);
		processdisshared = new Traceprocessdistributorshared(driver, eto, actionutil);
		trandissharedscen5 =new Tracetransactiondistsharedscen5(driver, eto, actionutil);
		quesbank= new Tracequestionbank(driver,eto, actionutil);
		drivers = new Tracedrivers(driver, eto, actionutil);
	}

}
