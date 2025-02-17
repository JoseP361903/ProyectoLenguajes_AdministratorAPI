package com.project.service;

import com.project.model.Course;
import com.project.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourse() throws SQLException {
        return courseRepository.findAll();
    }

    public void postCourse(Course course) throws SQLException{
        courseRepository.save(course);
    }

    public Course getCourse(String id) throws SQLException{

        Optional<Course> optionalCourse = courseRepository.findById(id);
        Course course;

        if(optionalCourse.isPresent()){
            course = optionalCourse.get();
        }else{
            throw  new RuntimeException("The requested course cannot be found");
        }
        return course;
    }

    public void deleteCourse(String id) throws SQLException{
        courseRepository.deleteById(id);
    }

}
