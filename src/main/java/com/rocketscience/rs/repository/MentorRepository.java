package com.rocketscience.rs.repository;

import com.rocketscience.rs.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long>{

    List<Mentor> findAllById(List<Long> ids);

    List<Mentor> findByServicesContains(String services);

    @Query("SELECT m FROM Mentor m WHERE m.experience >= :minExperience")
    List<Mentor> findByExperienceAboveOrEqual(@Param("minExperience") Double minExperience);

}
