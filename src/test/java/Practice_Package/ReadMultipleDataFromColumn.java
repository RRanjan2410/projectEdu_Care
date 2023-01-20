package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromColumn {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis= new FileInputStream("./src/test/resources/StudentManagementSystem.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Autor List");
		int count=sh.getLastRowNum();
		   Row ro = sh.getRow(count);
		   int counts = ro.getLastCellNum();
		for (int i =0; i <count; i++) {
			for (int j = 0; j <counts; j++) {
				
			
			String data=sh.getRow(i).getCell(j).getStringCellValue();
			System.out.println(data);
			}
		}

	}
;
}
