package com.login.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dany on 13/05/2018.
 */
@Entity
@Data
@Table(name = "forum_comment")
public class Forum_Comments implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(optional = false)
    @JoinColumn(name = "forum_id")
    private Forum forum;
    private String Text;
    @OneToOne(optional = false)
    @JoinColumn(name="user_id")
    private User user;
    private Long parent_commnent;
}
