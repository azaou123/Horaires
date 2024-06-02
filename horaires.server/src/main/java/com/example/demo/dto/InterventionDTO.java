package com.example.demo.dto;

public class InterventionDTO {
    private Long id;
    private String intitule;
    private int nombreHeuresCoursInter;
    private int nombreHeuresTDInter;
    private int nombreHeuresTPInter;
    private int nombreEvaluationsInter;
    private Long professeurId;
    private Long moduleId;

    public InterventionDTO() {
    }

    public InterventionDTO(Long id, String intitule, int nombreHeuresCoursInter, int nombreHeuresTDInter,
            int nombreHeuresTPInter, int nombreEvaluationsInter, Long professeurId, Long moduleId) {
        this.id = id;
        this.intitule = intitule;
        this.nombreHeuresCoursInter = nombreHeuresCoursInter;
        this.nombreHeuresTDInter = nombreHeuresTDInter;
        this.nombreHeuresTPInter = nombreHeuresTPInter;
        this.nombreEvaluationsInter = nombreEvaluationsInter;
        this.professeurId = professeurId;
        this.moduleId = moduleId;
    }

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

	public Long getProfesseurId() {
		return professeurId;
	}

	public void setProfesseurId(Long professeurId) {
		this.professeurId = professeurId;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

    
}
