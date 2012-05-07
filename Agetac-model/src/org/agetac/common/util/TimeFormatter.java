package org.agetac.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeFormatter {

	public static String getGroupeHoraire(Date d){

		String res="";

		Calendar c = new GregorianCalendar();
		c.setTime(d);
		int minutes = c.get(Calendar.MINUTE);
		int heures = c.get(Calendar.HOUR_OF_DAY);

		if(heures < 10 ) {res = "0" + heures;}
		else {res = "" + heures;}

		if (minutes < 10) {res = res +"0" + minutes;}
		else { res = res + minutes;}

		return res;
	}
}
