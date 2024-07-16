package com.example.demo.controller;

import com.example.demo.exception.RendezVousException;
import com.example.demo.exception.RendezVousNotFoundException;
import com.example.demo.model.RendezVous;
import com.example.demo.service.RendezVousService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rendezvous")
public class RendezVousController {
    final
    RendezVousService rendezVousService;

    public RendezVousController(RendezVousService rendezVousService) {
        this.rendezVousService = rendezVousService;
    }

    @PostMapping
    public ResponseEntity<?> createrendezVous(@RequestBody RendezVous c){
        try{
            RendezVous rendezVous = rendezVousService.createRendezVous(c);
            return ResponseEntity.ok(rendezVous);
        } catch (RendezVousException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getrendezVous(){
        try{
            List<RendezVous> rendezVouss = rendezVousService.getAllRendezVous();
            return  ResponseEntity.ok(rendezVouss);
        } catch (RendezVousException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updaterendezVous(@RequestBody RendezVous r){
        try{
            RendezVous rendezVous = rendezVousService.updateRendezVous(r);
            return  ResponseEntity.ok(rendezVous);
        } catch (RendezVousException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (RendezVousNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleterendezVous(@PathVariable Long id){
        try{
            String message = rendezVousService.deleteRendezVous(id);
            return  ResponseEntity.ok(message);
        } catch (RendezVousException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (RendezVousNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
