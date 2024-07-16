package com.example.demo.controller;

import com.example.demo.exception.PatientException;
import com.example.demo.exception.PatientNotFoundException;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    final
    PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<?> createPatient(@RequestBody Patient p){
        try{
            Patient patient = patientService.createPatient(p);
            return ResponseEntity.ok(patient);
        } catch (PatientException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllPatients(){
        try{
            List<Patient> Patients = patientService.getAllPatients();
            return  ResponseEntity.ok(Patients);
        } catch (PatientException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        try{
            Patient patient = patientService.getPatient(id);
            return  ResponseEntity.ok(patient);
        } catch (PatientNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updatePatient(@RequestBody Patient c){
        try{
            Patient patient = patientService.updatePatient(c);
            return  ResponseEntity.ok(patient);
        } catch (PatientException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (PatientNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id){
        try{
            String message = patientService.deletePatient(id);
            return  ResponseEntity.ok(message);
        } catch (PatientException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (PatientNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
