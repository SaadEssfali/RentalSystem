package com.system.RentalSystemSpringboot.controllers;

import com.system.RentalSystemSpringboot.models.Voiture;
import com.system.RentalSystemSpringboot.services.VoitureService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/voiture")
@Validated
public class VoitureController {

    private static final Logger logger = LoggerFactory.getLogger(VoitureController.class);

    @Autowired
    private VoitureService voitureService;

    @GetMapping("/{voitureid}")
    public ResponseEntity<Voiture> getVoiture(@PathVariable Long voitureid) {
        logger.info("Récupération de la Voiture avec l'id {}", voitureid);
        Voiture voiture = voitureService.findById(voitureid);
        if (voiture == null) {
            logger.warn("Voiture avec l'id {} non trouvée", voitureid);
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(voiture);
        }
    }

    @PutMapping("/{idvoiture}")
    public ResponseEntity<Voiture> updateVoiture(@PathVariable Long idvoiture, @Valid @RequestBody Voiture voiture) {
        logger.info("Mise à jour de la Voiture avec l'id {}", idvoiture);
        Voiture existingVoiture = voitureService.findById(idvoiture);
        if (existingVoiture == null) {
            logger.warn("Voiture avec l'id {} non trouvée", idvoiture);
            return ResponseEntity.notFound().build();
        } else {
            voiture.setIdvoiture(idvoiture);
            return ResponseEntity.ok(voitureService.updateVoiture(voiture));
        }
    }

    @DeleteMapping("/{idvoiture}")
    public ResponseEntity<Void> deleteVoiture(@PathVariable Long idvoiture) {
        logger.info("Suppression de la Voiture avec l'id {}", idvoiture);
        try {
            voitureService.delete(idvoiture);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            logger.error("Erreur lors de la suppression de la Voiture avec l'id {}", idvoiture, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
