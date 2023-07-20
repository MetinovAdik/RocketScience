package com.rocketscience.rs.repository;

import com.rocketscience.rs.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{

    List<Application> findAllByStudentId(Long id);

    List<Application> findAllByMentorId(Long id);
}
