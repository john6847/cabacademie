package com.login.controller;

import com.login.model.Category;
import com.login.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Dany on 20/05/2018.
 */
@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id){
        if(id<0)
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Category category= categoryService.fetchCategory(id);
        if(category==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories= categoryService.fetchAllCategories();
        if(categories.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping()
    public  ResponseEntity<Category> saveCategory(@Valid @RequestBody Category category){
        Category currentCategory = categoryService.saveCategory(category);
        if(currentCategory==null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category){
        if(id<0)
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(categoryService.fetchCategory(id)==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Category currentCategory= categoryService.updateCategory(category);
        if (currentCategory==null)
            return  new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

        return new ResponseEntity<>(currentCategory, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id ){
        if(id<0)
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(categoryService.fetchCategory(id)==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        categoryService.deleteCategory(id);
        return new ResponseEntity<>("Category Deleted!", HttpStatus.OK);
    }
}
