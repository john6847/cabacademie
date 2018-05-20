package com.login.repository;

import com.login.model.LearningPurpose;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dany on 15/05/2018.
 */
public interface LearningPurposeRepository extends JpaRepository<LearningPurpose, Long> {
}
