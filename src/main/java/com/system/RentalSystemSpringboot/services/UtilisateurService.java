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

    public Utilisateur save(Utilisateur user){
        return userRepository.save(user);
    }
    public Utilisateur update(Long id,Utilisateur user){
        Optional<Utilisateur> utilisatuer=userRepository.findById(id);
        if (utilisatuer.isPresent()){
          Utilisateur  Utilisateurupdated=utilisatuer.get();
          Utilisateurupdated.setEmail(user.getEmail());
          Utilisateurupdated.setAdresse(user.getAdresse());
          Utilisateurupdated.setEtat(user.getEtat());
          Utilisateurupdated.setNom(user.getNom());
          Utilisateurupdated.setNumerpTelephone(user.getNumerpTelephone());
          Utilisateurupdated.setEnabled(user.isEnabled());
          Utilisateurupdated.setCodepostal(user.getCodepostal());
          Utilisateurupdated.setRole(user.getRole());
          Utilisateurupdated.setVille(user.getVille());
          Utilisateurupdated.setAccountlocked(user.isAccountlocked());
          Utilisateurupdated.setPrenom(user.getPrenom());
          Utilisateurupdated.setPassword(user.getPassword());
          Utilisateurupdated.setCreatdDate(user.getCreatdDate());
          Utilisateurupdated.setLastModifiedDate(user.getLastModifiedDate());

          return userRepository.save(Utilisateurupdated);
        }
        else {
            throw  new  RuntimeException("Utilisateur introuvable");
        }
    }

    public void delete(Utilisateur user){
        Optional<Utilisateur> utilisatuer=userRepository.findById(user.getId());
        if (utilisatuer.isPresent()){
            user=utilisatuer.get();
        userRepository.delete(user);
        }
        else throw new RuntimeException("Utilisateur introuvable");
    }


}
