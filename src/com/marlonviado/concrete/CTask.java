package com.marlonviado.concrete;

import java.util.ArrayList;
import java.util.List;

public class CTask implements Comparable<CTask> {

	private CSchedule schedule;
	private String name;
	private int duration;
	public static List<String> strList = new ArrayList<>();
	private int priority;
	
	public CTask(String name) {
		this.name=name;
	}
	
	public CTask(String name, CSchedule schedule, int duration, int priority) {
		this(name);
		this.schedule=schedule;
		this.duration=duration;
		this.priority=priority;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public CSchedule getSchedule() {
		return this.schedule;
	}
	
	public int compareTo(CTask task) {
		return this.getSchedule().getFromDate().compareTo(task.getSchedule().getFromDate());
	}

}
