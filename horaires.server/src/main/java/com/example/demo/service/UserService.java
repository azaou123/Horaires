package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Etudiant;
import com.example.demo.entity.Filiere;
import com.example.demo.entity.Intervention;
import com.example.demo.entity.Professeur;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.repository.FiliereRepository;
import com.example.demo.repository.InterventionRepository;
import com.example.demo.repository.ProfesseurRepository;

@Service
public class UserService {
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private ProfesseurRepository professeurRepository;
	
	@Autowired
    private InterventionRepository interventionRepository;
	
	@Autowired
    private FiliereRepository filiereRepository;
	//Etudiant
	
	public Etudiant saveEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}
	public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }
	
	public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElseThrow(() -> new RuntimeException("Etudiant not found"));
    }

    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    public Etudiant updateEtudiant(Long id, Etudiant updatedEtudiant) {
        if (etudiantRepository.existsById(id)) {
            updatedEtudiant.setId(id);
            return etudiantRepository.save(updatedEtudiant);
        }
        return null;
    }
    
    public Etudiant addEtudiantToFiliere(Long filiereId, Etudiant etudiant) {
        Filiere filiere = filiereRepository.findById(filiereId)
                .orElseThrow(() -> new RuntimeException("Filiere not found"));

        etudiant.setFiliere(filiere);
        return etudiantRepository.save(etudiant);
    }

    
    //Professeur
	
	public Professeur saveProfesseur(Professeur professeur) {
		return professeurRepository.save(professeur);
	}
	public List<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }
	
	public Professeur getProfesseurById(Long id) {
        return professeurRepository.findById(id).orElseThrow(() -> new RuntimeException("Professeur not found"));
    }


    public void deleteProfesseur(Long id) {
        professeurRepository.deleteById(id);
    }

    public Professeur updateProfesseur(Long id, Professeur updatedProfesseur) {
        if (professeurRepository.existsById(id)) {
            updatedProfesseur.setId(id);
            return professeurRepository.save(updatedProfesseur);
        }
        return null;
    }
    
    /*public Intervention addInterventionToProfesseur(Long professeurId, Intervention intervention) {
        Professeur professeur = professeurRepository.findById(professeurId)
            .orElseThrow(() -> new RuntimeException("Professeur not found"));

        intervention.setProfesseur(professeur);
        return interventionRepository.save(intervention);
    }*/

}