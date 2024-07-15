package com.example.demo.controller;

import com.example.demo.model.RendezVous;
import com.example.demo.service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rendezvous")
public class RendezVousController {

    @Autowired
    RendezVousService rendezVousService;

    
}
