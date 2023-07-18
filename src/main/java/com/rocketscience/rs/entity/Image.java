package com.rocketscience.rs.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "image")
public class Image {

    @Id
    private Long id;

    @Lob
    @Column(name = "image")
    private byte Image;

    public Image(){}

    public Image(Long id) {
        this.id = id;
    }
}
