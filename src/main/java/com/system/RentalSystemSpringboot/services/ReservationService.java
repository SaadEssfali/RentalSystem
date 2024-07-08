package com.system.RentalSystemSpringboot.services;

import com.system.RentalSystemSpringboot.models.Client;
import com.system.RentalSystemSpringboot.models.Reservation;
import com.system.RentalSystemSpringboot.repository.ReservationRepository;
import com.system.RentalSystemSpringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    public List<Reservation> findByClient(Optional<Client> client){
        Optional<List<Reservation>> reservations= Optional.ofNullable(reservationRepository.findByClient(client));
        if (reservations.isPresent()){
            return reservations.get();
        }
        else {
            throw new RuntimeException("Aucune reservation trouver pour ce client");
        }
    }

    public List<Reservation> findall(){

        return  reservationRepository.findAll();
    }

    public Reservation findbyid(Long id){
        Optional<Reservation> reservation= reservationRepository.findById(id);
        if (reservation.isPresent()){
            return reservation.get();
        }
        else throw new RuntimeException("Aucune reservation trouvé");
    }

    public Reservation save(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public List <Reservation> findreservationbykeycloackid(String keycloackid){
        Optional<Client> client=userRepository.findByKeycloakId(keycloackid);
        if(client.isPresent()){
            return findByClient(client);
        }
        else {
            throw new RuntimeException("Aucune reservation trouver pour ce client");
        }


    }



}
