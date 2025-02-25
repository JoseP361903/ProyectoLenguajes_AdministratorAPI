package com.project.controller;


import com.project.model.Administrator;
import com.project.service.AdministratorService;
import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;
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
    public ResponseEntity<?> validateAdministrator(@RequestBody Administrator administrator, HttpSession session) {
        try {
            int result = administratorService.validateId(administrator.getId(), administrator.getPassword());
            if (result != 1) {
                return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
            }

            Administrator adminData = administratorService.getAdministrator(administrator.getId());
            if (adminData == null) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            session.setAttribute("UserId", adminData.getId());
            session.setAttribute("UserName", adminData.getName());
            session.setAttribute("UserLastName", adminData.getLastName());
            session.setAttribute("UserEmail", adminData.getEmail());


            return ResponseEntity.ok(new JSONObject()
                    .put("message", "Authentication successful")
                    .put("administrator", adminData)
                    .toString());


        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAdministratorDataFromSession")
    public ResponseEntity<?> getAdministratorDataFromSession(HttpSession session) {
        String userId = (String) session.getAttribute("UserId");
        if (userId == null || userId.isEmpty()) {
            return new ResponseEntity<>("User is not logged in.", HttpStatus.UNAUTHORIZED);
        }

        Administrator administrator = new Administrator();
        administrator.setId(userId);
        administrator.setName((String) session.getAttribute("UserName"));
        administrator.setLastName((String) session.getAttribute("UserLastName"));
        administrator.setEmail((String) session.getAttribute("UserEmail"));


        return new ResponseEntity<>(administrator, HttpStatus.OK);
    }



}
