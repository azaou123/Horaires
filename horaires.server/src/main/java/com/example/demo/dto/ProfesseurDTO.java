package com.example.demo.dto;

import java.util.List;

public class ProfesseurDTO {
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
    private List<Long> interventionIds;
    
    
    
	public ProfesseurDTO() {
		super();
	}
	

	public ProfesseurDTO(Long id, String nom, String prenom, String email, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}


	public ProfesseurDTO(Long id, String nom, String prenom, String email, String password,
			List<Long> interventionIds) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.interventionIds = interventionIds;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Long> getInterventionIds() {
		return interventionIds;
	}


	public void setInterventionIds(List<Long> interventionIds) {
		this.interventionIds = interventionIds;
	}
	
	
    
    


}
