package com.login.repository;

import com.login.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dany on 15/05/2018.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
