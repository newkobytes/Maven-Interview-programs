package CompareTwoexcelFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
String path = "./EXCELDATA-1.xlsx";
File file = new File(path);
FileInputStream fis = new FileInputStream(file);
Workbook wb = new XSSFWorkbook(file);
int sheetcount = wb.getNumberOfSheets();
for(int i=0;i<sheetcount;i++)
{
Sheet sheet = wb.getSheetAt(i);
for (Row row : sheet) {
    for (Cell cell : row) {
        switch (cell.getCellType()) {
            case STRING:
                System.out.print(cell.getStringCellValue() + "\t\t");
                break;
            case NUMERIC:
                System.out.print(cell.getNumericCellValue() + "\t\t");
                break;
	}
	
}
System.out.println();
}



}

	}}




	

