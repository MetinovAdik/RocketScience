package com.rocketscience.rs.service;

import com.rocketscience.rs.entity.Student;
import com.rocketscience.rs.exception.NotFoundException;
import com.rocketscience.rs.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student findById(Long id){
        if (studentRepository.existsById(id)) {
            return studentRepository.findById(id).get();
        } else throw new NotFoundException("Не могу найти пользователя");
    }
}
