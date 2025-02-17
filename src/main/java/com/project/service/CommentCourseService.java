package com.project.service;

import com.project.model.CommentCourse;
import com.project.repository.CommentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentCourseService {

    @Autowired
    CommentCourseRepository commentCourseRepository;

    public List<CommentCourse> getAllCommentCourse() throws SQLException {
        return commentCourseRepository.findAll();
    }

    public void postCommentCourse(CommentCourse commentCourse) throws SQLException{
        commentCourseRepository.save(commentCourse);
    }

    public CommentCourse getCommentCourse(int id) throws SQLException{

        Optional<CommentCourse> optionalCommentCourse = commentCourseRepository.findById(id);
        CommentCourse commentCourse;

        if(optionalCommentCourse.isPresent()){
            commentCourse = optionalCommentCourse.get();
        }else{
            throw  new RuntimeException("The requested comment course cannot be found");
        }
        return commentCourse;
    }

    public void deleteCommentCourse(int id) throws SQLException{
        commentCourseRepository.deleteById(id);
    }

    public List<CommentCourse> getCommentByCourseAcronym(String acronym) throws SQLException {
        List<CommentCourse> commentCourses = commentCourseRepository.findAll();
        List<CommentCourse> commentByAcronymCourse = new ArrayList<>();
        for(CommentCourse commentCourse : commentCourses){
            if(commentCourse.getAcronym().equalsIgnoreCase(acronym)){
                commentByAcronymCourse.add(commentCourse);
            }
        }
        return commentByAcronymCourse;
    }



}
