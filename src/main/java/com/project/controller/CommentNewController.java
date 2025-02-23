package com.project.controller;

import com.project.model.CommentNew;
import com.project.model.Student;
import com.project.service.CommentNewService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/commentNew")
public class CommentNewController {

    @Autowired
    CommentNewService commentNewService;

    @GetMapping("/getAllCommentNew")
    public List<CommentNew> getAllCommentNew(){
        try {
            return commentNewService.getAllCommentNew();
        }catch(SQLException sqEx){
            return (List<CommentNew>) ResponseEntity.
                    badRequest().
                    body("A problem occurred when consulting comments news");
        }
    }

    @PostMapping("/postCommentNew")
    public ResponseEntity<?> postCommentNew(@RequestBody CommentNew commentNew){
        JSONObject jsonResponse = new JSONObject();

        try{
            commentNewService.postCommentNew(commentNew);
            jsonResponse.put("message", "Comment new added successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Comment new could not log into the system");

        }
    }

    @DeleteMapping("/deleteCommentNew/{id}")
    public ResponseEntity<?> deleteCommentNew(@PathVariable (value = "id") int id){

        JSONObject jsonResponse = new JSONObject();

        try{
            commentNewService.deleteCommentNew(id);
            jsonResponse.put("message", "Comment new deleted successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Comment new could not be removed from the system");

        }

    }

    @GetMapping("/getCommentNew/{id}")
    public ResponseEntity<?> getCommentNew(@PathVariable (value = "id") int id){
        try{
            CommentNew commentNew = commentNewService.getCommentNew(id);
            return  new ResponseEntity<>(commentNew, HttpStatus.OK);
        }catch(SQLException sqEx){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getCommentByNewId/{id}")
    public List<CommentNew> getCommentByNewId(@PathVariable (value = "id") int idNew){
        try {
            return commentNewService.getCommentByNewId(idNew);
        }catch(SQLException sqEx){
            return (List<CommentNew>) ResponseEntity.
                    badRequest().
                    body("A problem occurred when consulting comments new");
        }
    }

}
