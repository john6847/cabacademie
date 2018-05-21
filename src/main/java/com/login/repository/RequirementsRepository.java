package com.login.repository;

import com.login.model.Requirements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dany on 15/05/2018.
 */
public interface RequirementsRepository extends JpaRepository<Requirements, Long> {
    List<Requirements> findAllBySyllabus_Id(Long id);
}
