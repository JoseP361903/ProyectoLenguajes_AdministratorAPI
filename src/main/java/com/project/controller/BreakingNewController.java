package com.project.controller;

import com.project.model.BreakingNew;
import com.project.service.BreakingNewService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/breakingNew")
public class BreakingNewController {

    @Autowired
    BreakingNewService breakingNewService;

    @GetMapping("/getAllBreakingNew")
    public List<BreakingNew> getAllBreakingNew(){
        try {
            return breakingNewService.getAllBreakingNew();
        }catch(SQLException sqEx){
            return (List<BreakingNew>) ResponseEntity.
                    badRequest().
                    body("A problem occurred when consulting breaking news");
        }
    }

    @PostMapping("/postBreakingNew")
    public ResponseEntity<?> postBreakingNew(@RequestBody BreakingNew breakingNew){
        JSONObject jsonResponse = new JSONObject();

        try{
            breakingNewService.postBreakingNew(breakingNew);
            jsonResponse.put("message", "Breaking new added successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Breaking new could not log into the system");

        }
    }

    @DeleteMapping("/deleteBreakingNew/{id}")
    public ResponseEntity<?> deleteBreakingNew(@PathVariable (value = "id") int id){

        JSONObject jsonResponse = new JSONObject();

        try{
            breakingNewService.deleteBreakingNew(id);
            jsonResponse.put("message", "Breaking new deleted successfully");
            jsonResponse.put("isSucess", true);
            return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
        }catch(SQLException sqEx){
            return ResponseEntity.
                    badRequest().
                    body("Breaking new could not be removed from the system");

        }

    }

    @GetMapping("/getBreakingNew/{id}")
    public ResponseEntity<?> getBreakingNes(@PathVariable (value = "id") int id){
        try{
            BreakingNew breakingNew = breakingNewService.getBreakingNew(id);
            return  new ResponseEntity<>(breakingNew, HttpStatus.OK);
        }catch(SQLException sqEx){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
