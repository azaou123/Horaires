package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Intervention;
import com.example.demo.repository.InterventionRepository;

@Service
public class InterventionService {
	@Autowired
	private InterventionRepository interventionRepository;
	
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

}
