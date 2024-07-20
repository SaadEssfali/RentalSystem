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
    public Voiture findById(long id) {
        Optional<Voiture> voiture= voitureRepository.findById(id);
        if (voiture.isPresent()) {
            return voiture.get();
        }
        else {
            throw new RuntimeException("Voiture non trouvable");
        }
    }
    public void delete(Long id) {
        Optional<Voiture> voiturecheck=voitureRepository.findById(id);
        if (voiturecheck.isPresent()) {
            Voiture deletevoiture=voiturecheck.get();
            voitureRepository.delete(deletevoiture);
        }
        else throw new RuntimeException("voiture introuvable");

    }
    public  Voiture updateVoiture(Voiture voiture) {
        Optional<Voiture> voitureOptional=voitureRepository.findById(voiture.getIdvoiture());
        if (voitureOptional.isPresent()) {
            Voiture updatedvoiture=voitureOptional.get();
            updatedvoiture.setMarque(voiture.getMarque());
            updatedvoiture.setModele(voiture.getModele());

            updatedvoiture.setKilometrage(voiture.getKilometrage());
            updatedvoiture.setNumeroimmatriculation(voiture.getNumeroimmatriculation());
            updatedvoiture.setPrixparjour(voiture.getPrixparjour());
            updatedvoiture.setTypecarburant(voiture.getTypecarburant());

            return voitureRepository.save(updatedvoiture);

        }
        else throw new RuntimeException("voiture introuvable");
    }


}
