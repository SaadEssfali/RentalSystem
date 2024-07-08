package com.system.RentalSystemSpringboot.repository;

import com.system.RentalSystemSpringboot.models.Client;
import com.system.RentalSystemSpringboot.models.Reservation;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByClient( Optional<Client> client);


}

