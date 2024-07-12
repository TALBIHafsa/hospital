package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String nom;
    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "patient")
    private Collection<RendezVous> rendezVous;
}
