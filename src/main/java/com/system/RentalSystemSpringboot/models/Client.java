package com.system.RentalSystemSpringboot.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Client")
@EntityListeners(AuditingEntityListener.class)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idclient;
    private String prenom;
    private String nom;

    @Lob
    private byte[] permis;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String cin;
    @Column(nullable = false, unique = true)
    private String numeropermis;

    private String numerotelephone;
    private String adresse;
    private String ville;
    private String etat;
    private String codePostal;
}
