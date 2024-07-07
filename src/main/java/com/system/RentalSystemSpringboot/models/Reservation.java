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
@Table(name = "Reservation")
@EntityListeners(AuditingEntityListener.class)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationid;

    @ManyToOne
    @JoinColumn(name = "voitureid",nullable = false)
    Voiture  voiture;

    @ManyToOne
    @JoinColumn(name = "clientid",nullable = false)
    private Client client;

    private LocalDate datedebut;
    private LocalDate datefin;

    private String statut;

    private String commentaires;

    private int kilometragedebut;
    private int kilometragefin;
}
