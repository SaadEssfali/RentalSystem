package com.system.RentalSystemSpringboot.controllers;


import com.system.RentalSystemSpringboot.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/utilisateur")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
}
