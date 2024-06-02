package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.ModuleDTO;
import com.example.demo.entity.Modules;
import com.example.demo.entity.Intervention;
import com.example.demo.service.ModuleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @PostMapping
    public ResponseEntity<ModuleDTO> createModule(@RequestBody ModuleDTO moduleDTO) {
        Modules module = new Modules();
        module.setIntitule(moduleDTO.getIntitule());
        module.setNombreHeuresCours(moduleDTO.getNombreHeuresCours());
        module.setNombreHeuresTD(moduleDTO.getNombreHeuresTD());
        module.setNombreHeuresTP(moduleDTO.getNombreHeuresTP());
        module.setNombreEvaluations(moduleDTO.getNombreEvaluations());
        Modules savedModule = moduleService.saveModule(module);
        return ResponseEntity.ok(new ModuleDTO(savedModule.getId(), savedModule.getIntitule(),
                savedModule.getNombreHeuresCours(), savedModule.getNombreHeuresTD(), savedModule.getNombreHeuresTP(),
                savedModule.getNombreEvaluations(), savedModule.getFiliere() != null ? savedModule.getFiliere().getId() : null,
                savedModule.getInterventions().stream().map(Intervention::getId).collect(Collectors.toList())));
    }

    @GetMapping
    public ResponseEntity<List<ModuleDTO>> getAllModules() {
        List<Modules> modules = moduleService.getAllModules();
        List<ModuleDTO> moduleDTOs = modules.stream().map(m -> new ModuleDTO(m.getId(), m.getIntitule(),
                m.getNombreHeuresCours(), m.getNombreHeuresTD(), m.getNombreHeuresTP(), m.getNombreEvaluations(),
                m.getFiliere() != null ? m.getFiliere().getId() : null,
                m.getInterventions().stream().map(Intervention::getId).collect(Collectors.toList())))
                .collect(Collectors.toList());
        return ResponseEntity.ok(moduleDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuleDTO> getModuleById(@PathVariable Long id) {
        Modules module = moduleService.getModuleById(id);
        if (module != null) {
            return ResponseEntity.ok(new ModuleDTO(module.getId(), module.getIntitule(),
                    module.getNombreHeuresCours(), module.getNombreHeuresTD(), module.getNombreHeuresTP(),
                    module.getNombreEvaluations(), module.getFiliere() != null ? module.getFiliere().getId() : null,
                    module.getInterventions().stream().map(Intervention::getId).collect(Collectors.toList())));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuleDTO> updateModule(@PathVariable Long id, @RequestBody ModuleDTO moduleDTO) {
        Modules module = new Modules();
        module.setId(id);
        module.setIntitule(moduleDTO.getIntitule());
        module.setNombreHeuresCours(moduleDTO.getNombreHeuresCours());
        module.setNombreHeuresTD(moduleDTO.getNombreHeuresTD());
        module.setNombreHeuresTP(moduleDTO.getNombreHeuresTP());
        module.setNombreEvaluations(moduleDTO.getNombreEvaluations());
        Modules updatedModule = moduleService.updateModule(id, module);
        if (updatedModule != null) {
            return ResponseEntity.ok(new ModuleDTO(updatedModule.getId(), updatedModule.getIntitule(),
                    updatedModule.getNombreHeuresCours(), updatedModule.getNombreHeuresTD(),
                    updatedModule.getNombreHeuresTP(), updatedModule.getNombreEvaluations(),
                    updatedModule.getFiliere() != null ? updatedModule.getFiliere().getId() : null,
                    updatedModule.getInterventions().stream().map(Intervention::getId).collect(Collectors.toList())));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/interventions")
    public ResponseEntity<ModuleDTO> addInterventionToModule(@PathVariable Long id, @RequestBody Intervention intervention) {
        Modules updatedModule = moduleService.addInterventionToModule(id, intervention);
        ModuleDTO moduleDTO = new ModuleDTO(updatedModule.getId(), updatedModule.getIntitule(), 
                updatedModule.getNombreHeuresCours(), updatedModule.getNombreHeuresTD(), 
                updatedModule.getNombreHeuresTP(), updatedModule.getNombreEvaluations(), 
                updatedModule.getFiliere() != null ? updatedModule.getFiliere().getId() : null,
                updatedModule.getInterventions().stream().map(Intervention::getId).collect(Collectors.toList()));
        return ResponseEntity.ok(moduleDTO);
    }

    @PostMapping("/{id}/filiere/{filiereId}")
    public ResponseEntity<ModuleDTO> addModuleToFiliere(@PathVariable Long id, @PathVariable Long filiereId) {
        Modules updatedModule = moduleService.addModuleToFiliere(id, filiereId);
        ModuleDTO moduleDTO = new ModuleDTO(updatedModule.getId(), updatedModule.getIntitule(), 
                updatedModule.getNombreHeuresCours(), updatedModule.getNombreHeuresTD(), 
                updatedModule.getNombreHeuresTP(), updatedModule.getNombreEvaluations(), 
                updatedModule.getFiliere() != null ? updatedModule.getFiliere().getId() : null,
                updatedModule.getInterventions().stream().map(Intervention::getId).collect(Collectors.toList()));
        return ResponseEntity.ok(moduleDTO);
    }
}
