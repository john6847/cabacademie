package com.login.repository;

import com.login.model.ForumComments;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dany on 15/05/2018.
 */
public interface ForumCommentsRepository extends JpaRepository<ForumComments, Long>{
}
