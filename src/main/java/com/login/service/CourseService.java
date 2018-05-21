package com.login.service;

import com.login.model.Course;
import com.login.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dany on 16/05/2018.
 */
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> fetchAllCourses(){
        return courseRepository.findAll();
    }

    public Course fetchCourse(Long id){
        return courseRepository.findOne(id);
    }

    public Course updateCourse (Course course){
        Course currentCourse= courseRepository.findOne(course.getId());
        currentCourse.setCategory(course.getCategory());
        currentCourse.setDuration(course.getDuration());
        currentCourse.setPremium(course.isPremium());
        currentCourse.setPrice(course.getPrice());
        currentCourse.setStartDate(course.getStartDate());
        currentCourse.setSyllabus(course.getSyllabus());
        currentCourse.setTitle(course.getTitle());
        currentCourse.setLocalUser(course.getLocalUser());
        return courseRepository.save(currentCourse);
    }
    public Course saveCourse (Course course){
        return courseRepository.save(course);
    }
    public void deleteCourse(Long id){
        courseRepository.delete(id);
    }
    //other delete methods
    //other fetching methods
}
