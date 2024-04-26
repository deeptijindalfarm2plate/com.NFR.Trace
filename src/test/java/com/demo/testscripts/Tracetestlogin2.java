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

public class Tracetestlogin2 extends Basetest2 {

	/**
	 * Description: Navigating to sigin page verifying UI of the page
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 *
	 */
	
	  @DataProvider(name = "loginData")
	    public Object[][] getLoginData() throws IOException, EncryptedDocumentException, InvalidFormatException {
	        // Provide the path to your Excel file
		  String userDir = System.getProperty("user.dir");
	        String filePath = userDir + "/src/test/resources/data/data.xlsx";
	        String sheetName = "Sheet1";

	        FileInputStream fileInputStream = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fileInputStream);
	        Sheet sheet = workbook.getSheet(sheetName);
	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

	        Object[][] data = new Object[rowCount - 1][colCount];

	        for (int i = 1; i < rowCount; i++) {
	            for (int j = 0; j < colCount; j++) {
	                Cell cell = sheet.getRow(i).getCell(j);
	                data[i - 1][j] = cell.getStringCellValue();
	            }
	        }

	        workbook.close();
	        fileInputStream.close();

	        return data;
	    }
	
	 
	  
	  
	   @Test(dataProvider = "loginData", priority = 1, description = "Verify the Login", enabled = true)
	    public void verifyLogin1(String emailid, String passwordid) throws InterruptedException, IOException {
		   pages.signinpage.verifysigninPage(); 
		   pages.loginpage2.verifyLogin1(emailid, passwordid);
		    pages.logout.verifylogout();
		    
	    
	  }
	   
	 
	
	
}