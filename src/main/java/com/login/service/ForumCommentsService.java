package com.login.service;

import com.login.model.Forum;
import com.login.model.ForumComments;
import com.login.repository.ForumCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dany on 18/05/2018.
 */
@Service
public class ForumCommentsService {
    @Autowired
    private ForumCommentsRepository forumCommentsRepository;

    public List<ForumComments> fetchAllForumComments(){
        return forumCommentsRepository.findAll();
    }

    public ForumComments fetchForumComments(Long id){
        return forumCommentsRepository.findOne(id);
    }

    public ForumComments updateForumComments (ForumComments forumComments){
        ForumComments currentForumComments= forumCommentsRepository.findOne(forumComments.getId());
        currentForumComments.setForum(forumComments.getForum());
        currentForumComments.setParent_commnent(forumComments.getParent_commnent());
        currentForumComments.setText(forumComments.getText());
        currentForumComments.setLocalUser(forumComments.getLocalUser());
        return forumCommentsRepository.save(currentForumComments);
    }

    public void deleteForumComments(Long id){
        forumCommentsRepository.delete(id);
    }
    //other delete methods
    //other fetching methods
}
