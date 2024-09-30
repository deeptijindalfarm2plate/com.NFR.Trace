package com.demo.pages;


	import org.apache.poi.ss.usermodel.*;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	public class Excelupdater {
	    public static void updateExcel(String filePath, String uniqueEmail, String uniqueMobile) throws IOException {
	        FileInputStream fileInputStream = new FileInputStream(filePath);
	        Workbook workbook = new XSSFWorkbook(fileInputStream);
	        Sheet sheet = workbook.getSheetAt(0);

	        // Assuming email is in the 3rd column and mobile is in the 7th column (0-indexed)
	        Row row = sheet.getRow(1);
	        row.getCell(2).setCellValue(uniqueEmail);
	        row.getCell(6).setCellValue(uniqueMobile);

	        fileInputStream.close();

	        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
	        workbook.write(fileOutputStream);
	        workbook.close();
	        fileOutputStream.close();
	    }
	}



