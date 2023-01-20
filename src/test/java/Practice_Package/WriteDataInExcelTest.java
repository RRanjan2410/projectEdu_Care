package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis= new FileInputStream("./src/test/resources/StudentManagementSystem.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("System testing ").getRow(9).getCell(9).setCellValue("data");
		FileOutputStream fos=new FileOutputStream("./src/test/resources/StudentManagementSystem.xlsx");
		wb.write(fos);

	}

}
