package com.SpringSecurity.SpringSecurity.Controller;

import com.SpringSecurity.SpringSecurity.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/students")
public class AdminController {

    List<Student> students = Arrays.asList(new Student(1 , "Abhilash1"),
            new Student(2 , "Abhilash2"),
            new Student(3 , "Abhilash3"),
            new Student(4 , "Abhilash4"));

    @GetMapping
    public List<Student> getAllStudents(){
        System.out.println("Get All Students Request....");
        return students;
    }

    @PostMapping
    public Student addStudent() {
        return new Student(5 , "newlyAddedStudent");
    }

    @DeleteMapping
    public Student deleteStudent() {
        return new Student(6 , "deletedStudent");
    }

    @PutMapping
    public Student putStudent() {
        return new Student(7 , "updatedStudent");
    }
}
