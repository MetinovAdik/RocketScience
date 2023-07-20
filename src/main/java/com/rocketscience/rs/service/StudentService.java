package com.rocketscience.rs.service;

import com.rocketscience.rs.entity.Role;
import com.rocketscience.rs.entity.Student;
import com.rocketscience.rs.entity.User;
import com.rocketscience.rs.repository.StudentRepository;
import com.rocketscience.rs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final UserService userService;

    public Student saveStudent(Student student){
        student.getUser().setRole(Role.STUDENT);
        User savedUser = userService.saveUser(student.getUser());
        student.setUser(savedUser);
        return studentRepository.save(student);
    }
    public Student findByEmail(String email){
        User user = userService.findByEmail(email);
        if (user!=null && user.getRole()==Role.STUDENT){
            return studentRepository.findByUser(user);
        }
        return null;
    }
}
