package com.project.service;

import com.project.model.BreakingNew;
import com.project.repository.BreakingNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class BreakingNewService {

    @Autowired
    BreakingNewRepository breakingNewRepository;

    public List<BreakingNew> getAllBreakingNew() throws SQLException {
        return breakingNewRepository.findAll();
    }

    public void postBreakingNew(BreakingNew breakingNew) throws SQLException{
        breakingNewRepository.save(breakingNew);
    }

    public BreakingNew getBreakingNew(int id) throws SQLException{

        Optional<BreakingNew> optionalBreakingNew = breakingNewRepository.findById(id);
        BreakingNew breakingNew;

        if(optionalBreakingNew.isPresent()){
            breakingNew = optionalBreakingNew.get();
        }else{
            throw  new RuntimeException("The requested breaking new cannot be found");
        }
        return breakingNew;
    }

    public void deleteBreakingNew(int id) throws SQLException{
        breakingNewRepository.deleteById(id);
    }


}
