package com.project.controller;

import com.project.model.CommentCourse;
import com.project.service.CommentCourseService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/commentCourse")
public class CommentCourseController {

    @Autowired
    CommentCourseService commentCourseService;

    @GetMapping("/getAllCommentCourse")
    public List<CommentCourse> getAllCommentCourse(){
        try {
            return commentCourseService.getAllCommentCourse();
        }catch(SQLException sqEx){
            return (List<CommentCourse>) ResponseEntity.
                    badRequest().
                    body("A problem occurred when consulting comments courses");
        }
    }

    @PostMapping("/postCommentCourse")
    public ResponseEntity<?> postCommentCourse(@RequestBody CommentCourse commentCourse){
        JSONObject jsonResponse = new JSONObject();

        try{
            commentCourseService.postCommentCourse(commentCourse);
            jsonResponse.put("message", "Comment course added successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Comment course could not log into the system");

        }
    }

    @DeleteMapping("/deleteCommentCourse/{id}")
    public ResponseEntity<?> deleteCommentCourse(@PathVariable (value = "id") int id){

        JSONObject jsonResponse = new JSONObject();

        try{
            commentCourseService.deleteCommentCourse(id);
            jsonResponse.put("message", "Comment course deleted successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Comment course could not be removed from the system");

        }

    }

    @GetMapping("/getCommentCourse/{id}")
    public ResponseEntity<?> getCommentCourse(@PathVariable (value = "id") int id){
        try{
            CommentCourse commentCourse = commentCourseService.getCommentCourse(id);
            return  new ResponseEntity<>(commentCourse, HttpStatus.OK);
        }catch(SQLException sqEx){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCommentByCourseAcronym/{id}")
    public List<CommentCourse> getCommentByCourseAcronym(@PathVariable (value = "id") String acronym){
        try {
            return commentCourseService.getCommentByCourseAcronym(acronym);
        }catch(SQLException sqEx){
            return (List<CommentCourse>) ResponseEntity.
                    badRequest().
                    body("A problem occurred when consulting comments course");
        }
    }


}
