package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.InterventionDTO;
import com.example.demo.dto.ModuleDTO;
import com.example.demo.entity.Intervention;
import com.example.demo.entity.Modules;
import com.example.demo.entity.Professeur;
import com.example.demo.service.InterventionService;

@RestController
@RequestMapping("/api/interventions")
public class InterventionController {
    
    @Autowired
    private InterventionService interventionService;
    
    @PostMapping
    public ResponseEntity<InterventionDTO> createIntervention(@RequestBody InterventionDTO interventionDTO){
        Intervention intervention = new Intervention();
        intervention.setIntitule(interventionDTO.getIntitule());
        intervention.setNombreHeuresCoursInter(interventionDTO.getNombreHeuresCoursInter());
        intervention.setNombreHeuresTDInter(interventionDTO.getNombreHeuresTDInter());
        intervention.setNombreHeuresTPInter(interventionDTO.getNombreHeuresTPInter());
        intervention.setNombreEvaluationsInter(interventionDTO.getNombreEvaluationsInter());
        
        // Here we should set the Professeur object instead of ProfesseurId
        Professeur professeur = new Professeur();
        professeur.setId(interventionDTO.getProfesseurId());
        intervention.setProfesseur(professeur);
        
        // Similarly, set the Module object instead of ModuleId
        Modules module = new Modules();
        module.setId(interventionDTO.getModuleId());
        intervention.setModule(module);
        
        Intervention savedIntervention = interventionService.saveIntervention(intervention);
        InterventionDTO savedInterventionDTO = new InterventionDTO(savedIntervention.getId(),
                savedIntervention.getIntitule(), savedIntervention.getNombreHeuresCoursInter(),
                savedIntervention.getNombreHeuresTDInter(), savedIntervention.getNombreHeuresTPInter(),
                savedIntervention.getNombreEvaluationsInter(), savedIntervention.getProfesseur().getId(),
                savedIntervention.getModule().getId());
        
        return ResponseEntity.ok(savedInterventionDTO);
    }
    
    @GetMapping
    public ResponseEntity<List<InterventionDTO>> getAllInterventions(){
        List<Intervention> interventions = interventionService.getAllInterventions();
        List<InterventionDTO> interventionDTOs = interventions.stream().map(i -> {
            return new InterventionDTO(i.getId(), i.getIntitule(), i.getNombreHeuresCoursInter(),
                i.getNombreHeuresTDInter(), i.getNombreHeuresTPInter(), i.getNombreEvaluationsInter(),
                i.getProfesseur().getId(), i.getModule().getId());
        }).collect(Collectors.toList());
        return ResponseEntity.ok(interventionDTOs);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<InterventionDTO> getInterventionById(@PathVariable Long id) {
        Intervention intervention = interventionService.getInterventionById(id);
        if (intervention != null) {
            InterventionDTO interventionDTO = new InterventionDTO(intervention.getId(), intervention.getIntitule(),
                    intervention.getNombreHeuresCoursInter(), intervention.getNombreHeuresTDInter(),
                    intervention.getNombreHeuresTPInter(), intervention.getNombreEvaluationsInter(),
                    intervention.getProfesseur().getId(), intervention.getModule().getId());
            return ResponseEntity.ok(interventionDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<InterventionDTO> updateIntervention(@PathVariable Long id,
            @RequestBody InterventionDTO interventionDTO) {
        Intervention intervention = new Intervention();
        intervention.setId(id);
        intervention.setIntitule(interventionDTO.getIntitule());
        intervention.setNombreHeuresCoursInter(interventionDTO.getNombreHeuresCoursInter());
        intervention.setNombreHeuresTDInter(interventionDTO.getNombreHeuresTDInter());
        intervention.setNombreHeuresTPInter(interventionDTO.getNombreHeuresTPInter());
        intervention.setNombreEvaluationsInter(interventionDTO.getNombreEvaluationsInter());
        
        // Set the Professeur object instead of ProfesseurId
        Professeur professeur = new Professeur();
        professeur.setId(interventionDTO.getProfesseurId());
        intervention.setProfesseur(professeur);
        
        // Set the Module object instead of ModuleId
        Modules module = new Modules();
        module.setId(interventionDTO.getModuleId());
        intervention.setModule(module);
        
        Intervention updatedIntervention = interventionService.updateIntervention(id, intervention);
        if (updatedIntervention != null) {
            InterventionDTO updatedInterventionDTO = new InterventionDTO(updatedIntervention.getId(),
                    updatedIntervention.getIntitule(), updatedIntervention.getNombreHeuresCoursInter(),
                    updatedIntervention.getNombreHeuresTDInter(), updatedIntervention.getNombreHeuresTPInter(),
                    updatedIntervention.getNombreEvaluationsInter(), updatedIntervention.getProfesseur().getId(),
                    updatedIntervention.getModule().getId());
            return ResponseEntity.ok(updatedInterventionDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIntervention(@PathVariable Long id) {
        interventionService.deleteIntervention(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/{id}/module/{moduleId}")
    public ResponseEntity<InterventionDTO> addInterventionToModule(@PathVariable Long id, @PathVariable Long moduleId) {
        Intervention updatedIntervention = interventionService.addInterventionToModule(id, moduleId);
        InterventionDTO interventionDTO = new InterventionDTO(updatedIntervention.getId(), updatedIntervention.getIntitule(), 
                updatedIntervention.getNombreHeuresCoursInter(), updatedIntervention.getNombreHeuresTDInter(), 
                updatedIntervention.getNombreHeuresTPInter(), updatedIntervention.getNombreEvaluationsInter(), 
                updatedIntervention.getProfesseur() != null ? updatedIntervention.getProfesseur().getId() : null,
                updatedIntervention.getModule() != null ? updatedIntervention.getModule().getId() : null);
        return ResponseEntity.ok(interventionDTO);
    }
    @PostMapping("/{id}/professeur/{professeurId}")
    public ResponseEntity<InterventionDTO> addInterventionToProfesseur(@PathVariable Long id, @PathVariable Long professeurId) {
        Intervention updatedIntervention = interventionService.addInterventionToProfesseur(id, professeurId);
        InterventionDTO interventionDTO = new InterventionDTO(updatedIntervention.getId(), updatedIntervention.getIntitule(), 
                updatedIntervention.getNombreHeuresCoursInter(), updatedIntervention.getNombreHeuresTDInter(), 
                updatedIntervention.getNombreHeuresTPInter(), updatedIntervention.getNombreEvaluationsInter(), 
                updatedIntervention.getProfesseur() != null ? updatedIntervention.getProfesseur().getId() : null,
                updatedIntervention.getModule() != null ? updatedIntervention.getModule().getId() : null);
        return ResponseEntity.ok(interventionDTO);
    }


}
