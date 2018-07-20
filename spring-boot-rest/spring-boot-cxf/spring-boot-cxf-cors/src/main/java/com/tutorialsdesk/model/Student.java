package com.tutorialsdesk.model;

public class Student {

	private int rollNumber;
	private String name;
	
	
	private String course;

	public Student() {
		super();
	}
	
	public Student(int rollNumber, String name, String course) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.course = course;
	}

	public int getRollNumber() {
		return rollNumber;
	}
	
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}

}
