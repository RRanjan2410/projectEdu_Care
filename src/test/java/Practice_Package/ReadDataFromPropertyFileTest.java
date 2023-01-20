package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertyFileTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis= new FileInputStream("./src/test/resources/common.properties");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String browser=p.getProperty("browser");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		System.out.println(url);
		System.out.println(browser);
		System.out.println(un);
		System.out.println(pw);


	}

}
