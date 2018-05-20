package com.login.repository;

import com.login.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dany on 15/05/2018.
 */
public interface VideoRepository extends JpaRepository<Video, Long> {
}
