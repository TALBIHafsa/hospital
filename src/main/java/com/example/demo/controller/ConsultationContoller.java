package com.example.demo.controller;

import com.example.demo.exception.ConsultationException;
import com.example.demo.exception.ConsultationNotFoundException;
import com.example.demo.model.Consultation;
import com.example.demo.service.ConsultationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultation")
public class ConsultationContoller {
    final
    ConsultationService consultationService;


    public ConsultationContoller(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @PostMapping
    public ResponseEntity<?> createConsultation(@RequestBody Consultation c){
        try{
            Consultation consultation = consultationService.createConsultation(c);
            return ResponseEntity.ok(consultation);
        } catch (ConsultationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getConsultation(){
        try{
            List<Consultation> consultations = consultationService.getAllConsultation();
            return  ResponseEntity.ok(consultations);
        } catch (ConsultationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updateConsultation(@RequestBody Consultation c){
        try{
            Consultation consultation = consultationService.updateConsultation(c);
            return  ResponseEntity.ok(consultation);
        } catch (ConsultationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (ConsultationNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConsultation(@PathVariable Long id){
        try{
            String message = consultationService.deleteConsultation(id);
            return  ResponseEntity.ok(message);
        } catch (ConsultationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (ConsultationNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
