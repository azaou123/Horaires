package com.example.demo.controller;

import java.util.List;

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
	public ResponseEntity<Filiere> createFiliere(@RequestBody Filiere filiere){
		return ResponseEntity.ok(filiereService.saveFiliere(filiere));
	}
	
	@GetMapping
	public ResponseEntity<List<Filiere>> getAllFilieres(){
		return ResponseEntity.ok(filiereService.getAllFilieres());
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Filiere> getFiliereById(@PathVariable Long id) {
        return ResponseEntity.ok(filiereService.getFiliereById(id));
    }
	@PutMapping("/{id}")
    public ResponseEntity<Filiere> updateFiliere(@PathVariable Long id, @RequestBody Filiere filiere) {
        return ResponseEntity.ok(filiereService.updateFiliere(id, filiere));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFiliere(@PathVariable Long id) {
        filiereService.deleteFiliere(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/{id}/modules")
    public ResponseEntity<Filiere> addModuleToFiliere(@PathVariable Long id, @RequestBody Modules module) {
        return ResponseEntity.ok(filiereService.addModuleToFiliere(id, module));
    }

    @PostMapping("/{id}/etudiants")
    public ResponseEntity<Filiere> addEtudiantToFiliere(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        return ResponseEntity.ok(filiereService.addEtudiantToFiliere(id, etudiant));
    }

}
