package com.system.RentalSystemSpringboot.controllers;

import com.system.RentalSystemSpringboot.models.Client;
import com.system.RentalSystemSpringboot.models.Reservation;
import com.system.RentalSystemSpringboot.models.Voiture;
import com.system.RentalSystemSpringboot.services.ClientService;
import com.system.RentalSystemSpringboot.services.ReservationService;
import com.system.RentalSystemSpringboot.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {

    @Autowired
    private  ReservationService reservationService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private VoitureService voitureService;

    @GetMapping("/reservation/totalreservation")
    public ResponseEntity<Integer> getotalreservationnumber(){

        int nombe=reservationService.gettotalnumberreservatiion();
        if (nombe>=0){
            return ResponseEntity.ok(nombe);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/client/totalnumber")
    public ResponseEntity<Integer> gettotalnumber(){
        int nombre=clientService.totalclientnumber();
        if (nombre>=0){
            return ResponseEntity.ok(nombre);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getallreservation(){
        if (reservationService.getall().size()>0){
            return ResponseEntity.ok(reservationService.getall());
        }
        else {

            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/reservation/totalrevenue")
    public ResponseEntity<Double> totalrevenue(){
        if (reservationService.totalrevenue()>-1){
            return ResponseEntity.ok(reservationService.totalrevenue());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/reservation/statutupdate")
    public ResponseEntity<Reservation> updateReservationStatus(@RequestBody Reservation reservation) {
        try {
            Reservation updatedReservation = reservationService.save(reservation);
            return ResponseEntity.ok(updatedReservation);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Return 500 Internal Server Error in case of failure
        }
    }

    @GetMapping("/{clientId}/balance-spent")
    public ResponseEntity<Double> getTotalBalanceSpent(@PathVariable Long clientId) {
        Double totalBalanceSpent = clientService.getTotalBalanceSpent(clientId);
        return ResponseEntity.ok(totalBalanceSpent);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        if (clientService.findAll().size()>0){
            return ResponseEntity.ok(clientService.findAll());

        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/voitures/update")
    public ResponseEntity<Voiture> updateVoiture(@RequestBody Voiture voiture) {
        if (voiture!=null) {
            voitureService.updateVoiture(voiture);
            return ResponseEntity.ok(voiture);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/voitures/add")
    public ResponseEntity<Voiture> addVoiture(@RequestBody Voiture voiture) {
        if (voiture!=null) {
            voitureService.save(voiture);
            return ResponseEntity.ok(voiture);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
