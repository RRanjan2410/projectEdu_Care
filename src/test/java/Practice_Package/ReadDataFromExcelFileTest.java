package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFileTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis= new FileInputStream("./src/test/resources/StudentManagementSystem.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 String data = wb.getSheet("System testing ").getRow(13).getCell(3).getStringCellValue();
		 System.out.println(data);

	}

}
