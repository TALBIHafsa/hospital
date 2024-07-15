package com.example.demo.service;

import com.example.demo.exception.PatientException;
import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.model.Patient;

import java.util.List;

public interface PatientService {
    Patient createPatient(Patient patient) throws PatientException;
    List<Patient> getAllPatients()  throws PatientException;
    Patient getPatient(Long id) throws PatientNotFoundException;
    Patient updatePatient(Patient p) throws PatientException, PatientNotFoundException;
    String deletePatient(Long id) throws PatientException, PatientNotFoundException;

}
