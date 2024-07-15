package com.example.demo.service;

import com.example.demo.exception.ConsultationNotFoundException;
import com.example.demo.exception.ConsultationException;
import com.example.demo.model.Consultation;

import java.util.List;

public interface ConsultationService {
    Consultation createConsultation(Consultation c) throws ConsultationException;

    Consultation getConsultation(Long id) throws ConsultationNotFoundException;
    List<Consultation> getAllConsultation() throws ConsultationException;
    Consultation updateConsultation(Consultation c) throws ConsultationException, ConsultationNotFoundException;
    String deleteConsultation(Long id) throws ConsultationException, ConsultationNotFoundException;
}
