package com.project.controller;


import com.project.model.Course;
import com.project.service.CourseService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/getAllCourse")
    public List<Course> getAllCourse(){
        try {
            return courseService.getAllCourse();
        }catch(SQLException sqEx){
            return (List<Course>) ResponseEntity.
                    badRequest().
                    body("A problem occurred when consulting courses");
        }
    }

    @PostMapping("/postCourse")
    public ResponseEntity<?> postCourse(@RequestBody Course course){
        JSONObject jsonResponse = new JSONObject();

        try{
            courseService.postCourse(course);
            jsonResponse.put("message", "Course added successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Course could not log into the system");
        }
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable (value = "id") String id){

        JSONObject jsonResponse = new JSONObject();

        try{
            courseService.deleteCourse(id);
            jsonResponse.put("message", "Course deleted successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Student could not be removed from the system");

        }
    }

    @GetMapping("/getCourse/{id}")
    public ResponseEntity<?> getStudent(@PathVariable (value = "id") String id){
        try{
            Course course = courseService.getCourse(id);
            return  new ResponseEntity<>(course, HttpStatus.OK);
        }catch(SQLException sqEx){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
