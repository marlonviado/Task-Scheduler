package com.marlonviado.concrete;

import java.text.ParseException;

public class CSchedule {
	
	private String fromDate;
	private String toDate;
	private CCalendar c;
	
	public CSchedule(String fromDate, String toDate) {
		this.fromDate=fromDate;
		this.toDate=toDate;
	}
	
	public String getFromDate() {
		return this.fromDate;
	}
	
	public String getToDate() {
		return this.toDate;
	}
	
	public int calculateDuration() throws ParseException {

		this.c = new CCalendar(this.fromDate,this.toDate);
		
		int duration = c.DateDiff(c.getFromDate(), c.getToDate());

		return duration;

	}
	
}
