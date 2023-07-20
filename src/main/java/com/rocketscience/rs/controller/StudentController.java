package com.rocketscience.rs.controller;

import com.rocketscience.rs.entity.Mentor;
import com.rocketscience.rs.entity.Student;
import com.rocketscience.rs.exception.NotFoundException;
import com.rocketscience.rs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/cabinet")
    public Student getStudentCavivetById(Long id){
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //String username = authentication.getName();
        //User user = userService.findByUsername(username);
        //Long id = user.getId();
        return studentService.findById(id);
    }
    @PostMapping("/cab-save")
    public ResponseEntity<String> saveOrUpdate(@RequestBody Student student){
        studentService.saveOrUpdate(student);
        return ResponseEntity.ok("User registered successfully!");
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

