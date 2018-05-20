package com.login.service;

import com.login.model.HistoryOfLearning;
import com.login.repository.HistoryOfLearningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dany on 18/05/2018.
 */
@Service
public class HistoryOfLearningService {
    @Autowired
    private HistoryOfLearningRepository historyOfLearningRepository;

    public List<HistoryOfLearning> fetchAllHistoryOfLearning(){
        return historyOfLearningRepository.findAll();
    }

    public HistoryOfLearning fetchHistoryOfLearning(Long id){
        return historyOfLearningRepository.findOne(id);
    }

    public HistoryOfLearning updateHistoryOfLearning(HistoryOfLearning historyOfLearning){
        HistoryOfLearning currentHistoryOfLearning= historyOfLearningRepository.findOne(historyOfLearning.getId());
        currentHistoryOfLearning.setEnrollement(historyOfLearning.getEnrollement());
        currentHistoryOfLearning.setTimeStamp(currentHistoryOfLearning.getTimeStamp());
        currentHistoryOfLearning.setVideo(historyOfLearning.getVideo());


        return historyOfLearningRepository.save(currentHistoryOfLearning);
    }

    public void deleteHistoryOfLearning(Long id){
        historyOfLearningRepository.delete(id);
    }
    //other delete methods
    //other fetching methods
}
