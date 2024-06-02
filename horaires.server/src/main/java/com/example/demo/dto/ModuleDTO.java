package com.example.demo.dto;

import java.util.List;

public class ModuleDTO {
    private Long id;
    private String intitule;
    private int nombreHeuresCours;
    private int nombreHeuresTD;
    private int nombreHeuresTP;
    private int nombreEvaluations;
    private Long filiereId;
    private List<Long> interventionIds;

    public ModuleDTO() {
    }

    public ModuleDTO(Long id, String intitule, int nombreHeuresCours, int nombreHeuresTD, int nombreHeuresTP, int nombreEvaluations) {
        this.id = id;
        this.intitule = intitule;
        this.nombreHeuresCours = nombreHeuresCours;
        this.nombreHeuresTD = nombreHeuresTD;
        this.nombreHeuresTP = nombreHeuresTP;
        this.nombreEvaluations = nombreEvaluations;
    }

    public ModuleDTO(Long id, String intitule, int nombreHeuresCours, int nombreHeuresTD, int nombreHeuresTP, int nombreEvaluations, Long filiereId, List<Long> interventionIds) {
        this.id = id;
        this.intitule = intitule;
        this.nombreHeuresCours = nombreHeuresCours;
        this.nombreHeuresTD = nombreHeuresTD;
        this.nombreHeuresTP = nombreHeuresTP;
        this.nombreEvaluations = nombreEvaluations;
        this.filiereId = filiereId;
        this.interventionIds = interventionIds;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getNombreHeuresCours() {
        return nombreHeuresCours;
    }

    public void setNombreHeuresCours(int nombreHeuresCours) {
        this.nombreHeuresCours = nombreHeuresCours;
    }

    public int getNombreHeuresTD() {
        return nombreHeuresTD;
    }

    public void setNombreHeuresTD(int nombreHeuresTD) {
        this.nombreHeuresTD = nombreHeuresTD;
    }

    public int getNombreHeuresTP() {
        return nombreHeuresTP;
    }

    public void setNombreHeuresTP(int nombreHeuresTP) {
        this.nombreHeuresTP = nombreHeuresTP;
    }

    public int getNombreEvaluations() {
        return nombreEvaluations;
    }

    public void setNombreEvaluations(int nombreEvaluations) {
        this.nombreEvaluations = nombreEvaluations;
    }

    public Long getFiliereId() {
        return filiereId;
    }

    public void setFiliereId(Long filiereId) {
        this.filiereId = filiereId;
    }

    public List<Long> getInterventionIds() {
        return interventionIds;
    }

    public void setInterventionIds(List<Long> interventionIds) {
        this.interventionIds = interventionIds;
    }
}
