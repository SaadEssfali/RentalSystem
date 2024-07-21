package com.system.RentalSystemSpringboot.repository;

import com.system.RentalSystemSpringboot.models.Client;
import com.system.RentalSystemSpringboot.models.Reservation;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByClient( Optional<Client> client);
    @Query("SELECT COUNT(r) FROM Reservation r WHERE r.client.id = :clientId")
    long countReservationsByClientId(@Param("clientId") Long clientId);
    @Query("SELECT COUNT(r) FROM Reservation r ")
    long totalreservationnumber();
    @Query("SELECT SUM(r.prixtotal) FROM Reservation r")
    Double totalOfRevenue();

    @Query("SELECT COUNT(r) FROM Reservation r where r.statut='canceled' and r.client.id=:clientId")
    long totalreservationnumbercanceled(@Param("clientId") Long clientId);
    @Query("SELECT COUNT(r) FROM Reservation r where r.statut='pending' and r.client.id=:clientId")
    long totalreservationnumberpending(@Param("clientId") Long clientId);
    @Query("SELECT COUNT(r) FROM Reservation r where r.statut='scheduled' and r.client.id=:clientId")
    long totalreservationnumberscheduled(@Param("clientId") Long clientId);

}

