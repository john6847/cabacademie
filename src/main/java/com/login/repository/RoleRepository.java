package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.model.Role;


/**
 * Created by Dany on 15/05/2018.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
