package com.epocconverter.responsevalidation;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import io.restassured.response.Response;

public class Responsevalidation {
	
	public static void statuscodevalidation(Response res,int expectedstatusresult)
	{
		int actualstatusresult=res.statusCode();
		if(actualstatusresult==expectedstatusresult)
		{
			System.out.println("Status code is validated");
		}
		else
		{
			System.out.println("Status code is not validated");
		}
		
	}
	
	public static void datevalidation(long timestamp) 
	{
	    // Convert timestamp to a Date object
	    Date date = new java.util.Date(timestamp * 1000L);
	    
	    // Format the date with timezone information
	    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
	    sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4"));
	    String formattedDate = sdf.format(date);
	    System.out.println(formattedDate);
	    
	    // Parse the string to a LocalDate object
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
	    LocalDate date1 = LocalDate.parse(formattedDate, formatter);
	    
	    // Extract only the date portion
	    LocalDate justDate = date1.withDayOfMonth(date1.getDayOfMonth());
	    
	    // Print the date
	    System.out.println(justDate);
	    
	    // Check if timestamp matches LocalDate
	    if (formattedDate.contains(justDate.toString())) {
	        System.out.println("Date is matching");
	    } else {
	        System.out.println("Date is not validated");
	    }
	}

	
	public static void datavalidation1(long unix_seconds)
	{
		Date date = new Date(unix_seconds*1000L); 
		   // format of the date
		   SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		   jdf.setTimeZone(TimeZone.getTimeZone("GMT+4"));
		   String java_date = jdf.format(date);
		   System.out.println("\n"+java_date+"\n");

}
}