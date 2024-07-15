package com.example.demo.service;

import com.example.demo.exception.RendezVousException;
import com.example.demo.exception.RendezVousNotFoundException;
import com.example.demo.model.RendezVous;
import com.example.demo.repository.RendezVousRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

public class RendezVousServiceImpl implements RendezVousService {
    @Autowired
    RendezVousRepo rendezVousRepo;
    @Override
    @Transactional
    public RendezVous createRendezVous(RendezVous rendezVous) throws RendezVousException {
        try{
            return rendezVousRepo.save(rendezVous);
        }catch (Exception e){
            throw new RendezVousException("Erreur lors de la creation du patient", e);
        }
    }

    @Override
    public RendezVous getRendezVous(Long id) throws RendezVousNotFoundException {
        return  rendezVousRepo.findById(id).orElseThrow(() -> new RendezVousNotFoundException("Le rendez vou avec l'identifiant "+id+"non trouve"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RendezVous> getAllRendezVous() throws RendezVousException {
        try{
            return rendezVousRepo.findAll();
        } catch(Exception e){
            throw new RendezVousException("Erreur lors de la recuperation de la liste des patients",e);
        }
    }

    @Override
    @Transactional
    public RendezVous updateRendezVous(RendezVous rendezVous) throws RendezVousException, RendezVousNotFoundException {
        RendezVous rendezVous1 = getRendezVous(rendezVous.getId());
        rendezVous1.setHeureRDV(rendezVous.getHeureRDV());
        rendezVous1.setPatient(rendezVous.getPatient());
        rendezVous1.setMedcin(rendezVous.getMedcin());
        rendezVous1.setConsultation(rendezVous.getConsultation());
        try{
           return rendezVousRepo.save(rendezVous);
        }catch(Exception e){
            throw new RendezVousException("Erreur lors de la modification des informations du rendez vous", e);
        }
    }

    @Override
    @Transactional
    public String deleteRendezVous(Long id) throws RendezVousException, RendezVousNotFoundException {
        RendezVous rendezVous = getRendezVous(id);
        try{
             rendezVousRepo.delete(rendezVous);
             return "Le rendez vous a ete supprime";
        }catch(Exception e){
            throw new RendezVousException("Erreur lors de la suppression des informations du rendez vous", e);
        }
    }
}
