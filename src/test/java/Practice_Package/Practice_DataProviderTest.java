package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practice_DataProviderTest {
	
	@Test(dataProvider = "data")
	public void travel(String src,String dst,int fare,int dist)
	{
		System.out.println("from"+src+" -------> "+"to "+dst+fare+dist);
	}
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] objrr=new Object[4][4];
		
		objrr[0][0]="bangalore";
		objrr[0][1]="patna";
		objrr[0][2]=15000;
		objrr[0][3]=1600;
		
		objrr[1][0]="patna";
		objrr[1][1]="bangalore";
		objrr[1][2]=7000;
		objrr[1][3]=1600;
		
		objrr[2][0]="bangalore";
		objrr[2][1]="mysore";
		objrr[2][2]=150;
		objrr[2][3]=143;
		
		objrr[3][0]="mysore";
		objrr[3][1]="bangalore";
		objrr[3][2]=150;
		objrr[3][3]=143;
		
		return objrr;
	}

}
