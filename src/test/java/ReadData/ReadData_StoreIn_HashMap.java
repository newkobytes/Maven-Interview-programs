package ReadData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadData_StoreIn_HashMap {

	@Test
	public static void GetExcelDataStoredInHAshMap() throws IOException {
		// TODO Auto-generated method stub
		
		Map<String, String> hashmap = new HashMap<String, String>();
		

		FileInputStream fileinput = new FileInputStream("./ExcelData/Data.xlsx");
		Workbook workbook = new XSSFWorkbook(fileinput); 
		Sheet sheet =workbook.getSheetAt(0);
		int lastrow  = sheet.getLastRowNum();
		for(int i=0; i<lastrow;i++)
		{
			Row row =sheet.getRow(i);
			Cell rowcell =row.getCell(0);
			String rowdata=rowcell.getStringCellValue(); //can't be of Integer type
			
			Cell colcell = row.getCell(1);
			String coldata = colcell.getStringCellValue();
			
			
			hashmap.put(rowdata, coldata);
			
		}
		
		Set<Map.Entry<String, String>> entryset = hashmap.entrySet();
		for(Map.Entry<String, String> entry : entryset)
		{
			System.out.println("The Key is " + entry.getKey());
			System.out.println("The Value is " + entry.getValue());
		}
		
	}

}
