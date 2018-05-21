package com.login.service;

import com.login.model.Topic;
import com.login.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dany on 18/05/2018.
 */
@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> fetchAllTopic(){
        return topicRepository.findAll();
    }

    public Topic fetchTopic(Long id){
        return topicRepository.findOne(id);
    }

    public Topic updateTopic(Topic topic){
        Topic currentTopic= topicRepository.findOne(topic.getId());
        currentTopic.setCategory(topic.getCategory());
        currentTopic.setDescription(topic.getDescription());
        currentTopic.setNombre(topic.getNombre());

        return topicRepository.save(currentTopic);
    }
    public Topic saveTopic(Topic topic){
        return topicRepository.save(topic);
    }
    public void deleteTopic(Long id){
        topicRepository.delete(id);
    }
    //other delete methods
    //other fetching methods
}
