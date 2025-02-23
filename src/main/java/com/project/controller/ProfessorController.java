package com.project.controller;


import com.project.model.Professor;
import com.project.service.ProfessorService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping("/getAllProfessor")
    public ResponseEntity<?> getAllProfessor(){
        try {
            List<Professor> professors = professorService.getAllProfessor();
            return new ResponseEntity<>(professors, HttpStatus.OK);
        } catch (SQLException sqEx) {
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("message", "A problem occurred when consulting professors");
            jsonResponse.put("isSucess", false);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/postProfessor")
    public ResponseEntity<?> postProfessor(@RequestBody Professor professor){

        JSONObject jsonResponse = new JSONObject();

        try{
            professorService.postProfessor(professor);
            jsonResponse.put("message", "Professor added successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Professor could not log into the system");

        }
    }

    @GetMapping("/deleteProfessor/{id}")
    public ResponseEntity<?> deleteProfessor(@PathVariable (value = "id") String id){

        JSONObject jsonResponse = new JSONObject();

        try{
            professorService.deleteProfessor(id);
            jsonResponse.put("message", "Professor deleted successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Professor could not be removed from the system");

        }
    }

    @GetMapping("/getProfessor/{id}")
    public ResponseEntity<?> getProfessor(@PathVariable (value = "id") String id) {
        try {
            Professor professor = professorService.getProfessor(id);
            return new ResponseEntity<>(professor, HttpStatus.OK);
        } catch (SQLException sqEx) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
