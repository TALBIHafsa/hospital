package com.example.demo.repository;

import com.example.demo.model.Medcin;
import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedcinRepo extends JpaRepository<Medcin, Long> {
}
