package com.login.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dany on 27/05/2018.
 */
@Entity
@Table(name = "token")
@Data
public class Token implements Serializable{
    @Id
    private String series;

    private String value;

    private Date date;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "user_agent")
    private String userAgent;

    @Column(name = "user_login")
    private String userLogin;
}
