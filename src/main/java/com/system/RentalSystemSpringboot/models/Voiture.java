package com.system.RentalSystemSpringboot.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Voiture")
@EntityListeners(AuditingEntityListener.class)
public class Voiture {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idvoiture;

    @Column(nullable = false,unique = true)
    private String numeroimmatriculation;
    @Lob
    private byte[] image;
    private String nomAssurance;
    private LocalDate dateFinAssurance;
    private Double prixParJour;
    private String statut;
    private String marque;
    private String modele;
    private Integer kilometrage;
    private Integer anneefabrication;
    private String typecarburant;
}
