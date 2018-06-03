package com.login.repository;

import com.login.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dany on 27/05/2018.
 */
public interface TokenRepository extends JpaRepository<Token, String> {
}