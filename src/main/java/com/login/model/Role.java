package com.login.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dany on 13/05/2018.
 */
@Entity
@Data
@Table(name = "role")
public class Role implements Serializable{
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
}
