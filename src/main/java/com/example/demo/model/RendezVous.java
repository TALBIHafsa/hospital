package com.example.demo.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.cert.CertPathBuilder;
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
    @Temporal(TemporalType.DATE)
    private Date dateRDV;
    @Column
    @Temporal(TemporalType.TIME)

    private Date heureRDV;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medcin medcin;


}
