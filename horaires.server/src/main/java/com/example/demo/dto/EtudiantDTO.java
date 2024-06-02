package com.example.demo.dto;

import com.example.demo.entity.Etudiant;

public class EtudiantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private Long filiereId; // Changed to Long type for module ID

    // Constructor
    public EtudiantDTO() {
    }
    public EtudiantDTO(Etudiant etudiant) {
        this.id = etudiant.getId();
        this.nom = etudiant.getNom();
        this.prenom = etudiant.getPrenom();
        this.email = etudiant.getEmail();
        if (etudiant.getFiliere() != null) {
            this.filiereId = etudiant.getFiliere().getId(); // Set the module ID
        } else {
            this.filiereId = null; // If module is null, set ID to null
        }
    }

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getFiliereId() {
        return filiereId;
    }
    public void setFiliereId(Long filiereId) {
        this.filiereId = filiereId;
    }
}
