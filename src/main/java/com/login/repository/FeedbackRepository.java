package com.login.repository;

import com.login.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dany on 15/05/2018.
 */
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
