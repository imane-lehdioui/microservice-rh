package com.cm.rh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rh_statutDemandeAttestation")
public class StatutDemandeAttestation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String libelle;
	private boolean finale;

	public StatutDemandeAttestation() {
		super();

	}

	public StatutDemandeAttestation(String libelle, boolean finale) {
		super();
		this.libelle = libelle;
		this.finale = finale;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public boolean isFinale() {
		return finale;
	}

	public void setFinale(boolean finale) {
		this.finale = finale;
	}

}
