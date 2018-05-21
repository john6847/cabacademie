package com.login.repository;

import com.login.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dany on 15/05/2018.
 */
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findAllByCourse_Id(Long id);
    List<Feedback> findAllByEnrollement_Id(Long id);
}
