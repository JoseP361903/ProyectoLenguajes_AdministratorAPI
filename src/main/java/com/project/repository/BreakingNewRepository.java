package com.project.repository;

import com.project.model.BreakingNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreakingNewRepository extends JpaRepository<BreakingNew, Integer> {



}
