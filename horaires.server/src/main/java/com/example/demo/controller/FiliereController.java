package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.FiliereDTO;
import com.example.demo.dto.ModuleDTO;
import com.example.demo.entity.Etudiant;
import com.example.demo.entity.Filiere;
import com.example.demo.entity.Modules;
import com.example.demo.service.FiliereService;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    @PostMapping
    public ResponseEntity<FiliereDTO> createFiliere(@RequestBody FiliereDTO filiereDTO) {
        Filiere filiere = new Filiere();
        filiere.setNomFiliere(filiereDTO.getNomFiliere());
        Filiere savedFiliere = filiereService.saveFiliere(filiere);
        return ResponseEntity.ok(new FiliereDTO(savedFiliere.getId(), savedFiliere.getNomFiliere()));
    }

    @GetMapping
    public ResponseEntity<List<FiliereDTO>> getAllFilieres() {
        List<Filiere> filieres = filiereService.getAllFilieres();
        List<FiliereDTO> filiereDTOs = filieres.stream().map(f -> {
            List<Long> moduleIds = f.getModules().stream().map(Modules::getId).collect(Collectors.toList());
            List<Long> etudiantIds = f.getEtudiants().stream().map(Etudiant::getId).collect(Collectors.toList());
            return new FiliereDTO(f.getId(), f.getNomFiliere(), moduleIds, etudiantIds);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(filiereDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FiliereDTO> getFiliereById(@PathVariable Long id) {
        Filiere filiere = filiereService.getFiliereById(id);
        List<Long> moduleIds = filiere.getModules().stream().map(Modules::getId).collect(Collectors.toList());
        List<Long> etudiantIds = filiere.getEtudiants().stream().map(Etudiant::getId).collect(Collectors.toList());
        return ResponseEntity.ok(new FiliereDTO(filiere.getId(), filiere.getNomFiliere(), moduleIds, etudiantIds));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FiliereDTO> updateFiliere(@PathVariable Long id, @RequestBody FiliereDTO filiereDTO) {
        Filiere filiere = new Filiere();
        filiere.setId(id);
        filiere.setNomFiliere(filiereDTO.getNomFiliere());
        Filiere updatedFiliere = filiereService.updateFiliere(id, filiere);
        if (updatedFiliere != null) {
            return ResponseEntity.ok(new FiliereDTO(updatedFiliere.getId(), updatedFiliere.getNomFiliere()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiliere(@PathVariable Long id) {
        filiereService.deleteFiliere(id);
        return ResponseEntity.noContent().build();
    }

    
}
