package com.tutorialsdesk;

import com.tutorialsdesk.model.Student;
import com.tutorialsdesk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... strings) throws Exception {
        studentService.deleteAll();
        // save a couple of customers
        studentService.saveStudent(new Student("123", "Smith"));
        studentService.saveStudent(new Student("124", "Bob"));

        // fetch all customers
        System.out.println("Students found with findAll():");
        System.out.println("-------------------------------");
        for (Student student : studentService.findAll()) {
            System.out.println(student);
        }

        System.out.println();

        // fetch an individual customer
        System.out.println("Student found with findByName('123'):");
        System.out.println("--------------------------------");
        System.out.println(studentService.findByRollNumberName("123"));

        System.out.println("Customers found with findByName('Bob'):");
        System.out.println("--------------------------------");
        for (Student student : studentService.findByName("Bob")) {
            System.out.println(student);
        }
    }
}
