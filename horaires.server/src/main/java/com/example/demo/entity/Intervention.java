package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Intervention {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String intitule;
	private int nombreHeuresCoursInter;
	private int nombreHeuresTDInter;
	private int nombreHeuresTPInter;
	private int nombreEvaluationsInter;
	
	@ManyToOne
	@JoinColumn(name = "professeur_id")
	private Professeur professeur;
	
	@ManyToOne
	@JoinColumn(name = "module_id")
	private Modules module;

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

	public int getNombreHeuresCoursInter() {
		return nombreHeuresCoursInter;
	}

	public void setNombreHeuresCoursInter(int nombreHeuresCoursInter) {
		this.nombreHeuresCoursInter = nombreHeuresCoursInter;
	}

	public int getNombreHeuresTDInter() {
		return nombreHeuresTDInter;
	}

	public void setNombreHeuresTDInter(int nombreHeuresTDInter) {
		this.nombreHeuresTDInter = nombreHeuresTDInter;
	}

	public int getNombreHeuresTPInter() {
		return nombreHeuresTPInter;
	}

	public void setNombreHeuresTPInter(int nombreHeuresTPInter) {
		this.nombreHeuresTPInter = nombreHeuresTPInter;
	}

	public int getNombreEvaluationsInter() {
		return nombreEvaluationsInter;
	}

	public void setNombreEvaluationsInter(int nombreEvaluationsInter) {
		this.nombreEvaluationsInter = nombreEvaluationsInter;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}

	public Modules getModule() {
		return module;
	}

	public void setModule(Modules module) {
		this.module = module;
	}
	
	

}
