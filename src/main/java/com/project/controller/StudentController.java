package com.project.controller;


import com.project.model.Student;
import com.project.service.StudentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent(){
        try {
            return studentService.getAllStudent();
        }catch(SQLException sqEx){
            return (List<Student>) ResponseEntity.
                    badRequest().
                    body("A problem occurred when consulting students");
        }
    }

    @GetMapping("/getUnacceptedStudents")
    public List<Student> getUnacceptedStudents(){
        try{
            return studentService.getStudentsByActive();
        } catch (SQLException e) {
            return (List<Student>) ResponseEntity.
                    badRequest().
                    body("A problem occurred when consulting students");
        }
    }

    @PostMapping("/postStudent")
    public ResponseEntity<?> postStudent(@RequestBody Student student){
        JSONObject jsonResponse = new JSONObject();

        try{
            studentService.postStudent(student);
            jsonResponse.put("message", "Student added successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Student could not log into the system");

        }
    }

    @GetMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable (value = "id") String id){

        JSONObject jsonResponse = new JSONObject();

        try{
            studentService.deleteStudent(id);
            jsonResponse.put("message", "Student deleted successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Student could not be removed from the system");

        }

    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudent(@PathVariable (value = "id") String id){
        try{
            Student student = studentService.getStudent(id);
            return  new ResponseEntity<>(student, HttpStatus.OK);
        }catch(SQLException sqEx){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
