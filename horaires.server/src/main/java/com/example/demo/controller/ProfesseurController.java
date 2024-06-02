package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.ProfesseurDTO;
import com.example.demo.entity.Professeur;
import com.example.demo.entity.Intervention;
import com.example.demo.service.UserService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ProfesseurDTO> createProfesseur(@RequestBody ProfesseurDTO professeurDTO) {
        Professeur professeur = new Professeur();
        professeur.setNom(professeurDTO.getNom());
        professeur.setPrenom(professeurDTO.getPrenom());
        professeur.setEmail(professeurDTO.getEmail());
        professeur.setPassword(professeurDTO.getPassword());
        Professeur savedProfesseur = userService.saveProfesseur(professeur);
        return ResponseEntity.ok(new ProfesseurDTO(savedProfesseur.getId(), savedProfesseur.getNom(),
                savedProfesseur.getPrenom(), savedProfesseur.getEmail(), savedProfesseur.getPassword()));
    }

    @GetMapping
    public ResponseEntity<List<ProfesseurDTO>> getAllProfesseurs() {
        List<Professeur> professeurs = userService.getAllProfesseurs();
        List<ProfesseurDTO> professeurDTOs = professeurs.stream().map(p -> {
            List<Long> interventionIds = p.getInterventions().stream().map(Intervention::getId)
                    .collect(Collectors.toList());
            return new ProfesseurDTO(p.getId(), p.getNom(), p.getPrenom(), p.getEmail(), p.getPassword(),
                    interventionIds);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(professeurDTOs);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProfesseurDTO> getProfesseurById(@PathVariable Long id) {
        Professeur professeur = userService.getProfesseurById(id);
        if (professeur != null) {
            List<Long> interventionIds = professeur.getInterventions().stream().map(Intervention::getId)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(new ProfesseurDTO(professeur.getId(), professeur.getNom(), professeur.getPrenom(),
                    professeur.getEmail(), professeur.getPassword(), interventionIds));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesseurDTO> updateProfesseur(@PathVariable Long id,
            @RequestBody ProfesseurDTO professeurDTO) {
        Professeur professeur = new Professeur();
        professeur.setId(id);
        professeur.setNom(professeurDTO.getNom());
        professeur.setPrenom(professeurDTO.getPrenom());
        professeur.setEmail(professeurDTO.getEmail());
        professeur.setPassword(professeurDTO.getPassword());
        Professeur updatedProfesseur = userService.updateProfesseur(id, professeur);
        if (updatedProfesseur != null) {
            return ResponseEntity.ok(new ProfesseurDTO(updatedProfesseur.getId(), updatedProfesseur.getNom(),
                    updatedProfesseur.getPrenom(), updatedProfesseur.getEmail(), updatedProfesseur.getPassword()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfesseur(@PathVariable Long id) {
        userService.deleteProfesseur(id);
        return ResponseEntity.noContent().build();
    }

    /*@PostMapping("/{id}/interventions")
    public ResponseEntity<ProfesseurDTO> addInterventionToProfesseur(@PathVariable Long id, @RequestBody Intervention intervention) {
        Intervention addedIntervention = userService.addInterventionToProfesseur(id, intervention);
        Professeur updatedProfesseur = userService.getProfesseurById(id);
        
        List<Long> interventionIds = updatedProfesseur.getInterventions().stream()
                                              .map(Intervention::getId)
                                              .collect(Collectors.toList());
        
        ProfesseurDTO professeurDTO = new ProfesseurDTO(updatedProfesseur.getId(), updatedProfesseur.getNom(), updatedProfesseur.getPrenom(), updatedProfesseur.getEmail(), updatedProfesseur.getPassword(), interventionIds);
        
        return ResponseEntity.ok(professeurDTO);
    }*/


}
