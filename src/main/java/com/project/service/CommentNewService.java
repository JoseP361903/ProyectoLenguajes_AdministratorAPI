package com.project.service;

import com.project.model.CommentNew;
import com.project.repository.CommentNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentNewService {

    @Autowired
    CommentNewRepository commentNewRepository;

    public List<CommentNew> getAllCommentNew() throws SQLException {
        return commentNewRepository.findAll();
    }

    public void postCommentNew(CommentNew commentNew) throws SQLException{
        commentNewRepository.save(commentNew);
    }

    public CommentNew getCommentNew(int id) throws SQLException{

        Optional<CommentNew> optionalCommentNew = commentNewRepository.findById(id);
        CommentNew commentNew;

        if(optionalCommentNew.isPresent()){
            commentNew = optionalCommentNew.get();
        }else{
            throw  new RuntimeException("The requested comment new cannot be found");
        }
        return commentNew;
    }

    public void deleteCommentNew(int id) throws SQLException{
        commentNewRepository.deleteById(id);
    }

    public List<CommentNew> getCommentByNewId(int idNew) throws SQLException {
        List<CommentNew> commentNews = commentNewRepository.findAll();
        List<CommentNew> commentByNewId = new ArrayList<>();
        for(CommentNew commentNew : commentNews){
            if(commentNew.getId_New() == idNew){
                commentByNewId.add(commentNew);
            }
        }
        return commentByNewId;
    }

}
