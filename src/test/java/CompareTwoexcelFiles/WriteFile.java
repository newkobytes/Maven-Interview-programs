package CompareTwoexcelFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteFile {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		String path = "./EXCELDATA-3.xlsx";
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet=workbook.createSheet("sheet1");
		Object[][] data= {
				{"Name","Age","City"},{"aaa",20,"city1"},{"bbb",25,"city2"},{"ccc", 30,"city3"}	
		};
		int rowcount=0;
		for(Object[] rowdata: data)
		{
		Row row =sheet.createRow(rowcount++);
		int colcount=0;
		for(Object celldata: rowdata)
		{
			
			Cell cell = row.createCell(colcount++);
			if(celldata instanceof String )
			{
				cell.setCellValue((String) celldata);
			}
			else if(celldata instanceof Integer)
			{
				cell.setCellValue((Integer) celldata);
			}
		}
		}
		
		 for (int i = 0; i < data[0].length; i++) {
	            sheet.autoSizeColumn(i);
	        }

	        FileOutputStream outputStream = new FileOutputStream(path);
	        workbook.write(outputStream);
	        outputStream.close(); // Close FileOutputStream manually
	        workbook.close();
	}

}
