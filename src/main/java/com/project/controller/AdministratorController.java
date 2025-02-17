package com.project.controller;


import com.project.model.Administrator;
import com.project.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/administrator")
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;

    @GetMapping("/getAdministrator/{id}")
    public ResponseEntity<?> getAdministrator(@PathVariable (value = "id") String id){
        try{
            Administrator administrator = administratorService.getAdministrator(id);
            return  new ResponseEntity<>(administrator, HttpStatus.OK);
        }catch(SQLException sqEx){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/validateAdministrator")
    public ResponseEntity<?> validateAdministrator(@RequestBody Administrator administrator) {
        try {
            int result = administratorService.validateId(administrator.getId(), administrator.getPassword());
            if (result == 1) {
                return new ResponseEntity<>("Valid credentials", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
            }
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
