package Practice_Package;

import org.testng.annotations.Test;

public class SampleTest {
	
	@Test(priority = 0)
	public void create()
	{
		System.out.println("created");
	}
	
	@Test(priority = 1 ,invocationCount = 2)
	public void update()
	{
		System.out.println("updated");
	}
	
	@Test(dependsOnMethods = "update")
	public void delete()
	{
		System.out.println("deleted");
	}

}
