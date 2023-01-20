package Practice_Package;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryClassTest {
	
	@Test(retryAnalyzer = com.crm.GenricUtilities.RetryAnalyserImpClass.class)
	public void runSample() {
		Assert.assertEquals("A", "b");
	}

}
