package com.demo.baseutil;

import org.openqa.selenium.WebDriver;

import com.demo.pages.Tracelogin;

import com.demo.pages.Tracesigninpage;
import com.demo.pages.Tracelogout;

import com.demo.util.WebActionUtil;
import com.demo.mail.Gmail;

/**
 * Description: Initializes all pages with driver instance ,Explicit Time out,
 * WebAactionUtility using variables driver,ETO,WebactionUtil
 *
 * @author : Deepti jindal
 */
public class Initializepages extends Basetest {

	public Tracesigninpage signinpage;
	public Tracelogin loginpage;
	public Tracelogout logout;
	
	public Initializepages(WebDriver driver, long eto, WebActionUtil actionutil) {

		signinpage = new Tracesigninpage(driver, eto, actionutil);
		loginpage = new Tracelogin(driver, eto, actionutil);
		logout = new Tracelogout(driver, eto, actionutil);
		
	}

}
