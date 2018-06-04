package com.marlonviado.concrete;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CCalendar {
	
	String fromDate;
	String toDate;
	
	public CCalendar() {
		
	}
	
	public CCalendar(String fromDate, String toDate) {
		this.fromDate=fromDate;
		this.toDate=toDate;
	}
	
	public String getFromDate() {
		return this.fromDate;
	}
	
	public String getToDate() {
		return this.toDate;
	}
	
	public int compute(long dateDiff) {
		return (int)(dateDiff/(1000*60*60*24));
	}
	
	public int DateDiff(String from, String to) throws ParseException {
		
		SimpleDateFormat dd1 = new SimpleDateFormat("MM-dd-yyyy");
		SimpleDateFormat dd2 = new SimpleDateFormat("MM-dd-yyyy");

		Date fromDate = dd1.parse(from);
		Date toDate = dd2.parse(to);
		
		long dateDiff = toDate.getTime() - fromDate.getTime();
		
		return this.compute(dateDiff);

	}

}
