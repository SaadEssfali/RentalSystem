package com.system.RentalSystemSpringboot.repository;

import com.system.RentalSystemSpringboot.models.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Long> {
    Optional<Voiture> findByNumeroimmatriculation(String numeroimmatriculation);
}
