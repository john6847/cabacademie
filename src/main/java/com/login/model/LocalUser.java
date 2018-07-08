
package com.login.model;

import java.beans.Transient;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

@Entity
@Data
@Table(name = "user")
public class LocalUser implements Serializable{
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String title;
	private String country;
	private String password;
	private String passwordConfirm;	
	private String provider;
	private String image;
	private boolean enabled;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_authority", joinColumns = { @JoinColumn(name = "id_user", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "id_authority", table = "authority", referencedColumnName = "id") })
	private Set<Role> roles = new HashSet<>();


}
