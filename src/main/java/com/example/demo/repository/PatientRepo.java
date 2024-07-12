package com.example.demo.repository;

import com.example.demo.model.Patient;
import com.example.demo.model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    public List<Patient> findPatientsByNom(String name);
}
