package com.project.repository;

import com.project.model.CommentNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentNewRepository extends JpaRepository<CommentNew, Integer> {



}
