package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenricUtilities.ExcelUtility;

public class DataProviderFromExcel {
	
	@Test(dataProvider = "getData")
	public void readData(String state,String capital,String food) {
		System.out.println(state+" -------> "+capital+" ---> "+food);
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		Object[][] value = eLib.readMultipleSetOfData("DataUpdate");
		return value;
	}

}
