package com.example.demo.service;

import com.example.demo.model.Consultation;
import com.example.demo.model.Medcin;
import com.example.demo.model.Patient;
import com.example.demo.model.RendezVous;
import com.example.demo.repository.ConsultationRepo;
import com.example.demo.repository.MedcinRepo;
import com.example.demo.repository.PatientRepo;
import com.example.demo.repository.RendezVousRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService{


    private ConsultationRepo consultationRepo ;
    private MedcinRepo medcinRepo;
    private PatientRepo patientRepo;
    private RendezVousRepo rendezVousRepo;




    @Override
    public Patient addNewPatient(Patient patient) {
        patientRepo.save(patient);
        return patient;
    }

    @Override
    public Medcin addNewMedcin(Medcin medcin) {
        medcinRepo.save(medcin);
        return medcin;
    }

    @Override
    public Consultation addNewConsultation(Consultation consultation) {
        consultationRepo.save(consultation);
        return consultation;
    }

    @Override
    public RendezVous addNewRendezVous(RendezVous rendezVous) {
        rendezVousRepo.save(rendezVous);
        return rendezVous;
    }

    @Override
    public List<Patient> findPatientByNom(String name) {
        return patientRepo.findPatientsByNom(name);
      }

    @Override
    public List<Medcin> findMedcinByNom(String name) {
        return medcinRepo.findMedcinsByNom(name);
    }

    @Override
    public Medcin findMedcinById(Long id) {
        if( medcinRepo.findById(id).isPresent())
            return medcinRepo.findById(id).get();
        else return null;
    }

    @Override
    public Patient findPatientById(Long id) {
        if(patientRepo.findById(id).isPresent())
            return  patientRepo.findById(id).get();
        else return null;
    }

    @Override
    public RendezVous findRendewVousById(Long id) {
            if(rendezVousRepo.findById(id).isPresent()){
                return rendezVousRepo.findById(id).get();
            }
            else return null;
    }


}
