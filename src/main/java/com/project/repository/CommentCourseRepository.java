package com.project.repository;

import com.project.model.CommentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentCourseRepository extends JpaRepository<CommentCourse, Integer> {




}
