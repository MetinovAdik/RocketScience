package com.rocketscience.rs.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(name="firstName")
    private String firstName;

    @Column(name = "lastName")
    private Long lastName;


    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private Role role;

    public User(){}

    public User(Long id) {
        this.id = id;
    }
}
