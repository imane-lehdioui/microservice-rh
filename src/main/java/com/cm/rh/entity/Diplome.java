package com.cm.rh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rh_diplome")
public class Diplome {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String libelle;
	private String anneeDiplome;

	public Diplome() {
		super();

	}

	public Diplome(String libelle, String anneeDiplome) {
		super();
		this.libelle = libelle;
		this.anneeDiplome = anneeDiplome;
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

	public String getAnneeDiplome() {
		return anneeDiplome;
	}

	public void setAnneeDiplome(String anneeDiplome) {
		this.anneeDiplome = anneeDiplome;
	}

}
