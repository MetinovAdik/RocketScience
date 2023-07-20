package com.rocketscience.rs.controller;

import com.rocketscience.rs.entity.Mentor;
import com.rocketscience.rs.entity.Student;
import com.rocketscience.rs.service.MentorService;
import com.rocketscience.rs.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final MentorService mentorService;
    private final StudentService studentService;

    @PostMapping("/signup/student")
    public ResponseEntity<String> signupStudent(@RequestBody Student student){
        if (studentService.findByEmail(student.getUser().getEmail())!=null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }
        studentService.saveStudent(student);
        return ResponseEntity.ok("Student signup successfully");
    }

    @PostMapping("/signup/mentor")
    public ResponseEntity<String> signupMentor(@RequestBody Mentor mentor){
        if (mentorService.findByEmail(mentor.getUser().getEmail())!=null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }
        mentorService.saveMentor(mentor);
        return ResponseEntity.ok("Mentor signup successfully");
    }
}
