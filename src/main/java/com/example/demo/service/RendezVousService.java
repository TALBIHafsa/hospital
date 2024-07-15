package com.example.demo.service;

import com.example.demo.exception.RendezVousException;
import com.example.demo.exception.RendezVousNotFoundException;
import com.example.demo.model.RendezVous;

import java.util.List;

public interface RendezVousService {
    RendezVous createRendezVous(RendezVous rendezVous) throws RendezVousException;
    RendezVous getRendezVous(Long id) throws RendezVousNotFoundException;
    List<RendezVous> getAllRendezVous() throws RendezVousException;
    RendezVous updateRendezVous(RendezVous rendezVous) throws RendezVousException, RendezVousNotFoundException;
    String deleteRendezVous(Long id) throws RendezVousException, RendezVousNotFoundException;
}
