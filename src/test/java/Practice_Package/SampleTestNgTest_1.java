package Practice_Package;

import org.testng.annotations.Test;

public class SampleTestNgTest_1 {
	
	@Test(groups = "smoke")
	public void test1() {
		System.out.println("==== test1 ====");
	}
	
	@Test(groups = {"smoke","regression"})
	public void test2() {
		System.out.println("==== test2 =====");
	}
	
	

}
