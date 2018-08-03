package com.tutorialsdesk.model;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Student extends ResourceSupport{

	private int rollNumber;
	private String name;
	
	
	private String course;

	public Student() {
		super();
	}
	
	@JsonCreator
	public Student(@JsonProperty("rollNumber") int rollNumber, @JsonProperty("name") String name, @JsonProperty("course") String course) {
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
