package com.qiqi.account.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

	public static String getCurrentDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return sdf.format(new Date());
	}

	public static boolean isExpired(Date expireDate) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(new Date());

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(expireDate);

		if (calendar2.after(calendar1)) {
			return false;
		}

		return true;
	}

	public static boolean isExpired(String expireDate) throws ParseException {
		Date _expireDate = StringToDate(expireDate);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(new Date());

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(_expireDate);

		if (calendar2.after(calendar1)) {
			return false;
		}

		return true;
	}

	public static boolean isExpired(Date startDate, int seconds) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(new Date());

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(startDate);
		calendar2.add(Calendar.SECOND, seconds);

		if (calendar2.after(calendar1)) {
			return false;
		}

		return true;
	}

	public static boolean isExpired(String startDate, int seconds)throws ParseException {
		Date _startDate = StringToDate(startDate);
		Calendar currentTime = Calendar.getInstance();
		currentTime.setTime(new Date());

		Calendar requestableTime = Calendar.getInstance();
		requestableTime.setTime(_startDate);
		requestableTime.add(Calendar.SECOND, seconds);

		if (requestableTime.after(currentTime)) {
			return false;
		}
		return true;

	}

	public static String getExpiredTime(Date startDate, int verificationCodeExpireSecond) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.SECOND, verificationCodeExpireSecond);

		return DateToString(calendar.getTime());
	}

	public static Date StringToDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return sdf.parse(date);
	}

	public static String DateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return sdf.format(date);
	}

	public static boolean isToday(String dateTime) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = sdf.parse(getCurrentDateTime());
		Date DBdate = sdf.parse(dateTime);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(today);

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(DBdate);

		if (calendar2.equals(calendar1)) {
			return true;
		}

		return false;
	}
	
	public static void main(String args[]) throws Exception {
		System.out.println(isToday("2016-11-11 01:02:03"));

		//System.out.println(DateToString(new Date()));
	}
}
