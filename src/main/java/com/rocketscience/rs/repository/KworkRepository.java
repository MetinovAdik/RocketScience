package com.rocketscience.rs.repository;

import com.rocketscience.rs.entity.Kwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KworkRepository extends JpaRepository<Kwork, Long>{
}
