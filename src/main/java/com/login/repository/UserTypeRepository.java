package com.login.repository;

import com.login.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dany on 15/05/2018.
 */
public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}
