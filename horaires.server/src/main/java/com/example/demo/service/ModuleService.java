package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Filiere;
import com.example.demo.entity.Intervention;
import com.example.demo.entity.Modules;
import com.example.demo.repository.FiliereRepository;
import com.example.demo.repository.ModuleRepository;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;
    
    @Autowired
    private FiliereRepository filiereRepository;

    public Modules saveModule(Modules module) {
        return moduleRepository.save(module);
    }

    public List<Modules> getAllModules() {
        return moduleRepository.findAll();
    }

    public Modules getModuleById(Long id) {
        return moduleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Module not found"));
    }

    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }

    public Modules updateModule(Long id, Modules updatedModule) {
        if (moduleRepository.existsById(id)) {
            updatedModule.setId(id);
            return moduleRepository.save(updatedModule);
        }
        return null;
    }

    public Modules addInterventionToModule(Long moduleId, Intervention intervention) {
        Modules module = moduleRepository.findById(moduleId)
            .orElseThrow(() -> new RuntimeException("Module not found"));

        intervention.setModule(module);
        module.getInterventions().add(intervention);
        moduleRepository.save(module);
        return module;
    }

    public Modules addModuleToFiliere(Long moduleId, Long filiereId) {
        Modules module = moduleRepository.findById(moduleId)
            .orElseThrow(() -> new RuntimeException("Module not found"));
        Filiere filiere = filiereRepository.findById(filiereId)
            .orElseThrow(() -> new RuntimeException("Filiere not found"));
        
        module.setFiliere(filiere);
        return moduleRepository.save(module);
    }
}
