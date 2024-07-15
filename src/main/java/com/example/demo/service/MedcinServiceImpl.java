package com.example.demo.service;

import com.example.demo.exception.MedcinException;
import com.example.demo.exception.MedcinNotFoundException;
import com.example.demo.model.Medcin;
import com.example.demo.repository.MedcinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

public class MedcinServiceImpl implements MedcinService {
    final
    MedcinRepo medcinRepo;

    public MedcinServiceImpl(MedcinRepo medcinRepo) {
        this.medcinRepo = medcinRepo;
    }

    @Override
    @Transactional
    public Medcin createMedcin(Medcin medcin) throws MedcinException {
        try{
            return medcinRepo.save(medcin);
        }catch (Exception e){
            throw new MedcinException("Erreur lors de la creation d'un nouveau medcin.", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Medcin> getAllMedcins() throws MedcinException {
        try {
            return medcinRepo.findAll();
        } catch (Exception e){
            throw new MedcinException("Erreyr lors de la recuperation des medcins",e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Medcin getMedcin(Long id) throws  MedcinNotFoundException {
        return medcinRepo.findById(id).orElseThrow(() -> new MedcinNotFoundException("Le medcin avec l'identifiant "+ id + " non trouve"));
    }

    @Override
    @Transactional
    public Medcin updateMedcin(Medcin medcin) throws MedcinException, MedcinNotFoundException {
        Medcin medcin1 = getMedcin(medcin.getId());
        medcin1.setEmail(medcin1.getEmail());
        medcin1.setNom(medcin1.getNom());
        medcin1.setSpecialite(medcin1.getSpecialite());
        medcin1.setRendezVous(medcin1.getRendezVous());
        try{
            return medcinRepo.save(medcin);
        } catch (Exception e){
            throw new MedcinException("Erreur lors de la modification des informations du medcin", e);
        }
    }

    @Override
    @Transactional
    public String deleteMedcin(Long id) throws MedcinException, MedcinNotFoundException {
        Medcin medcin = getMedcin(id) ;
        try{
            medcinRepo.delete(medcin);
            return "Le medcin avec l'idantifiant " + id + "  a ete supprime";
        } catch (Exception e){
            throw new MedcinException("Erreur lors de la suppression des informations du medcin", e);

        }
    }
}
