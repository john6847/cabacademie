package com.login.service;

import com.login.model.Category;
import com.login.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dany on 15/05/2018.
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> fetchAllCategories(){
        return categoryRepository.findAll();
    }

    public Category fetchCategory(Long id){
        return categoryRepository.findOne(id);
    }

    public Category updateCategory (Category category){
        Category currentCategory= categoryRepository.findOne(category.getId());
        currentCategory.setDescription(category.getDescription());
        currentCategory.setName(category.getName());
        return categoryRepository.save(currentCategory);
    }

    public Category saveCategory (Category category){
        return categoryRepository.save(category);
    }
    public void deleteCategory(Long id){
        categoryRepository.delete(id);
    }
    //other delete methods
    //other fetching methods

}
