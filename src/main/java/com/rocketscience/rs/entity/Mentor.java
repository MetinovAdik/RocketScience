package com.rocketscience.rs.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mentor")
public class Mentor {

    @Id
    private Long id;

    @Column(name = "services")
    private String services;

    @Column(name = "education")
    private String education;

    @Column(name = "experience")
    private String experience;

    @Column(name = "price")
    private String price;

    @Column(name = "instagram")
    private String instagram;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "youtube")
    private String youtube;

    @Column(name = "twitter")
    private String twitter;

    public Mentor(){}

    public Mentor(Long id) {
        this.id = id;
    }
}
