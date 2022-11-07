package com.cm.rh.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rh_demandeConge")
public class DemandeConge {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date dateDemande= new Date();
	private Date dateDebut;
	private Date dateFin;
	private double duree;
	@ManyToOne
	private Personnel personnel;
	
	@ManyToOne
	private StatutDemandeConge statut;
	
	@ManyToOne
	private TypeConge type;
	
	public DemandeConge() {
		super();
		
	}

	public DemandeConge(Date dateDemande, Date dateDebut, Date dateFin, double duree, Personnel personnel,
			StatutDemandeConge statut, TypeConge type) {
		super();
		this.dateDemande = dateDemande;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.duree = duree;
		this.personnel = personnel;
		this.statut = statut;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public StatutDemandeConge getStatut() {
		return statut;
	}

	public void setStatut(StatutDemandeConge statut) {
		this.statut = statut;
	}

	public TypeConge getType() {
		return type;
	}

	public void setType(TypeConge type) {
		this.type = type;
	}

	
	
	
	

}
