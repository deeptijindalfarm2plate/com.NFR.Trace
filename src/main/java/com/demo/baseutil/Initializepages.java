package com.demo.baseutil;

import org.openqa.selenium.WebDriver;

import com.demo.pages.Tracelogin;
import com.demo.pages.Tracelogin2;
import com.demo.pages.Tracesigninpage;
import com.demo.pages.Tracesignuppage;
import com.demo.pages.Tracelogout;
import com.demo.pages.Tracemodules;
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
	public Tracemodules modules;
	
	
	public Initializepages(WebDriver driver, long eto, WebActionUtil actionutil) {

		signinpage = new Tracesigninpage(driver, eto, actionutil);
		loginpage = new Tracelogin(driver, eto, actionutil);
		loginpage2 = new Tracelogin2(driver, eto, actionutil);
		logout = new Tracelogout(driver, eto, actionutil);
		signup= new Tracesignuppage(driver, eto,actionutil);
		modules= new Tracemodules(driver, eto, actionutil);
		
	}

}
