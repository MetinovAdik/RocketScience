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

    public void register(Student student){
        studentRepository.save(student);
    }
    public Student findById(Long id){
        if (studentRepository.existsById(id)) {
            return studentRepository.findById(id).get();
        } else throw new NotFoundException("Не могу найти пользователя");
    }

    public void saveOrUpdate(Student student) {
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        if (existingStudent != null) {
            existingStudent.setAge(student.getAge());
            existingStudent.setEducation(student.getEducation());
            existingStudent.setGender(student.getGender());
            existingStudent.setInstagram(student.getInstagram());
            existingStudent.setFacebook(student.getFacebook());
            existingStudent.setYoutube(student.getYoutube());
            existingStudent.setTwitter(student.getTwitter());
            studentRepository.save(existingStudent);
        } else {

        }
    }
}
