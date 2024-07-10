package com.example.demo.repository;

import com.example.demo.model.Patient;
import com.example.demo.model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
