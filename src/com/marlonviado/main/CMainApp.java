/*
 * Marlon Viado
 */
package com.marlonviado.main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.marlonviado.concrete.CSchedule;
import com.marlonviado.concrete.CTask;
import com.marlonviado.concrete.CProcess;

public class CMainApp {

	public static void main(String[] args) throws ParseException {
		List<CTask> taskList = new ArrayList<>();
		int taskCounter=1;
		List<CTask> strSubList=null;

		/*
		 * Set of schedule for every task
		 * The Date Format should always be (mm-dd-yyyy)
		 */

		CSchedule[] schedule = {new CSchedule("01-02-2002","01-06-2002"),
		 						new CSchedule("01-09-2002","01-13-2002"),
		 						new CSchedule("01-01-2002","01-03-2002"),
		 						new CSchedule("01-06-2002","01-08-2002"),
		 						new CSchedule("01-08-2002","01-10-2002")};

		int p=10;
		int subTaskCounter=1;
		int taskNo=schedule.length-1;

		for(CSchedule s: schedule) {
			taskList.add(new CTask("Task " + taskCounter,s,s.calculateDuration(),p));
			if(subTaskCounter<=taskNo) {
				strSubList = taskList.subList(0, taskList.size());
				for(int i=1; i<=3; i++) {
					strSubList.add(new CTask("Task " + taskCounter + " - " + "Subtask " + i,s,s.calculateDuration(),p));
				}
			}
			else {
				strSubList = taskList.subList(0, taskList.size());
				for(int i=1; i<=3; i++) {
					strSubList.add(new CTask("Task " + taskCounter + " - " + "Blank ",s,s.calculateDuration(),p));
				}
			}
			subTaskCounter++;
			p-=2;
			taskCounter++;
		}

		Collections.sort(taskList);

		System.out.printf("PROJECT PLAN SCHEDULE AND TASK\n");
		System.out.printf("------------------------------\n");
		for(int i=0; i<taskList.size(); i++) {
			CTask tt = taskList.get(i);
			if(!tt.getName().contains("Blank")) {
				if(tt.getName().contains("Subtask")) {
					System.out.printf("%s.\n",tt.getName());
				}
				else {
					System.out.printf("%s Schedule (%s up to %s) with %d Days Duration.\n",tt.getName(),
							 															   tt.getSchedule().getFromDate(),
							 															   tt.getSchedule().getToDate(),
							 															   tt.getDuration());
				}
			}
		}

		System.out.printf("\nSTARTED AND COMPLETED TASK\n");
		System.out.printf("--------------------------\n");
		String noSubTask="";

		for(CTask t: taskList) {
			String subTask = t.getName();
			if(subTask.contains("Blank")) {
				noSubTask=subTask;
			}
			else {
				if(subTask.contains("Subtask") && subTask.length()>7) {
					CProcess process = new CProcess(subTask,t,t.getPriority());
					p-=2;
					process.start();
				}
				else if(subTask.length()>=6){
					if(noSubTask.length()<=0) {

					}
					else {
						CProcess process = new CProcess(noSubTask,t,t.getPriority());
						p-=2;
						process.start();
						noSubTask="";
					}

				}

			}

		}

		System.out.println("BYE...");

	}

}
