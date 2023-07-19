package com.rocketscience.rs.controller;

import com.rocketscience.rs.entity.Student;
import com.rocketscience.rs.exception.NotFoundException;
import com.rocketscience.rs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        try {
            Student student = studentService.findById(studentId);
            return ResponseEntity.ok(student);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

