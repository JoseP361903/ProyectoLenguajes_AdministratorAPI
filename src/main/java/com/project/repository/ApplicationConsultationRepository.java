package com.project.repository;

import com.project.model.ApplicationConsultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationConsultationRepository extends JpaRepository<ApplicationConsultation, Integer> {





}
