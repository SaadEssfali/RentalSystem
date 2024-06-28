package com.system.RentalSystemSpringboot.services;

import com.system.RentalSystemSpringboot.models.Utilisateur;
import com.system.RentalSystemSpringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UtilisateurService {

    @Autowired
    private UserRepository userRepository;



}
