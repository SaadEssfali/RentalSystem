package com.system.RentalSystemSpringboot.repository;

import com.system.RentalSystemSpringboot.models.Client;
import com.system.RentalSystemSpringboot.models.Utilisateur;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur,Long> {
    Optional<Client> findByEmail(String email);
    Optional<Client> findByKeycloakId(String keycloakId);

}
