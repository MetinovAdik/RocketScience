package com.rocketscience.rs.repository;

import com.rocketscience.rs.entity.Student;
import com.rocketscience.rs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    Student  findByUser(User user);
}
