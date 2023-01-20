package com.crm.GenricUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * @author Rishi
	 * @return
	 */
	public int getRandomNumber() {
		Random ran=new Random();
		int random=ran.nextInt(500);
		return random;
	}
	/**
	 * @author Rishi
	 * @return
	 */
	public String getSystemDate() {
		Date dt= new Date();
		String date= dt.toString();
		return date;
	}

	public String getDateInFormat() {
		SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yy HH:mm:ss");
		Date systemdate = new Date();
		String getDateAndTime=dateformat.format(systemdate);
		
		return getDateAndTime.replaceAll(":", "-");
	}
}
