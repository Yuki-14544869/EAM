package com.heu.eam.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String dateToString(Date time) {

		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String stringTime = formatter.format(time);
		return stringTime;
	}

	public static String dateToString(Date time, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String stringTime = formatter.format(time);
		return stringTime;

	}


}
