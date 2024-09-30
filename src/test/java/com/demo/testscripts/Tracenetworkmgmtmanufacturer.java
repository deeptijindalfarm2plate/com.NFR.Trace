package com.demo.testscripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.baseutil.Basetest;
import com.demo.baseutil.Basetest2;

public class Tracenetworkmgmtmanufacturer extends Basetest2 {

	/**
	 * Description: Navigating to sigin page verifying UI of the page
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 *
	 */
	
	
	  @Test(priority = 1, description = "Verify UI of the Sigin Page", enabled = true)
	  public void verifytracenwmgmtmanu() throws InterruptedException, IOException {
		  pages.signinpage.verifysigninPage();
		 pages.loginpage.verifyLogin("deeksha.thakur@farmtoplate.io", "Admin@123$$");
		 pages.nwsupp.tracemanusscc();
	//// pages.nwsupp.tracemudulenetworkmgmt();
	 	
	//	 pages.loginpage.verifyLogin("clhijshz193@yopmail.com", "Admin@1234");
	pages.nwsupp.tracemanussccprocess();
	  
	  }
	  
	  	
}