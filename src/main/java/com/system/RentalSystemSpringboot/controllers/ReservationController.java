package com.system.RentalSystemSpringboot.controllers;


import com.system.RentalSystemSpringboot.models.Reservation;
import com.system.RentalSystemSpringboot.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations =reservationService.findall();
        if (reservations.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.ok(reservations);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable long id) {
        Reservation reservation = reservationService.findbyid(id);
        if (reservation == null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(reservation);
        }
    }
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation savedReservation = reservationService.save(reservation);
        if (savedReservation == null){
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.ok(savedReservation);
        }
    }

    @PutMapping("/{idreservation}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable long idreservation, @RequestBody Reservation reservation) {
        Reservation savedReservation = reservationService.save(reservation);
        if (savedReservation == null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(savedReservation);
        }
    }

    @DeleteMapping
    public ResponseEntity<Reservation> deleteReservation(@PathVariable long idreservation) {
        Reservation reservation = reservationService.findbyid(idreservation);
        if (reservation == null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(reservation);
        }
    }
}
