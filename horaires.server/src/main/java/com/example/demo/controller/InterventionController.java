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

import com.example.demo.entity.Intervention;
import com.example.demo.service.InterventionService;

@RestController
@RequestMapping("/api/interventions")
public class InterventionController {
	
	@Autowired
	private InterventionService interventionService;
	
	@PostMapping
	public ResponseEntity<Intervention> createIntervention(@RequestBody Intervention intervention){
		return ResponseEntity.ok(interventionService.saveIntervention(intervention));
	}
	
	@GetMapping
	public ResponseEntity<List<Intervention>> getAllInterventions(){
		return ResponseEntity.ok(interventionService.getAllInterventions());
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Intervention> getInterventionById(@PathVariable Long id) {
        return ResponseEntity.ok(interventionService.getInterventionById(id));
    }
	@PutMapping("/{id}")
    public ResponseEntity<Intervention> updateIntervention(@PathVariable Long id, @RequestBody Intervention intervention) {
        return ResponseEntity.ok(interventionService.updateIntervention(id, intervention));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIntervention(@PathVariable Long id) {
        interventionService.deleteIntervention(id);
        return ResponseEntity.noContent().build();
    }

}
