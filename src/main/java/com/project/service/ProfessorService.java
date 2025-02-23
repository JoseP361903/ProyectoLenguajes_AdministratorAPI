package com.project.service;

import com.project.model.Professor;
import com.project.model.Student;
import com.project.repository.ProfessorRepository;
import com.project.util.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;


    public List<Professor> getAllProfessor() throws SQLException {
        return professorRepository.findAll();
    }

    public void postProfessor(Professor professor) throws SQLException{
       Security security = new Security();
       security.sendAcceptedMail(professor);
       professorRepository.save(professor);
    }

    public Professor getProfessor(String id) throws SQLException{

        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        Professor professor;

        if(optionalProfessor.isPresent()){
            professor = optionalProfessor.get();
        }else{
            throw  new RuntimeException("The requested student cannot be found");
        }
        return professor;
    }

    public void deleteProfessor(String id) throws SQLException{
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        Professor professor = optionalProfessor.get();
        Security security = new Security();
        security.sendDeletedMail(professor);
        professorRepository.deleteById(id);
    }
}
