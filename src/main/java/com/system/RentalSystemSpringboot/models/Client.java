package com.system.RentalSystemSpringboot.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Client")
@PrimaryKeyJoinColumn(name = "id")
public class Client extends Utilisateur{







    @Column(nullable = false, unique = true)
    private String cin;
    @Column(nullable = false, unique = true)
    private String numeropermis;


    private String numerotelephone;
    private String adresse;
    private String ville;
    private String codePostal;
}
