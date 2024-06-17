package com.system.RentalSystemSpringboot.services;

import com.system.RentalSystemSpringboot.models.Utilisateur;
import com.system.RentalSystemSpringboot.models.Voiture;
import com.system.RentalSystemSpringboot.repository.UserRepository;
import com.system.RentalSystemSpringboot.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoitureService {

    @Autowired
    VoitureRepository voitureRepository;
    @Autowired
    private UserRepository userRepository;

    public Voiture save(Voiture voiture) {

        return voitureRepository.save(voiture);

    }
    public List<Voiture> findAll() {
        return voitureRepository.findAll();
    }
    public Optional<Voiture> findById(long id) {
        return voitureRepository.findById(id);
    }
    public void delete(Voiture voiture) {
        Optional<Utilisateur> voiturecheck=userRepository.findById(voiture.getIdvoiture());
        if (voiturecheck.isPresent()) {
            voitureRepository.delete(voiture);
        }
        else throw new RuntimeException("voiture introuvable");

    }
    public  Voiture updateVoiture(Voiture voiture) {
        Optional<Voiture> voitureOptional=voitureRepository.findById(voiture.getIdvoiture());
        if (voitureOptional.isPresent()) {
            Voiture updatedvoiture=voitureOptional.get();
            updatedvoiture.setMarque(voiture.getMarque());
            updatedvoiture.setModele(voiture.getModele());
            updatedvoiture.setImage(voiture.getImage());
            updatedvoiture.setAnneefabrication(voiture.getAnneefabrication());
            updatedvoiture.setKilometrage(voiture.getKilometrage());
            updatedvoiture.setDateFinAssurance(voiture.getDateFinAssurance());
            updatedvoiture.setNomAssurance(voiture.getNomAssurance());
            updatedvoiture.setNumeroimmatriculation(voiture.getNumeroimmatriculation());
            updatedvoiture.setPrixParJour(voiture.getPrixParJour());
            updatedvoiture.setStatut(voiture.getStatut());
            updatedvoiture.setTypecarburant(voiture.getTypecarburant());

            return voitureRepository.save(updatedvoiture);

        }
        else throw new RuntimeException("voiture introuvable");
    }


}
