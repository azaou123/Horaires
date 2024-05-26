package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Professeur;
import com.example.demo.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Professeur> createProfesseur(@RequestBody Professeur professeur) {
        return ResponseEntity.ok(userService.saveProfesseur(professeur));
    }

    @GetMapping
    public ResponseEntity<List<Professeur>> getAllProfesseurs() {
        return ResponseEntity.ok(userService.getAllProfesseurs());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Professeur> getProfesseurById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getProfesseurById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professeur> updateProfesseur(@PathVariable Long id, @RequestBody Professeur professeur) {
        return ResponseEntity.ok(userService.updateProfesseur(id, professeur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfesseur(@PathVariable Long id) {
        userService.deleteProfesseur(id);
        return ResponseEntity.noContent().build();
    }
}

