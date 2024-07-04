package com.system.RentalSystemSpringboot.services;

import com.system.RentalSystemSpringboot.DTO.UserDTO;
import com.system.RentalSystemSpringboot.models.Utilisateur;
import com.system.RentalSystemSpringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public void registerUser(UserDTO userDTO) throws Exception {
        try {
            Utilisateur user = new Utilisateur();
            user.setNom(userDTO.getLastName());
            user.setPrenom(userDTO.getFirstName());
            user.setEmail(userDTO.getEmail());
            user.setKeycloakId(userDTO.getKeycloakId());
            user.setNumeroTelephone(userDTO.getPhone());
            user.setEnabled(true); // default value
            user.setAccountLocked(false); // default value
            user.setEtat("active"); // default value
            userRepository.save(user);
        } catch (Exception e) {
            logger.error("Error saving user to the database", e);
            throw new Exception("Error saving user to the database: " + e.getMessage());
        }
    }
}
