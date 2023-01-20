package Practice_Package;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GetAllLinks {
	public static void main(String[] args) throws Throwable {
		
	
	File f=new File("./src/test/resources/DataCommon.properties");
	f.createNewFile();
	
	Properties p= new Properties();
	p.setProperty("FirstName", "Rishi");
	p.setProperty("LastName", "Ranjan");
	
	FileOutputStream fos=new FileOutputStream(f);
	p.store(fos, "Test Data");
	fos.close();
}
}
