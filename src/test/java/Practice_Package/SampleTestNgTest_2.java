package Practice_Package;

import org.testng.annotations.Test;

public class SampleTestNgTest_2 {
	
	@Test(groups = "regression")
	public void test3() {
		System.out.println("==== test3 ====");
	}
	
	@Test
	public void test4() {
		System.out.println("==== test4 =====");
	}
	

}
