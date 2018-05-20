package com.login.service;

import com.login.model.Feedback;
import com.login.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dany on 18/05/2018.
 */
@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> fetchAllFeedback(){
        return feedbackRepository.findAll();
    }

    public Feedback fetchFeedback(Long id){
        return feedbackRepository.findOne(id);
    }

    public Feedback updateFeedback (Feedback feedback){
        Feedback currentFeedback= feedbackRepository.findOne(feedback.getId());
        currentFeedback.setComment(feedback.getComment());
        currentFeedback.setCourse(feedback.getCourse());
        currentFeedback.setEnrollement(feedback.getEnrollement());
        currentFeedback.setRating(feedback.getRating());

        return feedbackRepository.save(currentFeedback);
    }

    public void deleteFeedback(Long id){
        feedbackRepository.delete(id);
    }
    //other delete methods
    //other fetching methods
}
