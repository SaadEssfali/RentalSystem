package com.system.RentalSystemSpringboot.controllers;


import com.system.RentalSystemSpringboot.models.Utilisateur;
import com.system.RentalSystemSpringboot.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;


}
