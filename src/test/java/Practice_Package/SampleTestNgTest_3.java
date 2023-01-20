package Practice_Package;

import org.testng.annotations.Test;

public class SampleTestNgTest_3 {
	
	@Test(groups = {"regression","smoke"})
	public void test5() {
		System.out.println("==== test5 ====");
	}
	
	@Test(groups = "smoke")
	public void test6() {
		System.out.println("==== test6 =====");
	}


}
