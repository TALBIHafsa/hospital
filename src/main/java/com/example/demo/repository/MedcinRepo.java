package com.example.demo.repository;

import com.example.demo.model.Medcin;
import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedcinRepo extends JpaRepository<Medcin, Long> {
    List<Medcin> findMedcinsByNom(String name);

}
