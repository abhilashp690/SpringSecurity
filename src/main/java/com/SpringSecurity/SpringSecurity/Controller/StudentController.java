package com.SpringSecurity.SpringSecurity.Controller;

import com.SpringSecurity.SpringSecurity.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    List<Student> students = Arrays.asList(new Student(1 , "Abhilash1"),
            new Student(2 , "Abhilash2"),
            new Student(3 , "Abhilash3"),
            new Student(4 , "Abhilash4"));

    @GetMapping(path = "{studentId}")
    public Student getStudentDetails(@PathVariable("studentId") int studentId){
        return students.stream().filter((student) ->
           student.getStudentId()==studentId).findFirst().orElseThrow(() -> new IllegalStateException("Student with id - "
                + studentId + " not found"));
    }
}
