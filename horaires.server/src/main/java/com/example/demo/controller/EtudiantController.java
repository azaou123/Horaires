package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EtudiantDTO;
import com.example.demo.entity.Etudiant;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/etudiant")

public class EtudiantController {

    @Autowired
    private UserService userService;
    @Autowired
    private EtudiantRepository etudiantRepository;

    @PostMapping
    public ResponseEntity<?> createEtudiant(@RequestBody Etudiant etudiant) {
        System.out.println("Received request to create etudiant: " + etudiant);
        userService.saveEtudiant(etudiant);
        return ResponseEntity.ok("Etudiant registered successfully");
    }


    @GetMapping
    public List<EtudiantDTO> getAllEtudiants() {
        return etudiantRepository.findAll().stream()
            .map(EtudiantDTO::new)
            .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EtudiantDTO> getEtudiantById(@PathVariable Long id) {
        Etudiant etudiant = userService.getEtudiantById(id);
        if (etudiant != null) {
            return ResponseEntity.ok(new EtudiantDTO(etudiant));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtudiantDTO> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        Etudiant updatedEtudiant = userService.updateEtudiant(id, etudiant);
        if (updatedEtudiant != null) {
            return ResponseEntity.ok(new EtudiantDTO(updatedEtudiant));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        userService.deleteEtudiant(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/{etudiantId}/filieres/{filiereId}")
    public ResponseEntity<EtudiantDTO> addEtudiantToFiliere(@PathVariable Long etudiantId, @PathVariable Long filiereId) {
        Etudiant etudiant = userService.getEtudiantById(etudiantId);
        if (etudiant != null) {
            Etudiant updatedEtudiant = userService.addEtudiantToFiliere(filiereId, etudiant);
            return ResponseEntity.ok(new EtudiantDTO(updatedEtudiant));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}