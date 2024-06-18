package com.system.RentalSystemSpringboot.repository;

import com.system.RentalSystemSpringboot.models.Client;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);
    Optional<Client> findByNumeropermis(String numeropermis);
    Optional<Client> findByCin(String cin);

    @Transactional
    @Modifying
    @Query("UPDATE Client c SET c.etat = 'supprimé' WHERE c.idclient = :clientId")
    int updateClientEtatById(@Param("clientId") Long clientId);
}
