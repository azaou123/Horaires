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

import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/etudiant")

public class EtudiantController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createEtudiant(@RequestBody Etudiant etudiant) {
        System.out.println("Received request to create etudiant: " + etudiant);
        userService.saveEtudiant(etudiant);
        return ResponseEntity.ok("Etudiant registered successfully");
    }


    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        return ResponseEntity.ok(userService.getAllEtudiants());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getEtudiantById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        return ResponseEntity.ok(userService.updateEtudiant(id, etudiant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        userService.deleteEtudiant(id);
        return ResponseEntity.noContent().build();
    }
}
