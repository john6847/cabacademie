package com.login.service;

import com.login.model.LearningPurpose;
import com.login.repository.LearningPurposeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dany on 18/05/2018.
 */
@Service
public class LearningPurposeService {
    @Autowired
    private LearningPurposeRepository learningPurposeRepository;

    public List<LearningPurpose> fetchAllLearningPurpose(){
        return learningPurposeRepository.findAll();
    }

    public LearningPurpose fetchLearningPurpose(Long id){
        return learningPurposeRepository.findOne(id);
    }

    public LearningPurpose updateLearningPurpose(LearningPurpose learningPurpose){
        LearningPurpose currentLearningPurpose= learningPurposeRepository.findOne(learningPurpose.getId());
        currentLearningPurpose.setDescription(learningPurpose.getDescription());
        currentLearningPurpose.setSyllabus(learningPurpose.getSyllabus());
        return learningPurposeRepository.save(currentLearningPurpose);
    }

    public void deleteLearningPurpose(Long id){
        learningPurposeRepository.delete(id);
    }
    //other delete methods
    //other fetching methods
}
