package com.project.service;

import com.project.model.Administrator;
import com.project.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {
    @Autowired
    AdministratorRepository administratorRepository;

    public Administrator getAdministrator(String id) throws SQLException{

        Optional<Administrator> optionalAdministrator = administratorRepository.findById(id);
        Administrator administrator;

        if(optionalAdministrator.isPresent()){
            administrator = optionalAdministrator.get();
        }else{
            throw  new RuntimeException("The requested administrator cannot be found");
        }
        return administrator;
    }

    public int validateId(String id, String password) throws SQLException{
        int validate = 0;
        List<Administrator> administrators = administratorRepository.findAll();
        for(Administrator administrator : administrators){
            if(administrator.getId().equals(id) && administrator.getPassword().equals(password)){
                validate = 1;
                break;
            }
        }
        return validate;
    }
}
