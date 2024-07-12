package com.example.demo.service;

import com.example.demo.model.Consultation;
import com.example.demo.model.Medcin;
import com.example.demo.model.Patient;
import com.example.demo.model.RendezVous;

import java.security.cert.CertPathBuilder;
import java.util.List;

public interface UserService {
    Patient addNewPatient(Patient patient);
    Medcin addNewMedcin(Medcin medcin);
    Consultation addNewConsultation(Consultation consultation);
    RendezVous addNewRendezVous(RendezVous rendezVous);
    List<Patient> findPatientByNom(String name);
    List<Medcin> findMedcinByNom(String name);
    Medcin findMedcinById(Long id);
    Patient findPatientById(Long id);

    RendezVous findRendewVousById(Long id);
}
