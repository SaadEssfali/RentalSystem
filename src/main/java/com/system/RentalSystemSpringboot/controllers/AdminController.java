package com.system.RentalSystemSpringboot.controllers;

import com.system.RentalSystemSpringboot.models.Reservation;
import com.system.RentalSystemSpringboot.services.ClientService;
import com.system.RentalSystemSpringboot.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {

    @Autowired
    private  ReservationService reservationService;
    @Autowired
    private ClientService clientService;

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
}
