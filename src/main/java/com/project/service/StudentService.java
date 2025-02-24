package com.project.service;

import com.project.model.Student;
import com.project.repository.StudentRepository;
import com.project.util.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getAllStudent() throws SQLException {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByActive() throws SQLException{
        short active = 0;
        return studentRepository.getStudentsByActive(active);
    }

    public void postStudent(Student student) throws SQLException{
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if (optionalStudent.isPresent()){
            //Validate change in active, notify student
            Student studentForMail = optionalStudent.get();
            if(studentForMail.getActive() == 0 && student.getActive() == 1){
                Security.sendAcceptedMail(student);
            }
        }
        studentRepository.save(student);
    }

    public Student getStudent(String id) throws SQLException{

        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student;

        if(optionalStudent.isPresent()){
            student = optionalStudent.get();
        }else{
            throw  new RuntimeException("The requested student cannot be found");
        }
        return student;
    }

    public void deleteStudent(String id) throws SQLException{
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student = optionalStudent.get();
        Security security = new Security();
        security.sendDeletedMail(student);
        studentRepository.deleteById(id);
    }
}
