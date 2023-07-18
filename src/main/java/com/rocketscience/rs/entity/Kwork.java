package com.rocketscience.rs.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "kwork")
public class Kwork {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mentorId")
    private Long mentorId;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private Type type;

    @Column(name = "science")
    private Science science;

    @Column(name = "subject")
    private Subject subject;

    @Column(name = "price")
    private String price;

    //TODO Добавить поле для отзывов

    public Kwork(){}

    public Kwork(Long id) {this.id = id;}
}
