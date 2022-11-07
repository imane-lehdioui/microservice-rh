package com.cm.rh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rh_specialiteDiplome")
public class SpecialiteDiplome {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String libelle;
	
	public SpecialiteDiplome() {
		super();
		
	}

	public SpecialiteDiplome(String libelle) {
		super();
		this.libelle = libelle;
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
	
	
	
	

}
