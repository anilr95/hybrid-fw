package com.visionit.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.visionit.automation.tests.LoginRegisteredUserTest;

public class ExcelUtil {

	private static final Logger logger = LogManager.getLogger(ExcelUtil.class);
	
	public static Object[][] excelDataProvider(String sheetName) {
		
		try {
			// Fetching the Excel file with given path
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/com/visionit/automation/testdata/AutomationPracticeUserData.xlsx");
			
			// Providing the file path to Workbook Class
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			// Providing sheet name inside the workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			// String from row 1 - As Row zero is having the parameter names of different category
			//Row row = sheet.getRow(1);
			//Cell cell = row.getCell(0);
			// System.out.println(row);
			//System.out.println(cell);

			// initialize the 2-D array with Row X Column
			Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum(); i++)
			{
				for (int j = 0; j <sheet.getRow(0).getLastCellNum(); j++)
				{
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			} 
			return data;

		} catch (FileNotFoundException e) {
			//System.out.println("Excel file in not found on specified path in given location");
			logger.info("Excel file in not found on specified path in given location");
			e.printStackTrace();
		} catch (IOException e) {
			//System.out.println("Excel File could not able to load properly");
			logger.info("Excel File could not able to load properly");
			e.printStackTrace();
		}
		return null;
		
	}

	
}
