package com.demo.baseutil;

import org.openqa.selenium.WebDriver;

import com.demo.pages.Tracelogin;
import com.demo.pages.Tracelogin2;
import com.demo.pages.Tracesigninpage;
import com.demo.pages.Tracesignuppage;
import com.demo.pages.Tracelogout;
import com.demo.pages.Tracenetworkmgmt;
import com.demo.pages.Traceprocess;
import com.demo.pages.Traceproduct;
import com.demo.pages.Traceasset;
import com.demo.pages.Tracedashboard;
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
	public Traceprocess process;
	
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
		process = new Traceprocess(driver, eto,actionutil);
	}

}
