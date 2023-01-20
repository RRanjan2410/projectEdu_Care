package com.crm.GenricUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility 
{
	
	/**
	 * This is generic method to read data from property file
	 * @author Rishi
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromPropertyFile(String key) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(IPathConstant.FilePath);
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
		
	}

}
