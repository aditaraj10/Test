package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
	static String filepath=".\\testData\\testData.xlsx";
	public static String readExcelData(int rowNum,int cellNum) 
	{
		String data="";
		try{
		Workbook wb=WorkbookFactory.create(new FileInputStream(new File(filepath)));
		data=wb.getSheet("Sheet1").getRow(rowNum).getCell(cellNum).getStringCellValue();
		}
		catch(EncryptedDocumentException e)
		{
			
		}
		catch(InvalidFormatException e)
		{
			
		}
		catch(FileNotFoundException e)
		{
			
		}
		catch(IOException e)
		{
			
		}
		return data;
	}
	public static void WriteExcelData(int rowNum,int cellNum,String data)
	{
		try{
		Workbook wb=WorkbookFactory.create(new FileInputStream(new File(filepath)));
		Cell c = wb.getSheet("Sheet1").getRow(rowNum).createCell(cellNum);
		c.setCellType(Cell.CELL_TYPE_STRING);
		FileOutputStream fos=new FileOutputStream(filepath);
		c.setCellValue(data);
		wb.write(fos);
		}
		catch(EncryptedDocumentException e)
		{
			
		}
		catch(InvalidFormatException e)
		{
			
		}
		catch(FileNotFoundException e)
		{
			
		}
		catch(IOException e)
		{
			
		}
	}

}
