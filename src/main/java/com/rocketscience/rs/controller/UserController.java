package com.rocketscience.rs.controller;


import com.rocketscience.rs.entity.Mentor;
import com.rocketscience.rs.entity.Student;
import com.rocketscience.rs.entity.User;
import com.rocketscience.rs.exception.NotFoundException;
import com.rocketscience.rs.service.MentorService;
import com.rocketscience.rs.service.UserService;
import com.rocketscience.rs.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.rocketscience.rs.entity.Role.MENTOR;
import static com.rocketscience.rs.entity.Role.STUDENT;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    private final StudentService studentService;

    private final MentorService mentorService;
    @Autowired
    public UserController(UserService userService, StudentService studentService, MentorService mentorService) {
        this.userService = userService;
        this.studentService = studentService;
        this.mentorService = mentorService;
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/register-student")
    public String registerStudent(@RequestBody User user) {
        user.setRole(STUDENT);
        userService.registerUser(user);
        Student student = new Student(user.getId());
        studentService.register(student);
        return "User registered successfully!";
    }
    @PostMapping("/register-mentor")
    public ResponseEntity<String> registerMentor(@RequestBody User user) {
        user.setRole(MENTOR);
        userService.registerUser(user);
        Mentor mentor = new Mentor(user.getId());
        mentorService.register(mentor);
        return ResponseEntity.ok("User registered successfully!");
    }

    @GetMapping("/by-email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        try {
            User user = userService.findByEmail(email);
            return ResponseEntity.ok(user);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-name/{name}")
    public List<User> getUsersByName(@PathVariable String name) {
        return userService.findByName(name);
    }
}
