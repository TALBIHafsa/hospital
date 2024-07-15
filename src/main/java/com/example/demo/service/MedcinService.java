package com.example.demo.service;

import com.example.demo.exception.ConsultationException;
import com.example.demo.exception.ConsultationNotFoundException;
import com.example.demo.exception.MedcinException;
import com.example.demo.exception.MedcinNotFoundException;
import com.example.demo.model.Consultation;
import com.example.demo.model.Medcin;

import java.util.List;

public interface MedcinService {
    Medcin createMedcin(Medcin medcin) throws MedcinException;
    List<Medcin> getAllMedcins() throws  MedcinException;
    Medcin getMedcin(Long id) throws  MedcinNotFoundException;

    Medcin updateMedcin(Medcin medcin) throws MedcinException, MedcinNotFoundException;
    String deleteMedcin(Long id) throws MedcinException, MedcinNotFoundException;

}
