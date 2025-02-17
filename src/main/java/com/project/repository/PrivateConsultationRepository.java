package com.project.repository;

import com.project.model.PrivateConsultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateConsultationRepository extends JpaRepository<PrivateConsultation, Integer> {



}
