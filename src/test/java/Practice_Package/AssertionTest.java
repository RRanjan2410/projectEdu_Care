package Practice_Package;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.annotations.Test.*;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {
	
	@Test
	public void sample1() {
		System.out.println("--- testscript1 ---");
		System.out.println("--- testscript2 ---");
		assertEquals("A", "A");
		System.out.println("--- testscript3 ---");
		System.out.println("--- testscript4 ---");
	}
	
	@Test
	public void sample2() {
		System.out.println("--- testscript5 ---");
		System.out.println("--- testscript6 ---");
		assertNotEquals("A", "a", "Actual does not match expected");
		System.out.println("--- testscript7 ---");
		System.out.println("--- testscript8 ---");
	}
	
	@Test
	public void sample_3() {
		String a=null;
		assertNull(a);
		System.out.println("=======");
	}
	
	@Test
	public void sample_4() {
		System.out.println(" test 9 ");
		SoftAssert s= new SoftAssert();
		s.assertEquals("X", "U");
		System.out.println(" test 10 ");
		s.assertAll();
	}

}
