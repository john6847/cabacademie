package com.login.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dany on 13/05/2018.
 */
@Entity
@Data
@Table(name = "topic")
public class Topic implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String description;
    @ManyToOne(optional = false)
    @JoinColumn(name="category_id")
    private Category category;
}