package com.example.demo.service;

import com.example.demo.exception.ConsultationException;
import com.example.demo.exception.ConsultationNotFoundException;
import com.example.demo.model.Consultation;
import com.example.demo.repository.ConsultationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ConsultationServiceImpl implements ConsultationService {
    final ConsultationRepo consultationRepo;

    public ConsultationServiceImpl(ConsultationRepo consultationRepo) {
        this.consultationRepo = consultationRepo;
    }

    @Override
    @Transactional
    public Consultation createConsultation(Consultation c) throws ConsultationException {
    try{
        return consultationRepo.save(c);
    } catch (Exception e){
        throw new ConsultationException("Erreur dans la creation de la consultation.", e);
    }
    }

    @Override
    @Transactional(readOnly = true)

    public Consultation getConsultation(Long id) throws ConsultationNotFoundException {
        return consultationRepo.findById(id).orElseThrow(() -> new ConsultationNotFoundException("la consultation avec l'identifiant " + id +" non trouvé") );
    }

    @Override
    @Transactional(readOnly = true)

    public List<Consultation> getAllConsultation() throws ConsultationException {
        try {
            return consultationRepo.findAll();
        } catch (Exception e){
            throw new ConsultationException("Erreur lors de la recuperation des consultation.", e);
        }
    }



    @Override
    @Transactional

    public Consultation updateConsultation(Consultation c) throws ConsultationException, ConsultationNotFoundException {
        Consultation consultation = getConsultation(c.getId());
        consultation.setDateConsultation(c.getDateConsultation());
        consultation.setRapportConsultation(c.getRapportConsultation());
        consultation.setRendezVous(c.getRendezVous());
        try{
          return  consultationRepo.save(c);
        }catch(Exception e){
            throw new ConsultationException("Erreur lors de la modification de la consultation.", e);
        }
    }

    @Override
    @Transactional

    public String deleteConsultation(Long id) throws ConsultationException, ConsultationNotFoundException {
        Consultation consultation = getConsultation(id);

        try {
            consultationRepo.delete(consultation);
            return "La consultation avec l'idantifiant " + id + " a ete supprimee";
        } catch(Exception e){
            throw new ConsultationException("Erreur lors de la suppression de la consultation.", e);
    }}
}
