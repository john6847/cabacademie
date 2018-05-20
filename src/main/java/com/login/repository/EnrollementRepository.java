package com.login.repository;

import com.login.model.Enrollement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dany on 15/05/2018.
 */
public interface EnrollementRepository  extends JpaRepository<Enrollement, Long>{
}
