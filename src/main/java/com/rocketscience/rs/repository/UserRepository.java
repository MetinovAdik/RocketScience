package com.rocketscience.rs.repository;

import com.rocketscience.rs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmail(String email);
    Boolean existsByEmail(String email);

    Collection<? extends User> findByFirstNameContains(String string);

    Collection<? extends User> findByLastNameContains(String string);
}