package com.system.RentalSystemSpringboot.controllers;


import com.system.RentalSystemSpringboot.models.Reservation;
import com.system.RentalSystemSpringboot.services.ClientService;
import com.system.RentalSystemSpringboot.services.ReservationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@Validated
public class ReservationController {

    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        logger.info("Récupération de toutes les réservations");
        List<Reservation> reservations = reservationService.findall();
        if (reservations.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(reservations);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable long id) {
        logger.info("Récupération de la réservation avec l'id {}", id);
        Reservation reservation = reservationService.findbyid(id);
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(reservation);
        }
    }



    @PostMapping
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation) {
        logger.info("Création d'une nouvelle réservation");

        Reservation savedReservation = reservationService.save(reservation);
        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
    }

    @PutMapping("/{idreservation}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable long idreservation, @Valid @RequestBody Reservation reservation) {
        logger.info("Mise à jour de la réservation avec l'id {}", idreservation);
        Reservation existingReservation = reservationService.findbyid(idreservation);
        if (existingReservation == null) {
            return ResponseEntity.notFound().build();
        } else {
            reservation.setReservationid(idreservation);
            Reservation updatedReservation = reservationService.save(reservation);
            return ResponseEntity.ok(updatedReservation);
        }
    }

    @GetMapping("/client/{keycloack}")
    public ResponseEntity <List<Reservation>> getReservationByKeycloack(@PathVariable String keycloack) {

        List<Reservation> clientreservation=reservationService.findreservationbykeycloackid(keycloack);
        if (clientreservation != null) {
            return ResponseEntity.ok(clientreservation);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }


}