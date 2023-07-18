package com.rocketscience.rs.repository;

import com.rocketscience.rs.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long>{

}
