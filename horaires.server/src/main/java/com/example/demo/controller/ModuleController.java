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
import com.example.demo.entity.Modules;
import com.example.demo.service.ModuleService;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {
	@Autowired
	private ModuleService moduleService;
	
	@PostMapping
	public ResponseEntity<Modules> createModule(@RequestBody Modules module){
		return ResponseEntity.ok(moduleService.saveModule(module));
	}
	
	@GetMapping
	public ResponseEntity<List<Modules>> getAllModules(){
		return ResponseEntity.ok(moduleService.getAllModules());
	}
	@GetMapping("/{id}")
    public ResponseEntity<Modules> getModuleById(@PathVariable Long id) {
        return ResponseEntity.ok(moduleService.getModuleById(id));
    }
	@PutMapping("/{id}")
    public ResponseEntity<Modules> updateModule(@PathVariable Long id, @RequestBody Modules module) {
        return ResponseEntity.ok(moduleService.updateModule(id, module));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/{id}/interventions")
    public ResponseEntity<Modules> addInterventionToModule(@PathVariable Long id, @RequestBody Intervention intervention) {
        return ResponseEntity.ok(moduleService.addInterventionToModule(id, intervention));
    }

}
