package com.tutorialsdesk.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {

    @Id
    private String id;

    private String rollNumber;

    private String name;

    public Student() {

    }

    public Student(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
