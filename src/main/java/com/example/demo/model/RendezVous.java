package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date dateRDV;
    @Column
    private Date heureRDV;
    @OneToOne
    private Consultation consultation;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medcin medcin;
}
