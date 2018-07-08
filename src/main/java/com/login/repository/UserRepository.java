package com.login.repository;

/**
 * Created by Dany on 15/05/2018.
 */

import com.login.model.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<LocalUser, Long> {
    LocalUser findByUsername(String username);
}
