package com.system.RentalSystemSpringboot.repository;

import com.system.RentalSystemSpringboot.models.Voiture;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Long> {
    Optional<Voiture> findByNumeroimmatriculation(String numeroimmatriculation);

}
