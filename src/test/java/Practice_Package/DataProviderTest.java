package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenricUtilities.ExcelUtility;

public class DataProviderTest {
	
	@Test(dataProvider = "getData")
	public void readData(String state,String capital) {
		System.out.println(state+"------->"+capital);
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		Object[][] value = eLib.readMultipleSetOfData("DataProvider");
		return value;
	}

}
