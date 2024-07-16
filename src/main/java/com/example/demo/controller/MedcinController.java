package com.example.demo.controller;

import com.example.demo.exception.MedcinException;
import com.example.demo.exception.MedcinNotFoundException;
import com.example.demo.model.Medcin;
import com.example.demo.service.MedcinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/medcin")
public class MedcinController {
    final
    MedcinService medcinService;

    public MedcinController(MedcinService medcinService) {
        this.medcinService = medcinService;
    }

    @PostMapping
    public ResponseEntity<?> createMedcin(@RequestBody Medcin m){
        try{
            Medcin medcin = medcinService.createMedcin(m);
            return ResponseEntity.ok(medcin);
        } catch (MedcinException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllMedcins(){
        try{
            List<Medcin> medcins = medcinService.getAllMedcins();
            return  ResponseEntity.ok(medcins);
        } catch (MedcinException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMedcin(@PathVariable Long id){
        try{
            Medcin medcin = medcinService.getMedcin(id);
            return  ResponseEntity.ok(medcin);
        } catch (MedcinNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updateMedcin( @RequestBody Medcin m){
        try{
            Medcin medcin = medcinService.updateMedcin(m);
            return  ResponseEntity.ok(medcin);
        } catch (MedcinException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (MedcinNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedcin(@PathVariable Long id){
        try{
            String message = medcinService.deleteMedcin(id);
            return  ResponseEntity.ok(message);
        } catch (MedcinException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (MedcinNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
