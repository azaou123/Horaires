package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Etudiant;
import com.example.demo.entity.Professeur;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.repository.ProfesseurRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ProfesseurRepository professeurRepository;
    
    

    public boolean authenticateAdmin(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);
        return admin != null && admin.getPassword().equals(password);
    }

    public boolean authenticateEtudiant(String email, String password) {
        Etudiant etudiant = etudiantRepository.findByEmail(email);
        return etudiant != null && etudiant.getPassword().equals(password);
    }

    public boolean authenticateProfesseur(String email, String password) {
        Professeur professeur = professeurRepository.findByEmail(email);
        return professeur != null && professeur.getPassword().equals(password);
    }
    public void logout() {
        // Log out the current user
        SecurityContextHolder.clearContext();
    }
    
}
