package com.project.controller;

import com.project.model.PrivateConsultation;
import com.project.service.PrivateConsultationService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/privateConsultation")
public class PrivateConsultationController {

    @Autowired
    PrivateConsultationService privateConsultationService;

    @GetMapping("/getAllPrivateConsultation")
    public List<PrivateConsultation> getAllPrivateConsultation(){
        try {
            return privateConsultationService.getAllPrivateConsultation();
        }catch(SQLException sqEx){
            return (List<PrivateConsultation>) ResponseEntity.
                    badRequest().
                    body("A problem occurred when consulting private consultations");
        }
    }

    @PostMapping("/postPrivateConsultation")
    public ResponseEntity<?> postPrivateConsultation(@RequestBody PrivateConsultation privateConsultation){
        JSONObject jsonResponse = new JSONObject();

        try{
            privateConsultationService.postPrivateConsultation(privateConsultation);
            jsonResponse.put("message", "Private consultation added successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Private consultation could not log into the system");

        }
    }

    @DeleteMapping("/deletePrivateConsultation/{id}")
    public ResponseEntity<?> deletePrivateConsultation(@PathVariable (value = "id") int id){

        JSONObject jsonResponse = new JSONObject();

        try{
            privateConsultationService.deletePrivateConsultation(id);
            jsonResponse.put("message", "Private consultation deleted successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Private consultation could not be removed from the system");

        }

    }

    @GetMapping("/getPrivateConsultation/{id}")
    public ResponseEntity<?> getPrivateConsultation(@PathVariable (value = "id") int id){
        try{
            PrivateConsultation privateConsultation =
                    privateConsultationService.getPrivateConsultation(id);
            return  new ResponseEntity<>(privateConsultation, HttpStatus.OK);

        }catch(SQLException sqEx){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
