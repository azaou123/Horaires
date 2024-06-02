package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Filiere;
import com.example.demo.entity.Intervention;
import com.example.demo.entity.Modules;
import com.example.demo.entity.Professeur;
import com.example.demo.repository.InterventionRepository;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.repository.ProfesseurRepository;

@Service
public class InterventionService {
	@Autowired
	private InterventionRepository interventionRepository;
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private ProfesseurRepository professeurRepository;
	
	public Intervention saveIntervention(Intervention intervention) {
		return interventionRepository.save(intervention);
	}
	
	public List<Intervention> getAllInterventions(){
		return interventionRepository.findAll();
	}
	public Intervention getInterventionById(Long id) {
        return interventionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Intervention not found"));
    }
	
	public void deleteIntervention(Long id) {
        interventionRepository.deleteById(id);
    }

    public Intervention updateIntervention(Long id, Intervention updatedIntervention) {
        if (interventionRepository.existsById(id)) {
            updatedIntervention.setId(id);
            return interventionRepository.save(updatedIntervention);
        }
        return null;
    }
    public Intervention addInterventionToModule(Long interventionId, Long moduleId) {
        Intervention intervention = interventionRepository.findById(interventionId)
            .orElseThrow(() -> new RuntimeException("Intervention not found"));
        Modules module = moduleRepository.findById(moduleId)
            .orElseThrow(() -> new RuntimeException("Module not found"));
        
        intervention.setModule(module);
        return interventionRepository.save(intervention);
    }
    public Intervention addInterventionToProfesseur(Long interventionId, Long professeurId) {
        Intervention intervention = interventionRepository.findById(interventionId)
                .orElseThrow(() -> new RuntimeException("Intervention not found"));
        Professeur professeur = professeurRepository.findById(professeurId)
                .orElseThrow(() -> new RuntimeException("Professeur not found"));

        intervention.setProfesseur(professeur);
        return interventionRepository.save(intervention);
    }

}
