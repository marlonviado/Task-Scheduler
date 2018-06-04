package com.marlonviado.concrete;

import java.util.concurrent.TimeUnit;

public class CProcess extends Thread {
	
	String name;
	CTask task;
	
	public CProcess(String name, CTask task, int priority) {
		this.name=name;
		this.setName(this.name);
		this.task=task;
		//this.setPriority(priority);
		//System.out.printf("Processing %s with %s to %s schedules and %d Days Duration. %d\n",this.getName(),
		//																						this.task.getSchedule().getFromDate(),
		//																						this.task.getSchedule().getToDate(),
		//																						this.task.getDuration(),
		//																						this.getPriority());
		if(this.getName().contains("Subtask")) {
			System.out.printf("Processing %s.\n",this.getName());
		}
		else {
			System.out.printf("%s Start Processing.\n",this.getName().substring(0, 6));
		}
		
		try {
			TimeUnit.SECONDS.sleep(2);
		}
		catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	public void run() {
		if(this.getName().length()<7) {
			
		}
		else {
			if(this.getName().contains("Blank")) {
				System.out.printf("%s DONE Processing With No Subtask.\n",this.getName().substring(0, 6));
			}
			else {
				System.out.printf("DONE Processing %s.\n",this.getName());
			}
		}
			
	}
	
}
