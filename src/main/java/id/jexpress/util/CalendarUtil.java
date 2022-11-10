package id.jexpress.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {

	public static Date setDateNowForQuery() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();

	}

	public static Date setDateForQuery(Integer hour, Integer minute,
			Integer second, Integer millisecond, Integer day) {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.MILLISECOND, millisecond);
		cal.add(Calendar.DATE, day);
		return cal.getTime();

	}

	@SuppressWarnings("deprecation")
	public static Date setDateEndOfDayForQuery(Date date) {
		date.setHours(23);
		date.setMinutes(59);
		date.setSeconds(59);
		return date;

	}
	
	@SuppressWarnings("deprecation")
	public static Date setDateCustomHourForQuery(Date date, 
			Integer hour, Integer minute, Integer second) {
		date.setHours(hour);
		date.setMinutes(minute);
		date.setSeconds(second);
		return date;

	}

	public static String setFormatDateForDatePicker(Date date) {

		String[] dateSplit = date.toString().split(" ");
		return dateSplit[0] + " " + dateSplit[1] + " " + dateSplit[2] + " "
				+ dateSplit[5] + " " + dateSplit[3];

	}
	
	@SuppressWarnings("deprecation")
	public static String setFormatDateForPagination(Date date) {

		int month = date.getMonth() + 1;
		int year = date.getYear() + 1900;
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(date.getDate());
		stringBuilder.append("-");
		stringBuilder.append(month);
		stringBuilder.append("-");
		stringBuilder.append(year);
		
		return stringBuilder.toString();

	}
	
	public static Date convertStringToDate(String date, 
			String month, String year) {
		
		String dateString = date + "/" + month + "/" + year;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		Date dateResult = null;
		try {
			dateResult = df.parse(dateString);
//		    String newDateString = df.format(dateResult);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		return dateResult;
		
	}
	
	public static Date setDateTime(Date dateInput, 
			Integer hour, 
			Integer minute,
			Integer second, 
			Integer millisecond) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(dateInput);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.MILLISECOND, millisecond);
		return cal.getTime();

	}
	
	public static Date addDayOfDate(Date dateInput, 
			Integer numOfDay) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(dateInput);
		cal.add(Calendar.DATE, numOfDay);
		return cal.getTime();

	}

}
