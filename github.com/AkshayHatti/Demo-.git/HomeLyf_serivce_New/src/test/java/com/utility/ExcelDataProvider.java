package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
XSSFWorkbook workb;
	
	public void getdata() throws IOException 
	{
		String excelpath=System.getProperty("user.dir")+"\\ExcelTestData\\Data.xlsx";
		File src=new File(excelpath);
		
		FileInputStream file=new FileInputStream(src);
		workb=new XSSFWorkbook(file);
	}
	//for string data
	public String getStringData(String sheetname, int row, int column)
	{
		return workb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	//for numeric data
	public double getNumericData(String sheetname, int row, int column)
	{
		return workb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}

}









//public static String getData(int row, int cell) throws EncryptedDocumentException, IOException {
//	
//	String data;
////	FileInputStream excel = new FileInputStream(System.getProperty("user.dir")+"//ExcelTestData/exceldata.xlsx");
//	FileInputStream excel = new FileInputStream("E:Desktop\\HomeLyf_Service\\HomeLyf_serivce_New\\ExcelTestData\\exceldata.xls");
//	Sheet inputdata = WorkbookFactory.create(excel).getSheet("Sheet1");
//	
//	try {
//		
//		data = inputdata.getRow(row).getCell(cell).getStringCellValue();
//	
//	}catch(Exception e) {
//		long intdata = (long)inputdata.getRow(row).getCell(cell).getNumericCellValue();
//
//		data = ""+intdata;
//	}
//
//	return data;
//}
//}