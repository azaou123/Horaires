package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Etudiant;
import com.example.demo.entity.Filiere;
import com.example.demo.entity.Modules;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.repository.FiliereRepository;
import com.example.demo.repository.ModuleRepository;

@Service
public class FiliereService {
    @Autowired
    private FiliereRepository filiereRepository;
    
    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;
    
    public Filiere saveFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }
    
    public List<Filiere> getAllFilieres() {
        return filiereRepository.findAll();
    }
    
    public Filiere getFiliereById(Long id) {
        return filiereRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Filiere not found"));
    }
    
    public void deleteFiliere(Long id) {
        filiereRepository.deleteById(id);
    }

    public Filiere updateFiliere(Long id, Filiere updatedFiliere) {
        if (filiereRepository.existsById(id)) {
            updatedFiliere.setId(id);
            return filiereRepository.save(updatedFiliere);
        }
        return null;
    }
    
   /* public Filiere addModuleToFiliere(Long filiereId, Modules module) {
        Filiere filiere = getFiliereById(filiereId);
        module.setFiliere(filiere);
        moduleRepository.save(module);
        return filiere;
    }*/

    /*public Filiere addEtudiantToFiliere(Long filiereId, Etudiant etudiant) {
        Filiere filiere = getFiliereById(filiereId);
        etudiant.setFiliere(filiere);
        etudiantRepository.save(etudiant);
        return filiere;
    }*/
}
