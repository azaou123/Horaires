package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Modules {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String intitule;
	private int nombreHeuresCours;
	private int nombreHeuresTD;
	private int nombreHeuresTP;
	private int nombreEvaluations;
	
	@ManyToOne
	@JoinColumn(name = "filier_id")
	private Filiere filiere;
	
	@OneToMany(mappedBy = "module")
	private List<Intervention> interventions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getNombreHeuresCours() {
		return nombreHeuresCours;
	}

	public void setNombreHeuresCours(int nombreHeuresCours) {
		this.nombreHeuresCours = nombreHeuresCours;
	}

	public int getNombreHeuresTD() {
		return nombreHeuresTD;
	}

	public void setNombreHeuresTD(int nombreHeuresTD) {
		this.nombreHeuresTD = nombreHeuresTD;
	}

	public int getNombreHeuresTP() {
		return nombreHeuresTP;
	}

	public void setNombreHeuresTP(int nombreHeuresTP) {
		this.nombreHeuresTP = nombreHeuresTP;
	}

	public int getNombreEvaluations() {
		return nombreEvaluations;
	}

	public void setNombreEvaluations(int nombreEvaluations) {
		this.nombreEvaluations = nombreEvaluations;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public List<Intervention> getInterventions() {
		return interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	
	

}
