package com.rocketscience.rs.repository;

import com.rocketscience.rs.entity.Kwork;
import com.rocketscience.rs.entity.Science;
import com.rocketscience.rs.entity.Subject;
import com.rocketscience.rs.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface KworkRepository extends JpaRepository<Kwork, Long>{
    List<Kwork> findBySubject(Subject subject);

    List<Kwork> findByType(Type type);

    List<Kwork> findByScience(Science science);
}
