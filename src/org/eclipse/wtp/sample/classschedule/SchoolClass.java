package org.eclipse.wtp.sample.classschedule;

public class SchoolClass {
	private String title;
	private int day;
	private int startTime;
	private int endTime;
	
	public SchoolClass(String title, int day, int startTime, int endTime) {
		this.title = title;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getTitle() {
		return title;
	}

	public int getDay() {
		return day;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}
	
}
