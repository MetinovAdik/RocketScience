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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

import static com.rocketscience.rs.entity.Role.MENTOR;
import static com.rocketscience.rs.entity.Role.STUDENT;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    private StudentService studentService;

    private MentorService mentorService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register-student")
    public ResponseEntity<String> registerStudent(@RequestBody User user) {
        user.setRole(STUDENT);
        userService.registerUser(user);
        Student student = new Student(user.getId());
        studentService.register(student);
        return ResponseEntity.ok("User registered successfully!");
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
