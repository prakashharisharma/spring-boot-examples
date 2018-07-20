package com.tutorialsdesk.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Student {

	private int rollNumber;
	private String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dob;

	public Student() {
		super();
	}
	
	public Student(int rollNumber, String name, LocalDate dob) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.dob = dob;
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
	
	public LocalDate getDob() {
		return dob;
	}
	
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}
