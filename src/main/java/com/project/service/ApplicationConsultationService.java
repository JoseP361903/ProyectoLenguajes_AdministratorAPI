package com.project.service;

import com.project.model.ApplicationConsultation;
import com.project.repository.ApplicationConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationConsultationService {


    @Autowired
    ApplicationConsultationRepository applicationConsultationRepository;

    public List<ApplicationConsultation> getAllApplicationConsultation() throws SQLException {
        return applicationConsultationRepository.findAll();
    }

    public void postApplicationConsultation(ApplicationConsultation applicationConsultation) throws SQLException{
        applicationConsultationRepository.save(applicationConsultation);
    }

    public ApplicationConsultation getApplicationConsultation(int id) throws SQLException{

        Optional<ApplicationConsultation> optionalApplicationConsultation
                = applicationConsultationRepository.findById(id);
        ApplicationConsultation applicationConsultation;

        if(optionalApplicationConsultation.isPresent()){
            applicationConsultation = optionalApplicationConsultation.get();
        }else{
            throw  new RuntimeException("The requested application consultation cannot be found");
        }
        return applicationConsultation;
    }

    public void deleteApplicationConsultation(int id) throws SQLException{
        applicationConsultationRepository.deleteById(id);
    }

}
