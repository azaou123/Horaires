package com.example.demo.dto;

import java.util.List;

public class FiliereDTO {
    private Long id;
    private String nomFiliere;
    private List<Long> moduleIds;
    private List<Long> etudiantIds;

    // Constructors
    public FiliereDTO() {
    }

    public FiliereDTO(Long id, String nomFiliere) {
        this.id = id;
        this.nomFiliere = nomFiliere;
    }

    public FiliereDTO(Long id, String nomFiliere, List<Long> moduleIds, List<Long> etudiantIds) {
        this.id = id;
        this.nomFiliere = nomFiliere;
        this.moduleIds = moduleIds;
        this.etudiantIds = etudiantIds;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

    public List<Long> getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(List<Long> moduleIds) {
        this.moduleIds = moduleIds;
    }

    public List<Long> getEtudiantIds() {
        return etudiantIds;
    }

    public void setEtudiantIds(List<Long> etudiantIds) {
        this.etudiantIds = etudiantIds;
    }
}
