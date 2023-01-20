package com.crm.GenricUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.iterators.ObjectArrayIterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {
	/**
	 * this is generic method to read the data from excel
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws Throwable 
	 * @throws Throwable
	 */

	public String readDataFromExcelSheet(String SheetName,int RowNo,int ColumnNo) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(RowNo);
		Cell ce = ro.getCell(ColumnNo);
		String value=ce.getStringCellValue();

		return value;

	}

	public void writeDataIntoExcelSheet(String SheetName,int RowNo,int ColumnNo,String data) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(RowNo);
		Cell ce = ro.getCell(ColumnNo);
		ce.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IPathConstant.ExcelPath);
		wb.write(fos);

	}

	public int getLastRowNo(String SheetName) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int count=sh.getLastRowNum();
		return count;
	}
	
	public ArrayList<String> getList(String SheetName,int CellNo) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastrow=sh.getLastRowNum();
		ArrayList<String> al=new ArrayList<String>();
		
		for (int i = 0; i <=lastrow; i++) {
			String value = sh.getRow(i).getCell(CellNo).getStringCellValue();
			al.add(value);
			}
		return al;
	}

	public Map<String, String>getList(String SheetName,int KeyCell,int ValueCell) throws Throwable{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int count=sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i <=count; i++) {
			String key = sh.getRow(i).getCell(KeyCell).getStringCellValue();
			String value = sh.getRow(i).getCell(ValueCell).getStringCellValue();
			map.put(key, value);
		}
		return map;	
	}
	
	public Object[][] readMultipleSetOfData(String SheetName) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastrow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastrow][lastCell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}


