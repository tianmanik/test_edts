package com.test.edts.util;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class GeneralUtil {

	public static Timestamp stringToTimestamp(String dateStr) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parsedDate = dateFormat.parse(dateStr);
		return new Timestamp(parsedDate.getTime());

	}

	public static Timestamp now (){
		long currentTimeMillis = System.currentTimeMillis();

		// Create a Timestamp object using the current time
		return  new Timestamp(currentTimeMillis);
	}


}
