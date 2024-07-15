package com.example.demo.service;

import com.example.demo.exception.MedcinException;
import com.example.demo.exception.PatientException;
import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

public class PatientServiceImpl implements PatientService {
    final
    PatientRepo patientRepo;

    public PatientServiceImpl(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    @Override@Transactional
    public Patient createPatient(Patient patient) throws PatientException {
        try{
            return patientRepo.save(patient);
        }catch (Exception e){
            throw new PatientException("Erreur lors de la creation d'un nouveau patient.", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Patient> getAllPatients() throws PatientException {
        try{
            return patientRepo.findAll();
        }catch (Exception e){
            throw new PatientException("Erreur lors de la creation d'un nouveau patient.", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Patient getPatient(Long id) throws PatientNotFoundException {
        return patientRepo.findById(id).orElseThrow(() -> new PatientNotFoundException("Le patient avec l'identifiant " + id + " non trouve"));
    }

    @Override
    @Transactional
    public Patient updatePatient(Patient p) throws PatientException, PatientNotFoundException {
        Patient patient = getPatient(p.getId());
        patient.setEmail(p.getEmail());
        patient.setNom(p.getNom());
        patient.setRendezVous(p.getRendezVous());
        try {
           return patientRepo.save(patient);
        } catch(Exception e){
            throw  new PatientException("Erreur lors de la modification des informations du patient", e);
        }
    }

    @Override
    @Transactional
    public String deletePatient(Long id) throws PatientException, PatientNotFoundException {
        Patient patient = getPatient(id);
        try {
             patientRepo.delete(patient);
            return  "Le patient avec l'idantifiant " + id + " a ete supprime";
        } catch(Exception e){
            throw  new PatientException("Erreur lors de la modification des informations du patient", e);
        }
    }
}
