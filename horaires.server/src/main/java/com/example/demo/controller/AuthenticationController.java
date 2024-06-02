package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Etudiant;
import com.example.demo.entity.Professeur;
import com.example.demo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/admin")
    public ResponseEntity<String> authenticateAdmin(@RequestBody Admin admin) {
        boolean authenticated = authenticationService.authenticateAdmin(admin.getEmail(), admin.getPassword());
        if (authenticated) {
            return ResponseEntity.ok("Admin authentication successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Admin authentication failed");
        }
    }

    @PostMapping("/etudiant")
    public ResponseEntity<String> authenticateEtudiant(@RequestBody Etudiant etudiant) {
        boolean authenticated = authenticationService.authenticateEtudiant(etudiant.getEmail(), etudiant.getPassword());
        if (authenticated) {
            return ResponseEntity.ok("Etudiant authentication successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Etudiant authentication failed");
        }
    }

    @PostMapping("/professeur")
    public ResponseEntity<String> authenticateProfesseur(@RequestBody Professeur professeur) {
        boolean authenticated = authenticationService.authenticateProfesseur(professeur.getEmail(), professeur.getPassword());
        if (authenticated) {
            return ResponseEntity.ok("Professeur authentication successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Professeur authentication failed");
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        authenticationService.logout();
        return ResponseEntity.ok("Logged out successfully");
    }
}
