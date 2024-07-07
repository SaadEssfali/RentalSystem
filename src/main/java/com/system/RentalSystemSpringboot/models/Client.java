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







    private String cin;
    private String numeropermis;


    private String numerotelephone;
    private String adresse;
    private String ville;
    private String codePostal;
}
