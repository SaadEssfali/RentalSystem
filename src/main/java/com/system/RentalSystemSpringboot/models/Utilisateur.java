package com.system.RentalSystemSpringboot.models;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Utilisateur")
@EntityListeners(AuditingEntityListener.class)
public class Utilisateur implements UserDetails, Principal {

    @Id
    @GeneratedValue
    private long id;

    private String nom;
    private String prenom;


    @Column(nullable = false,unique = true)
    private String email;
    private String password;


    private String numerpTelephone;

    private String adresse;
    private String ville;
    private String etat;
    private String codepostal;
    private boolean accountlocked;
    private boolean enabled;

    @CreatedDate
    @Column(nullable = false,updatable = false)
    private LocalDateTime creatdDate;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;
    private String role;

    @Override
    public String getName() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountlocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
    public String fullName(){
        return prenom+""+nom;
    }
}
