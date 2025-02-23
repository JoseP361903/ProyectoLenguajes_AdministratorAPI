package com.project.controller;

import com.project.model.ApplicationConsultation;
import com.project.service.ApplicationConsultationService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/applicationConsultation")
public class ApplicationConsultationController {

    @Autowired
    ApplicationConsultationService applicationConsultationService;

    @GetMapping("/getAllApplicationConsultation")
    public List<ApplicationConsultation> getAllApplicationConsultation(){
        try {
            return applicationConsultationService.getAllApplicationConsultation();
        }catch(SQLException sqEx){
            return (List<ApplicationConsultation>) ResponseEntity.
                    badRequest().
                    body("A problem occurred when consulting application consultations");
        }
    }

    @PostMapping("/postApplicationConsultation")
    public ResponseEntity<?> postApplicationConsultation(@RequestBody ApplicationConsultation applicationConsultation){
        JSONObject jsonResponse = new JSONObject();

        try{
            applicationConsultationService.postApplicationConsultation(applicationConsultation);
            jsonResponse.put("message", "Application consultation added successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Application consultation could not log into the system");

        }
    }

    @DeleteMapping("/deleteApplicationConsultation/{id}")
    public ResponseEntity<?> deleteApplicationConsultation(@PathVariable (value = "id") int id){

        JSONObject jsonResponse = new JSONObject();

        try{
            applicationConsultationService.deleteApplicationConsultation(id);
            jsonResponse.put("message", "Application consultation deleted successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Application consultation could not be removed from the system");

        }

    }

    @GetMapping("/getApplicationConsultation/{id}")
    public ResponseEntity<?> getStudent(@PathVariable (value = "id") int id){
        try{
            ApplicationConsultation applicationConsultation =
                    applicationConsultationService.getApplicationConsultation(id);

            return  new ResponseEntity<>(applicationConsultation, HttpStatus.OK);
        }catch(SQLException sqEx){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
