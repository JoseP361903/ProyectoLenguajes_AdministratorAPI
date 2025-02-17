package com.project.service;

import com.project.model.PrivateConsultation;
import com.project.repository.PrivateConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class PrivateConsultationService {

    @Autowired
    PrivateConsultationRepository privateConsultationRepository;


    public List<PrivateConsultation> getAllPrivateConsultation() throws SQLException {
        return privateConsultationRepository.findAll();
    }

    public void postPrivateConsultation(PrivateConsultation privateConsultation) throws SQLException{
        privateConsultationRepository.save(privateConsultation);
    }

    public PrivateConsultation getPrivateConsultation(int id) throws SQLException{

        Optional<PrivateConsultation> optionalPrivateConsultation = privateConsultationRepository.findById(id);
        PrivateConsultation privateConsultation;

        if(optionalPrivateConsultation.isPresent()){
            privateConsultation = optionalPrivateConsultation.get();
        }else{
            throw  new RuntimeException("The requested private consultation cannot be found");
        }
        return privateConsultation;
    }

    public void deletePrivateConsultation(int id) throws SQLException{
        privateConsultationRepository.deleteById(id);
    }

}
