package WriteData;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class WriteData_into_CsvFile {

	public static void main(String[] args) throws IOException {
		// First add two dependencies
//--Approach 1:
	
		//Instantiating the CsvWriterClass:
		CSVWriter write = new CSVWriter(new FileWriter("./WriteCSVData/CSV Document1.csv"));
		
		//Write data into csv file:
		String set1[] = {"Name", "Relation", "Profession", "Salary"};
		String set2[] = {"Ganesan", "Appa","Farmer", "10000"};
		String set3[] = {"Sasikala","Amma","House Wife","1000"};
		String set4[] = {"Hema","Elder Sis","engineer","2000"};
		String set5[] = {"Shivu","Husband","Software Tester","60000"};
	/*	
		write.writeNext(set1);
		write.writeNext(set2);
		write.writeNext(set3);
		write.writeNext(set4);
		write.writeNext(set5);
		
		//Flush data into the csv file:
		write.flush();
		System.out.println("Data is entered into the csv file");
		*/
		
//Approach 2: Using Array list and WriteALL method:
		
		List list = new ArrayList();
		list.add(set1);
		list.add(set2);
		list.add(set3);
		list.add(set4);
		list.add(set5);
		
		write.writeAll(list);
		write.flush();
		System.out.println("Data entered into the csv file using WriteALl approach 2 method");
	}

}
