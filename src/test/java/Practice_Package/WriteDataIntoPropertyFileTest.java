package Practice_Package;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataIntoPropertyFileTest {

	public static void main(String[] args) throws Throwable {
		//FileInputStream fis= new FileInputStream("./src/test/resources/CommonData.properties")
				File f=new File("./src/test/resources/CommonData.properties");
				f.createNewFile();
				
				Properties p= new Properties();
				p.setProperty("FirstName", "Rishi");
				p.setProperty("LastName", "Ranjan");
				
				FileOutputStream fos=new FileOutputStream(f);
				p.store(fos, "Test Data");
				fos.close();

	}

}
