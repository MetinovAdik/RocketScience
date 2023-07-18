package com.rocketscience.rs.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    private Long id;

    @Column(name = "age")
    private String age;

    @Column(name = "education")
    private String education;

    @Column(name = "gender")
    private String gender;

    @Column(name = "instagram")
    private String instagram;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "youtube")
    private String youtube;

    @Column(name = "twitter")
    private String twitter;


    public Student(){}

    public Student(Long id) {
        this.id = id;
    }

}
