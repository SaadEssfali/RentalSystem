package com.system.RentalSystemSpringboot.controllers;

import com.system.RentalSystemSpringboot.models.Client;
import com.system.RentalSystemSpringboot.models.Utilisateur;
import com.system.RentalSystemSpringboot.repository.UserRepository;
import com.system.RentalSystemSpringboot.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
@Validated
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_admin')")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.findAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable long id) {
        Client client = clientService.findById(id);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/keycloackid/{keycloackid}")
    public ResponseEntity<Client> getClientByKeycloackId(@PathVariable String keycloackid) {
        Optional<Client> client=userRepository.findByKeycloakId(keycloackid);
        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
        }

    @PostMapping
    public ResponseEntity<Client> addClient(@Valid @RequestBody Client client) {
        Client savedClient = clientService.save(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable long id, @Valid @RequestBody Client client) {
        try {
            Client updatedClient = clientService.update(id, client);
            if (updatedClient != null) {
                return ResponseEntity.ok(updatedClient);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable long id) {
        try {
            clientService.updateClientEtat(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
