package com.login.repository;

import com.login.model.HistoryOfLearning;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dany on 15/05/2018.
 */
public interface HistoryOfLearningRepository extends JpaRepository<HistoryOfLearning, Long> {
}
