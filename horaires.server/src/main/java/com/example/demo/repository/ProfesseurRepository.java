package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Professeur;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur,Long>{
	Professeur findByEmail(String email);

}
