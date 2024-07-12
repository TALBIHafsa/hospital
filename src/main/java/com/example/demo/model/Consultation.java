package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Builder
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Temporal(TemporalType.DATE)
    private Date dateConsultation;
    @Column
    private String rapportConsultation;
    @OneToOne
    private RendezVous rendezVous;

}
