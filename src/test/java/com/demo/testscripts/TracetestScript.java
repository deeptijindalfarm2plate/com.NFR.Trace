package com.demo.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.demo.baseutil.Basetest;

public class TracetestScript extends Basetest {

	/**
	 * Description: Navigating to sigin page verifying UI of the page
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 *
	 */
	
	
	  @Test(priority = 1, description = "Verify UI of the Sigin Page", enabled = true)
	  public void verifysignin() throws InterruptedException {
	  pages.signinpage.verifysigninPage();
	  }
	  
	  @Test(priority = 2, description = "Verify the Login", enabled =
	  true) public void verifyLogin() throws InterruptedException {
	  pages.loginpage.verifyLogin("utsav@paramountsoft.net", "Admin@1234"); }
	 
	  
	 @Test(priority = 3, description = "Verify the Logout", enabled =
	 true) public void verifylogout() throws InterruptedException {
	  pages.logout.verifylogout();
	  }
	 
	/* @Test(priority = 4, description = "Sign up form fill", enabled = true) public
	 * void verifysignupPage() throws InterruptedException {
	 * pages.signup.verifysignup(); }
	 */
	
	
}