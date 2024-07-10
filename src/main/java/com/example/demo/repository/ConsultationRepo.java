package com.example.demo.repository;

import com.example.demo.model.Consultation;
import com.example.demo.model.Medcin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepo extends JpaRepository<Consultation, Long> {
}
