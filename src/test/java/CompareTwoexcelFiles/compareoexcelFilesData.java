package CompareTwoexcelFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class compareoexcelFilesData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		compareoexcelFilesData c= new compareoexcelFilesData();
		boolean equal = c.comparefiles();
		if(equal)
			System.out.println("Data is equal");
		else
			System.out.println("Data is not equal");
		
	}
	
	public static boolean comparefiles() throws IOException
	{
		String path1 = "./EXCELDATA-1.xlsx";
	String path2 = "./EXCELDATA-2.xlsx";
		
		File file1= new File(path1);
		File file2= new File(path2);
		FileInputStream fis1 = new FileInputStream(file1);
		FileInputStream fis2 = new FileInputStream(file2);
		Workbook workbook1 = new XSSFWorkbook(fis1);
		Workbook workbook2 = new XSSFWorkbook(fis2);
		
		if(workbook1.getNumberOfSheets()!=workbook2.getNumberOfSheets())
		{
			return false;
		}
		
		for(int i=0;i<workbook1.getNumberOfSheets();i++)
		{
			Sheet sheet1 = workbook1.getSheetAt(i);
			Sheet sheet2 = workbook2.getSheetAt(i);
			
			if(sheet1.getPhysicalNumberOfRows()!=sheet2.getPhysicalNumberOfRows())
			{
				return false;
			}
			
			for(int j=0; j<sheet1.getPhysicalNumberOfRows();j++)
			{
				Row row1 = sheet1.getRow(j);
				Row row2 = sheet2.getRow(j);
				
				if(row1.getPhysicalNumberOfCells()!= row2.getPhysicalNumberOfCells())
				{
					return false;
				}
				
				for(int k=0;k<row1.getPhysicalNumberOfCells();k++)
				{
					Cell cell1= row1.getCell(k);
					Cell cell2 = row2.getCell(k);
					
					if(cell1==null && cell2==null)
					{
						return false;
					}
					if(cell1==null || cell2==null)
					{
						return false;
					}
					if(!cell1.toString().equals(cell2.toString()))
					{
						return false;
					}
				}
				
				
			}
		}
		return true;
	}

}
