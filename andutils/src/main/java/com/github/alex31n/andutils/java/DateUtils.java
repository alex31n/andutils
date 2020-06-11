package com.github.alex31n.andutils.java;


import android.annotation.SuppressLint;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

	public final static String DATE_d_M_y = "d/M/y";


	/**
	 * <p>return current date with given format.</p>
	 *
	 * @param format a Date Format.
	 *
	 * @return the String of current Date.
	 */
	public static String getDate(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}

	public static long getDateLong() {
		return new Date().getTime();
	}

	public static long dateToLong(String date, String format) throws ParseException {
		@SuppressLint("SimpleDateFormat")
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		Date d = sdf.parse(date);
		long dateLong = d.getTime();
		return dateLong;
	}

	public static String dateToString(long date, String format){
		Date d = new Date(date);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateText = sdf.format(date);
		return dateText;
	}


	public static String dateToSql(long date) {
		/*Date d = new Date(date);
		SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m:s");
		String dateText = sdf.format(d);
		return dateText;*/
		return dateToSql(new Date(date));
	}

	public static String dateToSql(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m:s");
		String dateText = sdf.format(date);
		return dateText;
	}


	/**
	 * <p>return boolean value if two long date are on the same day with ignoring time.</p>
	 *
	 * <p>20 Jun 2015 15:45 and 20 Jun 2015 05:15 would return true.
	 * 20 Jun 2015 15:45 and 25 Jun 2015 09:10 would return false.
	 * </p>
	 */
	public static boolean isSameDay(final long date1, final long date2) {
		if (date1 <= 0 || date2 <= 0) {
			throw new IllegalArgumentException("The date must be positive long");
		}
		final Calendar cal1 = Calendar.getInstance();
		cal1.setTime(new Date(date1));
		final Calendar cal2 = Calendar.getInstance();
		cal2.setTime(new Date(date2));
		return isSameDay(cal1, cal2);
	}


	/**
	 * <p>return boolean value if two date are on the same day with ignoring time.</p>
	 *
	 * <p>20 Jun 2015 15:45 and 20 Jun 2015 05:15 would return true.
	 * 20 Jun 2015 15:45 and 25 Jun 2015 09:10 would return false.
	 * </p>
	 */
	public static boolean isSameDay(final Date date1, final Date date2) {
		if (date1 == null || date2 == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		final Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		final Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		return isSameDay(cal1, cal2);
	}

	/**
	 * <p>return boolean value if two calender are on the same day with ignoring time.</p>
	 *
	 * <p>20 Jun 2015 15:45 and 20 Jun 2015 05:15 would return true.
	 * 20 Jun 2015 15:45 and 25 Jun 2015 09:10 would return false.
	 * </p>
	 */
	public static boolean isSameDay(final Calendar cal1, final Calendar cal2) {
		if (cal1 == null || cal2 == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
			  cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
			  cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
	}


	/**
	 * <p> remove time from given long date </p>
	 *
	 * <p>
	 *       20 Jun 2015 15:45 and it will return 20 Jun 2015;
	 * </p>
	 */

	public static long removeTime(long date) {
		if (date <=0 ) {
			throw new IllegalArgumentException("The date must not be null");
		}

		return removeTime(new Date(date)).getTime();
	}


	/**
	 * <p> remove time from given date </p>
	 *
	 * <p>
	 *       20 Jun 2015 15:45 and it will return 20 Jun 2015;
	 * </p>
	 */

	public static Date removeTime(Date date) {
		if (date == null ) {
			throw new IllegalArgumentException("The date must not be null");
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}


	public static int getDay(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);

		return day;
	}

	public static int getMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		return month+1;
	}

	public static int getYear(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		return year;
	}


	/**
	 * <p> Return all month with full name  </p>
	 *
	 * <p> example: "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"</p>
	 */
	public static String[] getFullMonths(){
		return new DateFormatSymbols().getMonths();
	}



	/**
	 * <p> Return all month with short name  </p>
	 *
	 * <p> example: "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"</p>
	 */
	public static String[] getShortMonths(){
		return new DateFormatSymbols().getShortMonths();
	}


	/**
	 * <p> Return a string array of short name all month by Locate   </p>
	 *
	 * <p> example for Locale.US: "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"</p>
	 * "December"</p>
	 */
	public static String[] getFullMonthsWithLocale(final Locale locale){
		if (locale == null){
			throw new NullPointerException("The locale must not be null");
		}
		return new DateFormatSymbols(locale).getMonths();
	}


	/**
	 * <p> Return a string array of full name all month by Locate   </p>
	 *
	 * <p> example for Locale.US: "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November",
	 * "December"</p>
	 */
	public static String[] getShortMonthsWithLocale(Locale locale){
		if (locale == null){
			throw new NullPointerException("The locale must not be null");
		}
		return new DateFormatSymbols(locale).getShortMonths();
	}



	public static String[] getYears(final int yearMin, final int yearMax) {
		if (yearMin<=0 || yearMax<=0) {
			throw new IllegalArgumentException("The date must not be null");
		}

		int range = yearMax-yearMin;

		if (range <0){
			throw new IllegalArgumentException("The minimum year must not be grater than maximum year");
		}
		range++;
		//Log.e("ALEX","range "+range);
		String[] years = new String[range];

		for (int i = 0; i<range; i++){
			years[i] = String.valueOf(yearMin+i);
			//Log.e("ALEX", "year: " + years[i]);
		}

		return years;
	}



	/**
	 * <p> Returns the first millisecond value of date month </p>
	 *
	 * <p> example: 20 Jun 2015 15:45 and it will return 1 Jun 2015 00:00:00;</p>
	 *
	 * @param date
	 *            a Date instance.
	 *
	 * @return the number of milliseconds of first day.
	 */

	public static long beginningOfMonth(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.set(Calendar.DAY_OF_MONTH,
			  calendar.getActualMinimum(Calendar.DAY_OF_MONTH));

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTimeInMillis();
	}


	/**
	 * <p>Returns the last millisecond value of date month</p>
	 *
	 * <p> 20 Jan 2015 15:45 and it will return 31 jan 2015 23:59:59;</p>
	 *
	 * @param date
	 *            a Date instance.
	 *
	 * @return the number of milliseconds of first day.
	 */

	public static long endingOfMonth(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,
			  calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);

		return calendar.getTimeInMillis();
	}


	public static String changeDateFormat(String date, String oldFormat, String newFormat) throws  ParseException{
		String newDate ="";
		try {
			long dateLong = dateToLong(date,oldFormat);
			newDate = dateToString(dateLong, newFormat);
		}catch (ParseException ex){
			throw new ParseException("Old format is wrong",ex.getErrorOffset());
		}

		return newDate;
	}

}
