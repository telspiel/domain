package com.noesis.domain.dto;

import java.util.*;
import java.text.*;

public class Date {

	public static boolean isDateValide(String strDate, String format)
	{
	try
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setLenient(false);
		sdf.parse(strDate);
		return true;
	}
	catch(Exception e)
	{
		return false;
	}
	}

	public static void main(String args[])
		{
		// get current date and time

		String sampleDate = "2018-09-18 12:44:00";
		
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
		System.out.println("Current Date:" + sdf.format(currentDate));

		// convert string to date

		try
		{
		String strDate = "11/08/1990";
		SimpleDateFormat sdfBirthday = new SimpleDateFormat("dd/mm/yyyy");
		java.util.Date birthday = sdfBirthday.parse(strDate);
		SimpleDateFormat sdfBirthday1 = new SimpleDateFormat("yyyy-mm-dd");
		System.out.println("Birthday: " + sdfBirthday1.format(birthday));
		}
		catch(Exception e)
		{
		System.out.println(e.getMessage());
		}

		// using calendar

		Calendar c = Calendar.getInstance();
		
		System.out.println("Year:" + c.get(Calendar.YEAR));
		System.out.println("Month:" + c.get(Calendar.MONTH) +1);
		System.out.println("Day of Month:" + c.get(Calendar.DAY_OF_MONTH));
		System.out.println("Hour:" + c.get(Calendar.HOUR));
		System.out.println("Minutes:" + c.get(Calendar.MINUTE));
		System.out.println("Seconds:" + c.get(Calendar.SECOND));

		// check date validation

		if(isDateValide("11/08/1990", "dd/mm/yyyy"))
		System.out.println("Date is valid");
		else
		System.out.println("Date is invalid");
		}
	
}
