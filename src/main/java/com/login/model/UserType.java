package com.login.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Dany on 13/05/2018.
 */
@Entity
@Data
@Table(name = "user_type")
public class UserType implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
}
