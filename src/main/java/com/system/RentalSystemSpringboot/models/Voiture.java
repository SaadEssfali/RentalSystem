package com.system.RentalSystemSpringboot.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Date;

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

    private Double prixparjour;
    private String statut;
    private String marque;
    private String modele;
    private int kilometrage;
    private String typecarburant;
    private Date miseenroute;
    private int nombredeporte;
    private String carrosserie;
    private int nbresiege;
    private String transmissiontype;
    private String consommationdecarburant;
    private String couleurexterieure;
    private int volumedecofrre;
    private String couleurinterieur;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;




}
